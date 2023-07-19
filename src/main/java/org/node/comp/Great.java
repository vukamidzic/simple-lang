package org.node.comp;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Great extends Expression {
    public Great() {super(); exprTy = ExprTy.BOOL;}

    @Override
    public Err codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        Expression lhs = (Expression)children.get(0);
        Expression rhs = (Expression)children.get(1);

        Err lhsErr = lhs.codegen(tree);
        if (lhsErr.errno != Err.Errno.OK) return lhsErr;
        Err rhsErr = rhs.codegen(tree);
        if (rhsErr.errno != Err.Errno.OK) return rhsErr;

        if (lhs.exprTy != rhs.exprTy) {
            return new Err(Err.Errno.ERR_TY, lineno, "Can't compare int and bool!!");
        }

        if (lhs.exprTy == ExprTy.INT)
            System.out.format("    %%t%d = icmp sgt i32 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
        else
            System.out.format("    %%t%d = icmp sgt i1 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);

        return new Err(Err.Errno.OK, -1, "");
    }
}
