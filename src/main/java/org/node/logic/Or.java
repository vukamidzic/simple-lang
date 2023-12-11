package org.node.logic;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Or extends Expression {
    public Or() {super(); exprTy = ExprTy.BOOL;}

    @Override
    public Stack<Err> codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        Expression lhs = (Expression)children.get(0);
        Expression rhs = (Expression)children.get(1);

        Stack<Err> lhsErrs = lhs.codegen(tree);
        if (lhsErrs.size() != 0) return lhsErrs;
        Stack<Err> rhsErrs = rhs.codegen(tree);
        if (rhsErrs.size() != 0) return rhsErrs;

        if (!(lhs.exprTy == ExprTy.BOOL && rhs.exprTy == ExprTy.BOOL)) {
            Stack<Err> stackErrs = new Stack<Err>();
            stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't logically OR non-boolean types!!"));
            return stackErrs;
        }

        System.out.format("    %%t%d = or i1 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
        return new Stack<Err>();
    }
}
