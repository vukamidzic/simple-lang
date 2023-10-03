package org.node;

import org.simplelang.Ast;
import org.error.Err;
import org.javatuples.Triplet;
import org.node.basic.Bool;
import org.node.basic.FloatP;
import org.node.basic.Int;

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

        if (tree.symTable.size() > 1) {
            Err exprErr = exprValue.codegen(tree);
        if (exprErr.errno != Err.Errno.OK) return exprErr;
        }

        if (scopeIndex == -1) {
            switch (exprValue.exprTy) {
                case INT : {
                    tree.addVariable(varName, Expression.ExprTy.INT, assignNum, assignTy);
                    if (tree.symTable.size() == 1 && exprValue instanceof Int) {
                        System.out.format("@%s.%d = global i32 %d\n", 
                            varName, assignNum, ((Int)exprValue).numValue);
                    }
                    else {
                        System.out.format("    %%%s.%d = alloca i32\n", varName, assignNum);
                        System.out.format(
                            "    store i32 %%t%d, i32* %%%s.%d\n",
                            exprValue.tmpNum, varName, assignNum);
                    }
                    
                    break;
                }
                case FLOAT : {
                    tree.addVariable(varName, Expression.ExprTy.FLOAT, assignNum, assignTy);
                    if (tree.symTable.size() == 1 && exprValue instanceof FloatP) {
                        System.out.format("@%s.%d = global double %f\n", 
                            varName, assignNum, ((FloatP)exprValue).numValue);
                    }
                    else {
                        System.out.format("    %%%s.%d = alloca double\n", varName, assignNum);
                        System.out.format(
                            "    store double %%t%d, double* %%%s.%d\n",
                            exprValue.tmpNum, varName, assignNum);
                    }
                    break;
                }
                case BOOL : {
                    tree.addVariable(varName, Expression.ExprTy.BOOL, assignNum, assignTy);
                    if (tree.symTable.size() == 1 && exprValue instanceof Bool) {
                        System.out.format("@%s.%d = global i1 %d\n", 
                            varName, assignNum, (((Bool)exprValue).boolValue) ? 1 : 0);
                    }
                    else {
                        System.out.format("    %%%s.%d = alloca i1\n", varName, assignNum);
                        System.out.format(
                            "    store i1 %%t%d, i1* %%%s.%d\n",
                            exprValue.tmpNum, varName, assignNum);
                    }
                    break;
                }
                case PTR : {
                    tree.addVariable(varName, Expression.ExprTy.PTR, assignNum, assignTy);
                    System.out.format("    %%%s.%d = alloca i32*\n", varName, assignNum);
                    System.out.format(
                            "    store i32* %%t%d, i32** %%%s.%d\n",
                            exprValue.tmpNum, varName, assignNum);
                    break;
                }
                case ARRAY : {
                    tree.addVariable(varName, Expression.ExprTy.ARRAY, assignNum, assignTy);
                    System.out.format("    %%%s.%d = alloca %%struct.Array\n", varName, assignNum);
                    System.out.format("    %%t%d = bitcast %%struct.Array* %%%s.%d to { i32*, i32 }*\n", 
                            Expression.tmpCounter++, varName, assignNum);
                    System.out.format(
                            "    store { i32*, i32 } %%t%d, { i32*, i32 }* %%t%d\n",
                            exprValue.tmpNum, Expression.tmpCounter-1);
                    break;
                }
                default : {
                    return new Err(Err.Errno.ERR_TY, lineno, "Unsupported type!!!");
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
                                "    store double %%t%d, double* %s\n",
                                exprValue.tmpNum, register);
                    }
                    else {
                        Triplet<Expression.ExprTy, Integer, Ast.Mut> newPair = new Triplet<>(Expression.ExprTy.FLOAT, assignNum, assignTy);
                        int n = tree.symTable.size();
                        for (int i = scopeIndex; i < n; i++) {
                            tree.symTable.get(i).put(varName, newPair);
                        }
                        System.out.format("    %%%s.%d = alloca double\n", varName, assignNum);
                        System.out.format(
                                "    store double %%t%d, double* %%%s.%d\n",
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
                case PTR : {
                    if (exprValue.exprTy == varTy) {
                        System.out.format(
                                "    store i32* %%t%d, i32** %s\n",
                                exprValue.tmpNum, register);
                    }
                    else {
                        Triplet<Expression.ExprTy, Integer, Ast.Mut> newTri = new Triplet<>(Expression.ExprTy.PTR, assignNum, assignTy);
                        int n = tree.symTable.size();
                        for (int i = scopeIndex; i < n; i++) {
                            tree.symTable.get(i).put(varName, newTri);
                        }
                        System.out.format("    %%%s.%d = alloca i32*\n", varName, assignNum);
                        System.out.format(
                                "    store i32* %%t%d, i32** %%%s.%d\n",
                                exprValue.tmpNum, varName, assignNum);
                    }
                    break;
                }
                default : {
                    return new Err(Err.Errno.ERR_TY, lineno, "Unsupported type!!!");
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
