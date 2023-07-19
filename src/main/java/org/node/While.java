package org.node;

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
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: While node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);

        System.out.format("while%d:\n", whileNum);

        Err condErr = cond.codegen(tree);
        if (condErr.errno != Err.Errno.OK) return condErr;

        if (cond.exprTy != Expression.ExprTy.BOOL)
            return new Err(Err.Errno.ERR_COND, lineno, "Condition must be bool type!!!");

        System.out.format("    br i1 %%t%d, label %%body_while%d, label %%next%d\n",
                    cond.tmpNum, whileNum, nextNum);

        System.out.format("body_while%d:\n", whileNum);
        Err blockOfStmtsErr = blockOfStmts.codegen(tree);
        if (blockOfStmtsErr.errno != Err.Errno.OK) return blockOfStmtsErr;
        System.out.format("    br label %%while%d\n", whileNum);

        System.out.format("next%d:\n", nextNum);

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);
            Err nextErr = nextNode.codegen(tree);
            if (nextErr.errno != Err.Errno.OK) return nextErr;
        }

        return new Err(Err.Errno.OK, -1, "");
    }
}
