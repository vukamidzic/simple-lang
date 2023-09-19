package org.node;

import org.simplelang.Ast;
import org.error.Err;

import java.util.ArrayList;

public class StatFuncCall extends Statement {
    public String funcName;
    public ArrayList<Expression> args;

    public StatFuncCall(String _funcName) {
        super();
        funcName = _funcName;
        args = new ArrayList<>();
    }

    @Override
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: FuncCall node, depth: %d, num_args: %d\n",
                lineno, tree.symTable.size(), args.size());
        System.err.println(tree.symTable);
        
        for (Expression e : this.args) {
            Err argErr = e.codegen(tree);
            if (argErr.errno != Err.Errno.OK) return argErr;
        }

        System.out.format("    call void (i32, ...) @%s(", this.funcName);        

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
            }
        }
        System.out.format("i32 %d)\n", 4);

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
