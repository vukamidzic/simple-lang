package org.node.comp;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.error.Err.Errno;
import org.node.Expression;

public class Great extends Expression {
    public Great() {super(); exprTy = ExprTy.BOOL;}

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

        if (lhs.exprTy != rhs.exprTy) {
            Stack<Err> stackErrs = new Stack<Err>();
            stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't compare different types!!", errText));
            return stackErrs;
        }
        else {
            switch (lhs.exprTy) {
                case INT: {
                    System.out.format("    %%t%d = icmp sgt i32 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
                case FLOAT: {
                    System.out.format("    %%t%d = fcmp sgt f32 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
                case BOOL: {
                    System.out.format("    %%t%d = icmp sgt i1 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
                default : {
                    Stack<Err> stackErrs = new Stack<Err>();
                    stackErrs.add(new Err(Errno.ERR_TY, lineno, "Undefined type!!", errText));
                    return stackErrs;
                }
            }
        }

        return new Stack<Err>();
    }
}
