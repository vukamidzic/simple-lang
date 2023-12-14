package org.node.arithmetic;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Mul extends Expression {
    public Mul() {super();}

    @Override public Stack<Err> codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;
        Stack<Err> stackErrs = new Stack<Err>();

        Expression lhs = (Expression)children.get(0);
        Expression rhs = (Expression)children.get(1);

        Stack<Err> lhsErrs = lhs.codegen(tree);
        stackErrs.addAll(lhsErrs);
        Stack<Err> rhsErrs = rhs.codegen(tree);
        stackErrs.addAll(rhsErrs);

        if (lhs.exprTy == ExprTy.BOOL || rhs.exprTy == ExprTy.BOOL) {
            stackErrs.push(new Err(Err.Errno.ERR_TY, lineno, "Can't do addition with bool and other type!!", errText));
        }

        if (lhs.exprTy == rhs.exprTy) {
            switch (lhs.exprTy) {
                case INT : {
                    exprTy = ExprTy.INT;
                    System.out.format("    %%t%d = mul i32 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
                case FLOAT : {
                    exprTy = ExprTy.FLOAT;
                    System.out.format("    %%t%d = fmul double %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
                default : {
                    exprTy = ExprTy.UNDEFINED;
                    stackErrs.push(new Err(Err.Errno.ERR_TY, lineno, "Can't do multiplication with undefined values!!", errText));
                    break;
                }
            }
        }
        else {
            stackErrs.push(new Err(Err.Errno.ERR_TY, lineno, "Can't do multiplication with int and float!!", errText));
        }

        return stackErrs;
    }
}
