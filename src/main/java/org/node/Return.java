package org.node;

import java.util.Stack;

import org.error.Err;
import org.error.Err.Errno;
import org.node.Expression.ExprTy;
import org.node.basic.Var;
import org.simplelang.Ast;

public class Return extends Statement {
    public ExprTy retType;
    public Expression retExpr;

    public Return() {
        super();
    }

    @Override
    public Stack<Err> codegen(Ast tree) {
        Stack<Err> stackErrs = new Stack<Err>();

        Stack<Err> exprErrs = retExpr.codegen(tree);
        stackErrs.addAll(exprErrs);

        if (retExpr == null) {
            System.out.format("    ret void\n");
        }
        else {
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
                case ARRAY : {
                    System.out.format("    ret { i64, i8* } %%t%d\n", retExpr.tmpNum);
                    break;
                }
                default : {
                    stackErrs.push(new Err(Errno.ERR_TY, lineno, "Undefined type!!", errText));
                }
            }
        }

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);

            Stack<Err> nextErrs = nextNode.codegen(tree);
            stackErrs.addAll(nextErrs);
        }

        return stackErrs;
    }
}
