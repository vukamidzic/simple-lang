package org.node;

import org.simplelang.Ast;

import java.util.ArrayList;

import org.error.Err;

public class ExprFuncCall extends Expression {
    public String funcName;
    public ArrayList<Expression> args;

    public ExprFuncCall(String _funcName) {
        super();
        funcName = _funcName;
        args = new ArrayList<>();
    }

    @Override
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: FuncCall node, depth: %d, num_args: %d\n",
                lineno, tree.symTable.size(), args.size());
        System.err.println(tree.symTable);

        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        switch (tree.functions.get(funcName)) {
            case "i32" : {
                exprTy = ExprTy.INT;
                break;
            }
            case "double" : {
                exprTy = ExprTy.FLOAT;
                break;
            }
            case "i1" : {
                exprTy = ExprTy.BOOL;
                break;
            }
        }


        for (Expression e : this.args) {
            Err argErr = e.codegen(tree);
            if (argErr.errno != Err.Errno.OK) return argErr;
        }

        System.out.format("    %%t%d = call i32 (i32, ...) @%s(", tmpNum, this.funcName);

        for (Expression e : this.args) {
            switch (e.exprTy) {
                case INT : {
                    System.out.format("i32 %d, i32 %%t%d, ", 0, e.tmpNum);
                    break;
                }
                case FLOAT : {
                    System.out.format("i32 %d, double %%t%d, ",1, e.tmpNum);
                    break;
                }
                case BOOL : {
                    System.out.format("i32 %d, i1 %%t%d, ", 2, e.tmpNum);
                    break;
                }
                case PTR : {
                    System.out.format("i32 %d, i32* %%t%d, ", 3, e.tmpNum);
                    break;
                }
            }
        }
        System.out.format("i32 %d)\n", 4);

        return new Err(Err.Errno.OK, -1, "");
    }
}
