package org.node.arithmetic;

import java.util.HashMap;
import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;
import org.node.Operation;
import org.javatuples.Pair;

public class Minus extends Expression {
    public Minus() {super();}

    @Override public Stack<Err> codegen(Ast tree) {
        tmpNum = Expression.tmpCounter++;

        HashMap<Pair, Operation> mp = new HashMap<Pair, Operation>(); 
        mp.put(new Pair(ExprTy.INT, ExprTy.INT), new Operation() {
            @Override
            public void func(Expression lhs, Expression rhs) {
                exprTy = ExprTy.INT;
                System.out.format("    %%t%d = sub i32 %%t%d, %%t%d\n", 
                    tmpNum, lhs.tmpNum, rhs.tmpNum);
            }
        });
        mp.put(new Pair(ExprTy.FLOAT, ExprTy.FLOAT), new Operation() {
            @Override
            public void func(Expression lhs, Expression rhs) {
                exprTy = ExprTy.FLOAT;
                System.out.format("    %%t%d = fsub double %%t%d, %%t%d\n", 
                    tmpNum, lhs.tmpNum, rhs.tmpNum);
            }
        });
        mp.put(new Pair(ExprTy.CHAR, ExprTy.CHAR), new Operation() {
            @Override
            public void func(Expression lhs, Expression rhs) {
                exprTy = ExprTy.CHAR;
                System.out.format("    %%t%d = sub i8 %%t%d, %%t%d\n", 
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
                System.out.format("    %%t%d = sub i32 %%t%d, %%t%d\n", 
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
                System.out.format("    %%t%d = sub i32 %%t%d, %%t%d\n", 
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

        Stack<Err> lhsErrs = lhs.codegen(tree);
        if (lhsErrs.size() != 0) return lhsErrs;
        Stack<Err> rhsErrs = rhs.codegen(tree);
        if (rhsErrs.size() != 0) return rhsErrs;

        if (lhs.exprTy == ExprTy.BOOL || rhs.exprTy == ExprTy.BOOL) {
            Stack<Err> stackErrs = new Stack<Err>();
            stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't do addition with bool and other type!!"));
            return stackErrs;
        }

        mp.get(new Pair(lhs.exprTy, rhs.exprTy)).func(lhs, rhs);

        return new Stack<Err>();
    }
}
