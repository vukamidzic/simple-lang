package org.node.basic;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Char extends Expression {
    public char charValue;
    public Char() {super(); exprTy = ExprTy.CHAR;}

    @Override
    public Err codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        System.out.format("    %%t%d = add i8 %d, 0\n", tmpNum, (int)charValue);

        return new Err(Err.Errno.OK, -1, "");
    }
}
