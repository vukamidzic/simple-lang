package org.node.arithmetic;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;
import org.node.Operation;

import java.util.HashMap;
import org.javatuples.Pair;

public class Plus extends Expression {
    public Plus() {super();}

    @Override public Err codegen(Ast tree) {
        tmpNum = Expression.tmpCounter++;

        HashMap<Pair, Operation> mp = new HashMap<Pair, Operation>(); 
        mp.put(new Pair(ExprTy.INT, ExprTy.INT), new Operation() {
            @Override
            public void func(Expression lhs, Expression rhs) {
                exprTy = ExprTy.INT;
                System.out.format("    %%t%d = add i32 %%t%d, %%t%d\n", 
                    tmpNum, lhs.tmpNum, rhs.tmpNum);
            }
        });
        mp.put(new Pair(ExprTy.FLOAT, ExprTy.FLOAT), new Operation() {
            @Override
            public void func(Expression lhs, Expression rhs) {
                exprTy = ExprTy.FLOAT;
                System.out.format("    %%t%d = fadd double %%t%d, %%t%d\n", 
                    tmpNum, lhs.tmpNum, rhs.tmpNum);
            }
        });
        mp.put(new Pair(ExprTy.INT, ExprTy.PTR), new Operation() {
            @Override
            public void func(Expression lhs, Expression rhs) {
                exprTy = ExprTy.PTR;
                System.out.format("    %%t%d = ptrtoint ptr %%t%d to i32\n", 
                    tmpNum, rhs.tmpNum);
                tmpNum = Expression.tmpCounter++;
                System.out.format("    %%t%d = add i32 %%t%d, %%t%d\n", 
                    tmpNum, tmpNum-3, lhs.tmpNum);
                tmpNum = Expression.tmpCounter++;
                System.out.format("    %%t%d = alloca i32\n", 
                    tmpNum);
                System.out.format("    store i32 %%t%d, i32* %%t%d\n", 
                    tmpNum-1, tmpNum);
            }
        });
        mp.put(new Pair(ExprTy.PTR, ExprTy.INT), new Operation() {
            @Override
            public void func(Expression lhs, Expression rhs) {
                exprTy = ExprTy.PTR;
                System.out.format("    %%t%d = ptrtoint ptr %%t%d to i32\n", 
                    tmpNum, lhs.tmpNum);
                tmpNum = Expression.tmpCounter++;
                System.out.format("    %%t%d = add i32 %%t%d, %%t%d\n", 
                    tmpNum, tmpNum-3, rhs.tmpNum);
                tmpNum = Expression.tmpCounter++;
                System.out.format("    %%t%d = alloca i32\n", 
                    tmpNum);
                System.out.format("    store i32 %%t%d, i32* %%t%d\n", 
                    tmpNum-1, tmpNum);
            }
        });

        Expression lhs = (Expression)children.get(0);
        Expression rhs = (Expression)children.get(1);

        Err lhsErr = lhs.codegen(tree);
        if (lhsErr.errno != Err.Errno.OK) return lhsErr;
        Err rhsErr = rhs.codegen(tree);
        if (rhsErr.errno != Err.Errno.OK) return rhsErr;

        if (lhs.exprTy == ExprTy.BOOL || rhs.exprTy == ExprTy.BOOL) {
            return new Err(Err.Errno.ERR_TY, lineno, "Can't do addition with bool and other type!!");
        }
            
        mp.get(new Pair(lhs.exprTy, rhs.exprTy)).func(lhs, rhs);

        return new Err(Err.Errno.OK, -1, "");
    }
}
