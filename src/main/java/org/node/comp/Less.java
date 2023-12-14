package org.node.comp;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Less extends Expression {
    public Less() {super(); exprTy = ExprTy.BOOL;}

    @Override
    public Stack<Err> codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;
        Stack<Err> stackErrs = new Stack<Err>();

        Expression lhs = (Expression)children.get(0);
        Expression rhs = (Expression)children.get(1);

        Stack<Err> lhsErrs = lhs.codegen(tree);
        stackErrs.addAll(lhsErrs);
        Stack<Err> rhsErrs = rhs.codegen(tree);
        stackErrs.addAll(rhsErrs);

        if (lhs.exprTy != rhs.exprTy) {
            stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't compare different types!!", errText));
        }
        else {
            switch (lhs.exprTy) {
                case INT: {
                    System.out.format("    %%t%d = icmp slt i32 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
                case FLOAT: {
                    System.out.format("    %%t%d = fcmp slt f32 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
                case BOOL: {
                    System.out.format("    %%t%d = icmp slt i1 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
            }
        }

        return stackErrs;
    }
}
