package org.node.basic;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Str extends Expression {
    String strContent;

    public Str(String _strContent) {
        strContent = _strContent;
    }

    @Override
    public Stack<Err> codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;
        Stack<Err> stackErrs = new Stack<>();

        this.exprTy = ExprTy.STRING;
        String strIndex = tree.strings.get(strContent);
        if (strIndex != null) {
            System.out.format("    %%t%d = alloca i8*\n", tmpNum);
            System.out.format(
                "    store i8* getelementptr inbounds ([%d x i8], [%d x i8]* %s, i64 0, i64 0), i8** %%t%d\n", 
                strContent.length()+1, strContent.length()+1, strIndex, tmpNum
            );
            tmpNum = Expression.tmpCounter++;
            System.out.format("    %%t%d = load i8*, i8** %%t%d\n", tmpNum, tmpNum-1);
        }
        else {
            stackErrs.push(new Err(
                Err.Errno.ERR_TY, 
                lineno,
                String.format("String %s does not exist", strContent),
                strIndex
            ));
        }

        return stackErrs;
    }
}
