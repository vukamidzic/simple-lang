package org.node.arithmetic;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Plus extends Expression {
    public Plus() {super(); exprTy = ExprTy.INT;}

    @Override public Err codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        Expression lhs = (Expression)children.get(0);
        Expression rhs = (Expression)children.get(1);

        Err lhsErr = lhs.codegen(tree);
        if (lhsErr.errno != Err.Errno.OK) return lhsErr;
        Err rhsErr = rhs.codegen(tree);
        if (rhsErr.errno != Err.Errno.OK) return rhsErr;

        if (lhs.exprTy == ExprTy.BOOL || rhs.exprTy == ExprTy.BOOL) {
            return new Err(Err.Errno.ERR_TY, lineno, "Can't do addition with int and bool!!");
        }

        System.out.format("    %%t%d = add i32 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
        return new Err(Err.Errno.OK, -1, "");
    }
}
