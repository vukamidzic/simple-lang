package org.node;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;

public class While extends Statement {
    static int whileCounter = 1;
    public int whileNum;
    public int nextNum;
    public Block blockOfStmts;
    public Expression cond;

    public While() {
        super();
        whileNum = whileCounter++;
        nextNum = nextCounter++;
    }

    @Override
    public Stack<Err> codegen(Ast tree) {
        System.err.format("(line %d)Node: While node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);

        System.out.format("while%d:\n", whileNum);

        Stack<Err> condErrs = cond.codegen(tree);
        if (condErrs.size() != 0) return condErrs;

        if (cond.exprTy != Expression.ExprTy.BOOL) {
            Stack<Err> stackErrs = new Stack<Err>();
            stackErrs.add(new Err(Err.Errno.ERR_COND, lineno, "Condition must be bool type!!!", errText));
            return stackErrs;
        }
            

        System.out.format("    br i1 %%t%d, label %%body_while%d, label %%next%d\n",
                    cond.tmpNum, whileNum, nextNum);

        System.out.format("body_while%d:\n", whileNum);
        Statement fstStmt = (Statement)blockOfStmts.getFirstStmt();
        if (fstStmt instanceof If) {
            System.out.format("    br label %%if%d\n", ((If)fstStmt).ifNum);
        }
        else if (fstStmt instanceof While) {
            System.out.format("    br label %%while%d\n", ((While)fstStmt).whileNum);
        }
        Stack<Err> blockOfStmtsErrs = blockOfStmts.codegen(tree);
        if (blockOfStmtsErrs.size() != 0) return blockOfStmtsErrs;
        System.out.format("    br label %%while%d\n", whileNum);

        System.out.format("next%d:\n", nextNum);

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);
            Stack<Err> nextErrs = nextNode.codegen(tree);
            if (nextErrs.size() != 0) return nextErrs;
        }

        return new Stack<Err>();
    }
}
