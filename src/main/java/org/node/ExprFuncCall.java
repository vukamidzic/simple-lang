package org.node;

import org.simplelang.Ast;
import org.simplelang.Ast.FuncType;

import java.util.ArrayList;

import org.error.Err;
import org.error.Err.Errno;

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

        String funcType = tree.functions.get(funcName).getValue0();
        switch (funcType) {
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
            case "{ i32*, i32 }" : {
                exprTy = ExprTy.ARRAY;
                break;
            }
        }

        for (Expression e : this.args) {
            Err argErr = e.codegen(tree);
            if (argErr.errno != Err.Errno.OK) return argErr;
        }

        if (tree.functions.get(funcName).getValue1() == FuncType.LIB) {
            System.out.format("    %%t%d = call %s (i32, ...) @%s(", tmpNum, funcType, this.funcName); 
            
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
                    case ARRAY : {
                        System.out.format("i32 %d, %%struct.Array %%t%d, ", 4, e.tmpNum);
                        break;
                    }
                    default : {
                        return new Err(Err.Errno.ERR_TY, lineno, "Unsupported type!!!");
                    }
                }
            }
            System.out.format("i32 %d)\n", 5);
        }
        else {
            System.out.format("    %%t%d = call %s (", tmpNum, funcType);
            int n = this.args.size();
            Expression e;
            for (int i = 0; i < n-1; ++i) {
                e = this.args.get(i);
                switch (e.exprTy) {
                    case INT : {
                        System.out.format("i32, ");
                        break;
                    }
                    case FLOAT : {
                        System.out.format("double, ");
                        break;
                    }
                    case BOOL : {
                        System.out.format("i1, ");
                        break;
                    }
                    default : {
                        return new Err(Errno.ERR_TY, lineno, "Undefined type!!");
                    }
                }
            }
            e = this.args.get(n-1);
            switch (e.exprTy) {
                case INT : {
                    System.out.format("i32) ");
                    break;
                }
                case FLOAT : {
                    System.out.format("double) ");
                    break;
                }
                case BOOL : {
                    System.out.format("i1) ");
                    break;
                }
                default : {
                    return new Err(Errno.ERR_TY, lineno, "Undefined type!!");
                }
            }
            System.out.format("@%s (", funcName);
            for (int i = 0; i < n-1; ++i) {
                e = this.args.get(i);
                switch (e.exprTy) {
                    case INT : {
                        System.out.format("i32 %%t%d, ", e.tmpNum);
                        break;
                    }
                    case FLOAT : {
                        System.out.format("double %%t%d, ", e.tmpNum);
                        break;
                    }
                    case BOOL : {
                        System.out.format("i1 %%t%d, ", e.tmpNum);
                        break;
                    }
                    default : {
                        return new Err(Errno.ERR_TY, lineno, "Undefined type!!");
                    }
                }
            }
            e = this.args.get(n-1);
            switch (e.exprTy) {
                case INT : {
                    System.out.format("i32 %%t%d)\n", e.tmpNum);
                    break;
                }
                case FLOAT : {
                    System.out.format("double %%t%d)\n", e.tmpNum);
                    break;
                }
                case BOOL : {
                    System.out.format("i1 %%t%d)\n", e.tmpNum);
                    break;
                }
                default : {
                    return new Err(Errno.ERR_TY, lineno, "Undefined type!!");
                }
            }
        }

        return new Err(Err.Errno.OK, -1, "");
    }
}
