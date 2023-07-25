package org.node.basic;

import org.error.Err;
import org.node.Expression;
import org.simplelang.Ast;

public class FloatP extends Expression {
    public float numValue;
    public FloatP() {super(); exprTy = ExprTy.FLOAT;}

    @Override
    public Err codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        System.out.format("    %%t%d = fadd float %f, 0.0\n", tmpNum, numValue);

        return new Err(Err.Errno.OK, -1, "");
    }
}
