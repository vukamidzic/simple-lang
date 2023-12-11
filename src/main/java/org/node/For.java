package org.node;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.error.Err.Errno;
import org.node.Expression.ExprTy;

public class For extends Statement {
    static int forCounter = 1;
    public int forNum;
    public int forAssignNum;
    public int forCondNum;
    public int nextNum;
    public int tmp;
    public String varName;
    public Block blockOfStmts;
    public Expression startExpr, endExpr;

    public For(String _varName) {
        super();
        forNum = forCounter++;
        forAssignNum = Assignment.assignCounter++;
        nextNum = nextCounter++;
        varName = _varName;
    }

    @Override
    public Stack<Err> codegen(Ast tree) {
        tmp = Expression.tmpCounter++;
        forCondNum = Expression.tmpCounter++;

        System.err.format("(line %d)Node: For node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);

        Stack<Err> startErrs = startExpr.codegen(tree);
        if (startErrs.size() != 0) return startErrs;
        System.err.println(startExpr.exprTy);
        if (startExpr.exprTy != ExprTy.INT) {
            Stack<Err> stackErrs = new Stack<Err>();
            stackErrs.add(new Err(Errno.ERR_TY, lineno, "Can't use float/bool in for counter!!!"));
            return stackErrs;
        }

        tree.addVariable(varName, startExpr.exprTy, forAssignNum, Ast.Mut.VAR);
        System.out.format("    %%%s.%d = alloca i32\n", varName, forAssignNum);
        System.out.format(
                "    store i32 %%t%d, i32* %%%s.%d\n",
                startExpr.tmpNum, varName, forAssignNum);

        System.out.format("    br label %%for%d\n", forNum);

        System.out.format("for%d:\n", forNum);

        Stack<Err> endErrs = endExpr.codegen(tree);
        if (endErrs.size() != 0) return endErrs;

        System.out.format("    %%tmp%d = load i32, i32* %%%s.%d\n", 
                    tmp, varName, forAssignNum);
        System.out.format("    %%t%d = icmp sgt i32 %%tmp%d, %%t%d\n", 
                    forCondNum, tmp, endExpr.tmpNum);
        System.out.format("    br i1 %%t%d, label %%next%d, label %%body_for%d\n",
                    forCondNum, nextNum, forNum);

        System.out.format("body_for%d:\n", forNum);
        Statement fstStmt = (Statement)blockOfStmts.getFirstStmt();
        if (fstStmt instanceof If) {
            System.out.format("    br label %%if%d\n", ((If)fstStmt).ifNum);
        }
        else if (fstStmt instanceof While) {
            System.out.format("    br label %%while%d\n", ((While)fstStmt).whileNum);
        }
        Stack<Err> blockOfStmtsErrs = blockOfStmts.codegen(tree);
        if (blockOfStmtsErrs.size() != 0) return blockOfStmtsErrs;

        tmp = Expression.tmpCounter++;
        System.out.format("    %%tmp%d = load i32, i32* %%%s.%d\n", 
                    tmp, varName, forAssignNum);
        tmp = Expression.tmpCounter++;
        System.out.format("    %%tmp%d = add i32 %%tmp%d, 1\n",
                    tmp, tmp-1);
        System.out.format("    store i32 %%tmp%d, i32* %%%s.%d\n",
                    tmp, varName, forAssignNum);

        System.out.format("    br label %%for%d\n", forNum);

        System.out.format("next%d:\n", nextNum);

        tree.removeVariable(varName);

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);
            Stack<Err> nextErrs = nextNode.codegen(tree);
            if (nextErrs.size() != 0) return nextErrs;
        }

        return new Stack<Err>();
    }
}
