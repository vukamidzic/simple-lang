package org.node.basic;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Int extends Expression {
    public int numValue;
    public Int() {super(); exprTy = ExprTy.INT;}

    @Override
    public Err codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        System.out.format("    %%t%d = add i32 %d, 0\n", tmpNum, numValue);

        return new Err(Err.Errno.OK, -1, "");
    }
}
