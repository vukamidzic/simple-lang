package org.node;

import org.error.Err;
import org.simplelang.Ast;

public class If extends Statement {
    public boolean isEmptyIf;

    static int ifCounter = 1;
    static int condCounter = 1;
    public int ifNum;
    public int condNum;
    public int nextNum;
    public Block blockOfStmts;
    public Expression cond;

    public If (boolean _isEmptyIf) {
        super();
        isEmptyIf = _isEmptyIf;
        ifNum = ifCounter++;
        condNum = condCounter++;
        nextNum = nextCounter++;
    }

    public If (If other) {
        isEmptyIf = other.isEmptyIf;
        ifNum = other.ifNum;
        condNum = other.condNum;
        nextNum = other.nextNum;
        blockOfStmts = other.blockOfStmts;
        cond = other.cond;
        children = other.children;
    }

    @Override
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: If node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);

        System.out.format("if%d:\n", ifNum);
        Err condErr = cond.codegen(tree);
        if (condErr.errno != Err.Errno.OK) return condErr;

        Statement nextNode = (children.size() != 0) ? (Statement) children.get(0) : null;
        if (nextNode instanceof If) {
            System.out.format("    br i1 %%t%d, label %%cond%d, label %%if%d\n",
                    cond.tmpNum, condNum, ((If) nextNode).ifNum);
        }
        else if (nextNode instanceof While) {
            System.out.format("    br i1 %%t%d, label %%cond%d, label %%while%d\n",
                    cond.tmpNum, condNum, ((While) nextNode).whileNum);
        }
        else {
            System.out.format("    br i1 %%t%d, label %%cond%d, label %%next%d\n",
                    cond.tmpNum, condNum, nextNum);
        }

        System.out.format("cond%d: \n", condNum);
        Err blockErr = blockOfStmts.codegen(tree);
        if (blockErr.errno != Err.Errno.OK) return blockErr;

        int jumpToNum = getJumpToNum();
        System.out.format("    br label %%next%d\n", jumpToNum);
        System.out.format("next%d: \n", nextNum);
        if (nextNode instanceof If) {
            System.out.format("    br label %%if%d\n", ((If) nextNode).ifNum);
        }
        else if (nextNode instanceof While) {
            System.out.format("    br label %%while%d\n", ((While) nextNode).whileNum);
        }


        if (nextNode != null) {
            Err nextErr = nextNode.codegen(tree);
            if (nextErr.errno != Err.Errno.OK) return nextErr;
        }

        return new Err(Err.Errno.OK, -1, "");
    }

    private int getJumpToNum() {
        If currNode = new If(this);

        while (currNode.children.size() != 0) {
            if (currNode.isEmptyIf)
                break;
            else {
                If nextNode = (If) currNode.children.get(0);
                if (nextNode == null)
                    break;
                currNode = nextNode;
            }
        }

        return currNode.nextNum;
    }
}
