package org.node;

import org.simplelang.Ast;
import org.error.Err;
import org.javatuples.Triplet;

public class Assignment extends Statement {
    static int assignCounter = 1;
    public Ast.Mut assignTy;
    public int assignNum;
    public String varName;
    public Expression exprValue;
    public Assignment(Ast.Mut _assignTy) {
        super();
        assignNum = assignCounter++;
        assignTy = _assignTy;
    }

    @Override
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: Assign node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);
        int scopeIndex = tree.findVariableScope(varName);

        Err exprErr = exprValue.codegen(tree);
        if (exprErr.errno != Err.Errno.OK) return exprErr;

        if (scopeIndex == -1) {
            switch (exprValue.exprTy) {
                case INT : {
                    tree.addVariable(varName, Expression.ExprTy.INT, assignNum, assignTy);
                    System.out.format("    %%%s.%d = alloca i32\n", varName, assignNum);
                    System.out.format(
                            "    store i32 %%t%d, i32* %%%s.%d\n",
                            exprValue.tmpNum, varName, assignNum);
                    break;
                }
                case FLOAT : {
                    tree.addVariable(varName, Expression.ExprTy.FLOAT, assignNum, assignTy);
                    System.out.format("    %%%s.%d = alloca float\n", varName, assignNum);
                    System.out.format(
                            "    store float %%t%d, float* %%%s.%d\n",
                            exprValue.tmpNum, varName, assignNum);
                    break;
                }
                case BOOL : {
                    tree.addVariable(varName, Expression.ExprTy.BOOL, assignNum, assignTy);
                    System.out.format("    %%%s.%d = alloca i1\n", varName, assignNum);
                    System.out.format(
                            "    store i1 %%t%d, i1* %%%s.%d\n",
                            exprValue.tmpNum, varName, assignNum);
                    break;
                }
            }
        }
        else {
            if (tree.symTable.get(scopeIndex).get(varName).getValue2() == Ast.Mut.CONST)
                return new Err(Err.Errno.ERR_CONST, lineno, "Can't assign value to constant!!!");

            String register = String.format("%%%s.%d",
                    varName, tree.symTable.get(scopeIndex).get(varName).getValue1());
            Expression.ExprTy varTy = tree.symTable.get(scopeIndex).get(varName).getValue0();

            switch (exprValue.exprTy) {
                case INT : {
                    if (exprValue.exprTy == varTy) {
                        System.out.format(
                                "    store i32 %%t%d, i32* %s\n",
                                exprValue.tmpNum, register);
                    }
                    else {
                        Triplet<Expression.ExprTy, Integer, Ast.Mut> newTri = new Triplet<>(Expression.ExprTy.INT, assignNum, assignTy);
                        int n = tree.symTable.size();
                        for (int i = scopeIndex; i < n; i++) {
                            tree.symTable.get(i).put(varName, newTri);
                        }
                        System.out.format("    %%%s.%d = alloca i32\n", varName, assignNum);
                        System.out.format(
                                "    store i32 %%t%d, i32* %%%s.%d\n",
                                exprValue.tmpNum, varName, assignNum);
                    }
                    break;
                }
                case FLOAT : {
                    if (exprValue.exprTy == varTy) {
                        System.out.format(
                                "    store float %%t%d, float* %s\n",
                                exprValue.tmpNum, register);
                    }
                    else {
                        Triplet<Expression.ExprTy, Integer, Ast.Mut> newPair = new Triplet<>(Expression.ExprTy.FLOAT, assignNum, assignTy);
                        int n = tree.symTable.size();
                        for (int i = scopeIndex; i < n; i++) {
                            tree.symTable.get(i).put(varName, newPair);
                        }
                        System.out.format("    %%%s.%d = alloca float\n", varName, assignNum);
                        System.out.format(
                                "    store float %%t%d, float* %%%s.%d\n",
                                exprValue.tmpNum, varName, assignNum);
                    }
                    break;
                }
                case BOOL : {
                    if (exprValue.exprTy == varTy) {
                        System.out.format(
                                "    store i1 %%t%d, i1* %s\n",
                                exprValue.tmpNum, register);
                    }
                    else {
                        Triplet<Expression.ExprTy, Integer, Ast.Mut> newTri = new Triplet<>(Expression.ExprTy.BOOL, assignNum, assignTy);
                        int n = tree.symTable.size();
                        for (int i = scopeIndex; i < n; i++) {
                            tree.symTable.get(i).put(varName, newTri);
                        }
                        System.out.format("    %%%s.%d = alloca i1\n", varName, assignNum);
                        System.out.format(
                                "    store i1 %%t%d, i1* %%%s.%d\n",
                                exprValue.tmpNum, varName, assignNum);
                    }
                    break;
                }
            }
        }

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);

            if (nextNode instanceof If) {
                System.out.format("    br label %%if%d\n", ((If) nextNode).ifNum);
            }
            else if (nextNode instanceof While) {
                System.out.format("    br label %%while%d\n", ((While) nextNode).whileNum);
            }

            Err nextErr = nextNode.codegen(tree);
            if (nextErr.errno != Err.Errno.OK) return nextErr;
        }

        return new Err(Err.Errno.OK, -1, "");
    }
}
