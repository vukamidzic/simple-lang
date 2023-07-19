package org.node;

import org.simplelang.Ast;
import org.error.Err;

public class FuncCall extends Statement {
    static int funCallCounter = 1;
    public int funCallNum;
    public Expression outValue;

    public FuncCall() {super(); funCallNum = funCallCounter++;}

    @Override
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: FuncCall node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);
        Err outErr = outValue.codegen(tree);
        if (outErr.errno != Err.Errno.OK) return outErr;

        if (outValue.exprTy == Expression.ExprTy.INT)
            System.out.format("    call i32 (i8 *, ...)* @printf(i8* @s_i, i32 %%t%d)\n", outValue.tmpNum);
        else {
            System.out.format("    %%tmp%d = zext i1 %%t%d to i32\n", funCallNum, outValue.tmpNum);
            System.out.format("    call i32 (i8 *, ...)* @printf(i8* @s_i, i32 %%tmp%d)\n", funCallNum);
        }

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);

            if (nextNode instanceof While) {
                System.out.format("    br label %%while%d\n", ((While) nextNode).whileNum);
            }

            Err nextErr = nextNode.codegen(tree);
            if (nextErr.errno != Err.Errno.OK) return nextErr;
        }

        return new Err(Err.Errno.OK, -1, "");
    }
}