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
        Err valueErr = value.codegen(tree);
        if (valueErr.errno != Err.Errno.OK) return valueErr; 

        switch (ptrTy) {
            case TO_PTR: 
                System.out.format("    %%t%d = inttoptr i32 %%t%d to ptr\n", 
                    tmpNum, value.tmpNum);
                break;
            case FROM_PTR: 
                exprTy = ExprTy.INT;
                System.out.format("    %%t%d = ptrtoint ptr %%t%d to i32\n", 
                    tmpNum, value.tmpNum);
                break;
            default: break;
        }

        return new Err(Err.Errno.OK, -1, "");
    }
}
