package org.node;

import java.util.Stack;

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
    public Stack<Err> codegen(Ast tree) {
        Stack<Err> exprErrs = retExpr.codegen(tree);
        if (exprErrs.size() != 0) return exprErrs;

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
                Stack<Err> stackErrs = new Stack<Err>();
                stackErrs.add(new Err(Errno.ERR_TY, lineno, "Undefined type!!"));
                return stackErrs;
            }
        }

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);

            Stack<Err> nextErrs = nextNode.codegen(tree);
            if (nextErrs.size() != 0) return nextErrs;
        }

        return new Stack<Err>();
    }
}
