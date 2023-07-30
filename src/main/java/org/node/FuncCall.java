package org.node;

import org.simplelang.Ast;
import org.error.Err;

public class FuncCall extends Statement {
    static int funCallCounter = 1;
    static int tmpCounter = 1;
    public int tmpNum;
    public int funCallNum;
    public Expression outValue;

    public FuncCall() {
        super();
        funCallNum = funCallCounter++;
        tmpNum = tmpCounter++;
    }

    @Override
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: FuncCall node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);
        Err outErr = outValue.codegen(tree);
        if (outErr.errno != Err.Errno.OK) return outErr;

        if (outValue.exprTy == Expression.ExprTy.INT) {
            switch (tree.ver) {
                case WINDOWS : {
                    System.out.format("    call i32 (i8 *, ...) @printf(i8* @s_i, i32 %%t%d)\n", outValue.tmpNum);
                    break;
                }
                case LINUX : {
                    System.out.format("call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @s_i, i32 0, i32 0), i32 %%t%d)",
                            outValue.tmpNum);
                    break;
                }
            }

        }
        else if (outValue.exprTy == Expression.ExprTy.FLOAT) {
            System.out.format("    %%tmp%d = fpext float %%t%d to double\n", tmpNum, outValue.tmpNum);
            switch (tree.ver) {
                case WINDOWS : {
                    System.out.format("    call i32 (i8 *, ...) @printf(i8* @s_f, double %%tmp%d)\n", tmpNum);
                    break;
                }
                case LINUX : {
                    System.out.format("call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @s_f, i32 0, i32 0), double %%tmp%d)",
                            tmpNum);
                    break;
                }
            }
        }
        else {
            System.out.format("    %%tmp%d = zext i1 %%t%d to i32\n", funCallNum, outValue.tmpNum);
            switch (tree.ver) {
                case WINDOWS : {
                    System.out.format("    call i32 (i8 *, ...) @printf(i8* @s_i, i32 %%tmp%d)\n", funCallNum);
                    break;
                }
                case LINUX : {
                    System.out.format("call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @s_i, i32 0, i32 0), i32 %%tmp%d)",
                            funCallNum);
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
