package org.node;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.node.basic.Bool;
import org.node.basic.Char;
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
    public Stack<Err> codegen(Ast tree) {
        System.err.format("(line %d)Node: Assign node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);
        int scopeIndex = tree.findVariableScope(varName);

        if (tree.symTable.size() > 1) {
            Stack<Err> exprErrs = exprValue.codegen(tree);
            if (exprErrs.size() != 0) return exprErrs;
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
                case CHAR : {
                    tree.addVariable(varName, Expression.ExprTy.CHAR, assignNum, assignTy);
                    if (tree.symTable.size() == 1 && exprValue instanceof Char) {
                        System.out.format("@%s.%d = global i8 %d\n", 
                            varName, assignNum, (((Char)exprValue).charValue));
                    }
                    else {
                        System.out.format("    %%%s.%d = alloca i8\n", varName, assignNum);
                        System.out.format(
                            "    store i8 %%t%d, i8* %%%s.%d\n",
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
                    System.out.format("    %%t%d = bitcast %%struct.Array* %%%s.%d to { i64, i8* }*\n", 
                            Expression.tmpCounter++, varName, assignNum);
                    System.out.format(
                            "    store { i64, i8* } %%t%d, { i64, i8* }* %%t%d\n",
                            exprValue.tmpNum, Expression.tmpCounter-1);
                    break;
                }
                default : {
                    Stack<Err> stackErrs = new Stack<Err>();
                    stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Unsupported type!!!", errText));
                    return stackErrs;
                }
            }
        }
        else {
            if (tree.symTable.get(scopeIndex).get(varName).getValue2() == Ast.Mut.CONST) {
                Stack<Err> stackErrs = new Stack<Err>();
                stackErrs.add(new Err(Err.Errno.ERR_CONST, lineno, "Can't assign value to constant!!!", errText));
                return stackErrs;
            }
               

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
                        Stack<Err> stackErrs = new Stack<Err>();
                        stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't assign INT value to non-INT variable!!!", errText));
                        return stackErrs;
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
                        Stack<Err> stackErrs = new Stack<Err>();
                        stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't assign FLOAT value to non-FLOAT variable!!!", errText));
                        return stackErrs;
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
                        Stack<Err> stackErrs = new Stack<Err>();
                        stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't assign BOOL value to non-BOOL variable!!!", errText));
                        return stackErrs;
                    }
                    break;
                }
                case CHAR : {
                    if (exprValue.exprTy == varTy) {
                        System.out.format(
                                "    store i8 %%t%d, i8* %s\n",
                                exprValue.tmpNum, register);
                    }
                    else {
                        Stack<Err> stackErrs = new Stack<Err>();
                        stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't assign CHAR value to non-CHAR variable!!!", errText));
                        return stackErrs;
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
                        Stack<Err> stackErrs = new Stack<Err>();
                        stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Can't assign PTR value to non-PTR variable!!!", errText));
                        return stackErrs;
                    }
                    break;
                }
                default : {
                    Stack<Err> stackErrs = new Stack<Err>();
                    stackErrs.add(new Err(Err.Errno.ERR_TY, lineno, "Unsupported type!!!", errText));
                    return stackErrs;
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

            Stack<Err> nextErrs = nextNode.codegen(tree);
            if (nextErrs.size() != 0) return nextErrs;
        }

        return new Stack<Err>();
    }
}
