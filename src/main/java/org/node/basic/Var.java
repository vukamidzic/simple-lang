package org.node.basic;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Var extends Expression {
    public String varName;
    public Var() {super();}

    @Override
    public Err codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        int foundVariableIndex = tree.findVariableScope(varName);
        if (foundVariableIndex == -1)
            return new Err(Err.Errno.ERR_VAR, lineno, "Variable '" + varName + "' not defined!!");
        else {
            exprTy = tree.symTable.get(foundVariableIndex).get(varName).getValue0();
            switch (exprTy) {
                case INT : {
                    System.out.format(
                            "    %%t%d = load i32, i32* %%%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    break;
                }
                case FLOAT : {
                    System.out.format(
                            "    %%t%d = load float, float* %%%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    break;
                }
                case BOOL : {
                    System.out.format(
                            "    %%t%d = load i1, i1* %%%s.%d\n",
                            tmpNum, varName,
                            tree.symTable.get(foundVariableIndex).get(varName).getValue1());
                    break;
                }
            }

            return new Err(Err.Errno.OK, -1, "");
        }
    }
}
