package org.node.basic;

import java.util.Stack;

import org.error.Err;
import org.node.Expression;
import org.simplelang.Ast;

public class FloatP extends Expression {
    public float numValue;
    public FloatP() {super(); exprTy = ExprTy.FLOAT;}

    @Override
    public Stack<Err> codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        System.out.format("    %%t%d = fadd double %f, 0.000000\n",
                tmpNum, numValue);

        return new Stack<Err>();
    }
}
