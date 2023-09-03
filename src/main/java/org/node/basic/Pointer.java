package org.node.basic;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Pointer extends Expression {
    public enum PtrTy {FROM_PTR, TO_PTR} 
    public PtrTy ptrTy;

    public Pointer(PtrTy _ptrTy) {
        super();
        ptrTy = _ptrTy;
        exprTy = ExprTy.PTR;
    }

    @Override
    public Err codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        Expression value = (Expression) children.get(0);

        switch (ptrTy) {
            case TO_PTR:
                if (value instanceof Var) {
                    String varName = ((Var) value).varName;
                    int scopeIndex = tree.findVariableScope(varName);
                    if (scopeIndex != -1) {
                        int varNum = tree.symTable.get(scopeIndex).get(varName).getValue1();
                        System.out.format("    %%t%d = ptrtoint i32* %%%s.%d to i64\n", 
                            tmpNum, varName, varNum);
                        tmpNum = Expression.tmpCounter++;
                        System.out.format("    %%t%d = inttoptr i64 %%t%d to i32*\n", 
                            tmpNum, tmpNum-1);
                    }
                    else {
                        return new Err(Err.Errno.ERR_VAR, lineno, "Variable '" + varName + "' not defined!!");
                    }
                }
                break;
            case FROM_PTR: 
                exprTy = ExprTy.INT;
                Err valueErr = value.codegen(tree);
                if (valueErr.errno != Err.Errno.OK) return valueErr; 
                System.out.format("    %%t%d = load i32, i32* %%t%d\n",
                    tmpNum, value.tmpNum);
                break;
            default: break;
        }

        return new Err(Err.Errno.OK, -1, "");
    }
}
