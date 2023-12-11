package org.node.arithmetic;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Div extends Expression {
    public Div() {super();}

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

        if (lhs.exprTy == ExprTy.BOOL || rhs.exprTy == ExprTy.BOOL) {
            // return ;
            Stack<Err> stackErrs = new Stack<Err>();
            stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't do addition with bool and other type!!"));
            return stackErrs;
        }

        if (lhs.exprTy == rhs.exprTy) {
            switch (lhs.exprTy) {
                case INT : {
                    exprTy = ExprTy.INT;
                    System.out.format("    %%t%d = udiv i32 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
                case FLOAT : {
                    exprTy = ExprTy.FLOAT;
                    System.out.format("    %%t%d = fdiv double %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
                default: break;
            }
        }
        else {
            // return ;
            Stack<Err> stackErrs = new Stack<Err>();
            stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't do division with int and float!!"));
            return stackErrs;
        }

        return new Stack<Err>();
    }
}
