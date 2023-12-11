package org.node;

import org.error.Err;
import org.error.Err.Errno;
import org.node.Expression.ExprTy;
import org.simplelang.Ast;

public class Return extends Statement {
    public ExprTy retType;
    public Expression retExpr;

    public Return() {
        super();
    }

    @Override
    public Err codegen(Ast tree) {
        Err exprErr = retExpr.codegen(tree);
        if (exprErr.errno != Errno.OK) return exprErr;

        retType = retExpr.exprTy;
        switch (retType) {
            case INT : {
                System.out.format("    ret i32 %%t%d\n", retExpr.tmpNum);
                break;
            }
            case FLOAT : {
                System.out.format("    ret double %%t%d\n", retExpr.tmpNum);
                break;
            }
            case BOOL : {
                System.out.format("    ret i1 %%t%d\n", retExpr.tmpNum);
                break;
            }
            case CHAR : {
                System.out.format("    ret i8 %%t%d\n", retExpr.tmpNum);
                break;
            }
            default : {
                return new Err(Errno.ERR_TY, lineno, "Undefined type!!");
            }
        }

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);

            Err nextErr = nextNode.codegen(tree);
            if (nextErr.errno != Err.Errno.OK) return nextErr;
        }

        return new Err(Errno.OK, -1, "");
    }
}
