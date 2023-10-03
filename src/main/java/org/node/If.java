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
        System.err.println("-------------------------------");
        System.err.format("(line %d)Node: If node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println("If-block contains return statement: " + blockOfStmts.containsRetStmt()); 
        System.err.println("If-node next num: " + nextNum);
        System.err.println(tree.symTable);
        System.err.println("-------------------------------");

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
            if (nextNode != null && !blockOfStmts.containsRetStmt()) {
                System.out.format("    br i1 %%t%d, label %%cond%d, label %%next%d\n",
                    cond.tmpNum, condNum, nextNum);    
            }
            else {
                System.out.format("    br label %%cond%d\n", condNum);
            }
        }

        System.out.format("cond%d: \n", condNum);

        Statement fstStmt = (Statement)blockOfStmts.getFirstStmt();
        if (fstStmt instanceof If) {
            System.out.format("    br label %%if%d\n", ((If)fstStmt).ifNum);
        }
        else if (fstStmt instanceof While) {
            System.out.format("    br label %%while%d\n", ((While)fstStmt).whileNum);
        }

        Err blockErr = blockOfStmts.codegen(tree);
        if (blockErr.errno != Err.Errno.OK) return blockErr;

        int jumpToNum = getJumpToNum();
        if (nextNode != null) {
            if (!blockOfStmts.containsRetStmt()) {
                    System.out.format("    br label %%next%d\n", jumpToNum);
                    System.out.format("next%d: \n", nextNum);
            }

            if (nextNode instanceof If) {
                System.out.format("    br label %%if%d\n", ((If) nextNode).ifNum);
            }
            else if (nextNode instanceof While) {
                System.out.format("    br label %%while%d\n", ((While) nextNode).whileNum);
            }
            
            Err nextErr = nextNode.codegen(tree);
            if (nextErr.errno != Err.Errno.OK) return nextErr;
        }
        else {
            if (!blockOfStmts.containsRetStmt()) {
                    System.out.format("    br label %%next%d\n", jumpToNum);
                    System.out.format("next%d: \n", nextNum);
            }
        }

        return new Err(Err.Errno.OK, -1, "");
    }

    private int getJumpToNum() {
        If currNode = new If(this);

        while (currNode.children.size() != 0) {
            if (currNode.isEmptyIf)
                break;
            else {
                if (!(currNode.children.get(0) instanceof If))
                    break;
                currNode = (If) currNode.children.get(0);
            }
        }

        return currNode.nextNum;
    }
}