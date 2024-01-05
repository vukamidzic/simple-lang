package org.node.arithmetic;

import java.util.HashMap;
import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;
import org.node.Operation;
import org.javatuples.Pair;

public class Div extends Expression {
    public Div() {super();}

    @Override
    public Stack<Err> codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;
        Stack<Err> stackErrs = new Stack<Err>();

        HashMap<Pair, Operation> ops = genOperations();

        Expression lhs = (Expression)children.get(0);
        Expression rhs = (Expression)children.get(1);

        Stack<Err> lhsErrs = lhs.codegen(tree);
        stackErrs.addAll(lhsErrs);
        Stack<Err> rhsErrs = rhs.codegen(tree);
        stackErrs.addAll(rhsErrs);

        if (!ops.containsKey(new Pair(lhs.exprTy, rhs.exprTy))) {
            exprTy = ExprTy.UNDEFINED;
            stackErrs.push(new Err(
                Err.Errno.ERR_TY, 
                lineno, 
                String.format("Can't divide %s by %s", lhs.exprTy.toString(), rhs.exprTy.toString()), 
                errText
            ));
        }
        else ops.get(new Pair(lhs.exprTy, rhs.exprTy)).func(lhs, rhs);

        return stackErrs;
    }

    private HashMap<Pair, Operation> genOperations() {
        HashMap<Pair, Operation> mp = new HashMap<Pair, Operation>(); 
        mp.put(new Pair(ExprTy.INT, ExprTy.INT), new Operation() {
            @Override
            public void func(Expression lhs, Expression rhs) {
                exprTy = ExprTy.INT;
                System.out.format("    %%t%d = udiv i32 %%t%d, %%t%d\n", 
                    tmpNum, lhs.tmpNum, rhs.tmpNum);
            }
        });
        mp.put(new Pair(ExprTy.FLOAT, ExprTy.FLOAT), new Operation() {
            @Override
            public void func(Expression lhs, Expression rhs) {
                exprTy = ExprTy.FLOAT;
                System.out.format("    %%t%d = fdiv double %%t%d, %%t%d\n", 
                    tmpNum, lhs.tmpNum, rhs.tmpNum);
            }
        });
        mp.put(new Pair(ExprTy.CHAR, ExprTy.CHAR), new Operation() {
            @Override
            public void func(Expression lhs, Expression rhs) {
                exprTy = ExprTy.CHAR;
                System.out.format("    %%t%d = udiv i8 %%t%d, %%t%d\n", 
                    tmpNum, lhs.tmpNum, rhs.tmpNum);
            }
        });

        return mp;
    }
}