package org.node.basic;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Pointer extends Expression {
    public enum PtrType {PTRINT, PTRFLOAT, PTRBOOL, PTRARRAY};
    public PtrType ptrTy;

    @Override
    public Stack<Err> codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;
        exprTy = ExprTy.PTR;

        Stack<Err> stackErrs = new Stack<>();

        Var value = (Var) children.get(0);
        if (value == null) {
            stackErrs.push(new Err(Err.Errno.ERR_TY, lineno, "Can't make pointer from non-variable", errText));
            return stackErrs;
        }
        Stack<Err> valueErrs = value.codegen(tree);
        stackErrs.addAll(valueErrs);

        int scopeIndex = tree.findVariableScope(value.varName);
        int varNum = tree.symTable.get(scopeIndex).get(value.varName).getValue1();
        switch(value.exprTy) {
            case INT : {
                this.ptrTy = PtrType.PTRINT;
                // System.out.format("    %%t%d = ptrtoint i32* %%%s.%d to i64\n", 
                //     tmpNum, value.varName, varNum
                // );
                // tmpNum = Expression.tmpCounter++;
                // System.out.format("    %%t%d = inttoptr i64 %%t%d to i32*\n", 
                //     tmpNum, tmpNum-2
                // );
                System.out.format("    %%t%d = alloca i32*\n", tmpNum);
                System.out.format("    store i32* %%%s.%d, i32** %%t%d\n", value.varName, varNum, tmpNum);
                break;
            }
            case FLOAT : {
                this.ptrTy = PtrType.PTRFLOAT;
                // System.out.format("    %%t%d = ptrtoint double* %%%s.%d to i64\n", 
                //     tmpNum, value.varName, varNum
                // );
                // tmpNum = Expression.tmpCounter++;
                // System.out.format("    %%t%d = inttoptr i64 %%t%d to double*\n", 
                //     tmpNum, tmpNum-2
                // );
                System.out.format("    %%t%d = alloca double*\n", tmpNum);
                System.out.format("    store double* %%%s.%d, double** %%t%d\n", value.varName, varNum, tmpNum);
                break;
            }
            // case BOOL : {
            //     this.ptrTy = PtrType.PTRBOOL;
            //     System.out.format("    %%t%d = ptrtoint i1* %%%s.%d to i64\n", 
            //         tmpNum, value.varName, varNum
            //     );
            //     tmpNum = Expression.tmpCounter++;
            //     System.out.format("    %%t%d = inttoptr i64 %%t%d to i1*\n", 
            //         tmpNum, tmpNum-2
            //     );

            //     break;
            // }
            // case ARRAY : {
            //     this.ptrTy = PtrType.PTRARRAY;
            //     System.out.format("    %%t%d = ptrtoint %%struct.Array* %%%s.%d to i64\n", 
            //         tmpNum, value.varName, varNum
            //     );
            //     tmpNum = Expression.tmpCounter++;
            //     System.out.format("    %%t%d = inttoptr i64 %%t%d to %%struct.Array*\n", 
            //         tmpNum, tmpNum-2
            //     );
            //     break;
            // }
            default : {
                stackErrs.push(new Err(
                    Err.Errno.ERR_TY, 
                    lineno, 
                    String.format("Type %s not implemented yet", value.exprTy.toString()), 
                    errText
                ));
            }
        }

        return stackErrs;
    }
}
