package org.node.basic;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.error.Err.Errno;
import org.node.Expression;

public class Var extends Expression {
    public String varName;
    public Var() {super();}

    @Override
    public Stack<Err> codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        int foundVariableIndex = tree.findVariableScope(varName);
        if (foundVariableIndex == -1) {
            Stack<Err> stackErrs = new Stack<Err>();
            stackErrs.add(new Err(Err.Errno.ERR_VAR, lineno, "Variable '" + varName + "' not defined!!"));
            return stackErrs;
        }  
        else {
            exprTy = tree.symTable.get(foundVariableIndex).get(varName).getValue0();
            switch (exprTy) {
                case INT : {
                    if (foundVariableIndex == 0) {
                        System.out.format(
                            "    %%t%d = load i32, i32* @%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());    
                    }
                    else {
                        System.out.format(
                            "    %%t%d = load i32, i32* %%%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    }                    
                    break;
                }
                case FLOAT : {
                    if (foundVariableIndex == 0) {
                        System.out.format(
                            "    %%t%d = load double, double* @%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    }
                    else {
                        System.out.format(
                            "    %%t%d = load double, double* %%%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    }  
                    break;
                }
                case BOOL : {
                    if (foundVariableIndex == 0) {
                        System.out.format(
                            "    %%t%d = load i1, i1* @%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    }
                    else {
                        System.out.format(
                            "    %%t%d = load i1, i1* %%%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    }
                    break;
                }
                case CHAR : {
                    if (foundVariableIndex == 0) {
                        System.out.format(
                            "    %%t%d = load i8, i8* @%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    }
                    else {
                        System.out.format(
                            "    %%t%d = load i8, i8* %%%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    }
                    break;
                }
                case PTR : {
                    if (foundVariableIndex == 0) {
                        Stack<Err> stackErrs = new Stack<Err>();
                        stackErrs.add(new Err(Errno.ERR_VAR, lineno, "Can't use pointers globally"));
                        return stackErrs;
                    }
                    else {
                        System.out.format(
                            "    %%t%d = load i32*, i32** %%%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    }
                    break;
                }
                case ARRAY : {
                    if (foundVariableIndex == 0) {
                        Stack<Err> stackErrs = new Stack<Err>();
                        stackErrs.add(new Err(Errno.ERR_VAR, lineno, "Can't use arrays globally"));
                        return stackErrs;
                    }
                    else {
                        System.out.format(
                            "    %%t%d = load %%struct.Array, %%struct.Array* %%%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    }
                    break;
                }
            }

            return new Stack<Err>();
        }
    }
}
