package org.node;

import org.simplelang.Ast;

import java.util.ArrayList;

import org.error.Err;
import org.node.Expression;

public class ExprFuncCall extends Expression {
    public String funcName;
    public ArrayList<Expression> args;

    public ExprFuncCall(String _funcName) {
        super();
        exprTy = ExprTy.INT;
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

        for (Expression e : this.args) {
            Err argErr = e.codegen(tree);
            if (argErr.errno != Err.Errno.OK) return argErr;
        }

        System.out.format("    %%t%d = call i32 (i32, ...) @%s(", tmpNum, this.funcName);

        for (int i = 0; i < this.args.size() - 1; ++i) {
            Expression e = (Expression) this.args.get(i);
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
            }
        }
        Expression e = (Expression) this.args.get(this.args.size()-1);
        switch (e.exprTy) {
            case INT : {
                System.out.format("i32 %d, i32 %%t%d, i32 %d)\n", 0, e.tmpNum, 3);
                break;
            }
            case FLOAT : {
                System.out.format("i32 %d, double %%t%d, i32 %d)\n", 1, e.tmpNum, 3);
                break;
            }
            case BOOL : {
                System.out.format("i32 %d, i1 %%t%d, i32 %d)\n", 2, e.tmpNum, 3);
                break;
            }
        }

        return new Err(Err.Errno.OK, -1, "");
    }
}
