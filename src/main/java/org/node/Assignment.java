package org.node;

import org.simplelang.Ast;
import org.error.Err;
import org.javatuples.Pair;

import java.util.HashMap;

public class Assignment extends Statement {
    static int assignCounter = 1;
    public int assignNum;
    public String varName;
    public Expression exprValue;
    public Assignment() {super(); assignNum = assignCounter++;}

    @Override
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: Assign node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);
        int scopeIndex = tree.findVariableScope(varName);

        Err exprErr = exprValue.codegen(tree);
        if (exprErr.errno != Err.Errno.OK) return exprErr;

        if (scopeIndex == -1) {
            if (exprValue.exprTy == Expression.ExprTy.INT) {
                tree.addVariable(varName, Expression.ExprTy.INT, assignNum);
                System.out.format("    %%%s.%d = alloca i32\n", varName, assignNum);
                System.out.format(
                        "    store i32 %%t%d, i32* %%%s.%d\n",
                        exprValue.tmpNum, varName, assignNum);
            }
            else {
                tree.addVariable(varName, Expression.ExprTy.BOOL, assignNum);
                System.out.format("    %%%s.%d = alloca i1\n", varName, assignNum);
                System.out.format(
                        "    store i1 %%t%d, i1* %%%s.%d\n",
                        exprValue.tmpNum, varName, assignNum);
            }
        }
        else {
            String register = String.format("%%%s.%d",
                    varName, tree.symTable.get(scopeIndex).get(varName).getValue1());
            Expression.ExprTy varTy = tree.symTable.get(scopeIndex).get(varName).getValue0();

            if (exprValue.exprTy == Expression.ExprTy.INT) {
                if (exprValue.exprTy == varTy) {
                    System.out.format(
                            "    store i32 %%t%d, i32* %s\n",
                            exprValue.tmpNum, register);
                }
                else {
                    Pair<Expression.ExprTy, Integer> newPair = new Pair<>(Expression.ExprTy.INT, assignNum);
                    int n = tree.symTable.size();
                    for (int i = scopeIndex; i < n; i++) {
                        tree.symTable.get(i).put(varName, newPair);
                    }
                    System.out.format("    %%%s.%d = alloca i32\n", varName, assignNum);
                    System.out.format(
                            "    store i32 %%t%d, i32* %%%s.%d\n",
                            exprValue.tmpNum, varName, assignNum);
                }
            }
            else {
                if (exprValue.exprTy == varTy) {
                    System.out.format(
                            "    store i1 %%t%d, i1* %s\n",
                            exprValue.tmpNum, register);
                }
                else {
                    Pair<Expression.ExprTy, Integer> newPair = new Pair<>(Expression.ExprTy.BOOL, assignNum);
                    int n = tree.symTable.size();
                    for (int i = scopeIndex; i < n; i++) {
                        tree.symTable.get(i).put(varName, newPair);
                    }
                    System.out.format("    %%%s.%d = alloca i1\n", varName, assignNum);
                    System.out.format(
                            "    store i1 %%t%d, i1* %%%s.%d\n",
                            exprValue.tmpNum, varName, assignNum);
                }
            }
        }

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);

            if (nextNode instanceof While) {
                System.out.format("    br label %%while%d\n", ((While) nextNode).whileNum);
            }

            Err nextErr = nextNode.codegen(tree);
            if (nextErr.errno != Err.Errno.OK) return nextErr;
        }

        return new Err(Err.Errno.OK, -1, "");
    }
}