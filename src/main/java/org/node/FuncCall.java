package org.node;

import org.simplelang.Ast;
import org.error.Err;

import java.util.ArrayList;

public class FuncCall extends Statement {
    public String funcName;
    public ArrayList<Expression> args;

    public FuncCall(String _funcName) {
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

        if (funcName.contains("print")) {
            System.out.format("    call void @%s(", this.funcName);
        }
        else {
            System.out.format("    call i32 @%s(", this.funcName);
        }

        for (int i = 0; i < this.args.size() - 1; ++i) {
            Expression e = (Expression) this.args.get(i);
            switch (e.exprTy) {
                case INT : {
                    System.out.format("i32 %%t%d,", e.tmpNum);
                    break;
                }
                case FLOAT : {
                    System.out.format("float %%t%d,", e.tmpNum);
                    break;
                }
                case BOOL : {
                    System.out.format("i1 %%t%d,", e.tmpNum);
                    break;
                }
            }
        }
        Expression e = (Expression) this.args.get(this.args.size()-1);
        switch (e.exprTy) {
            case INT : {
                System.out.format("i32 %%t%d)\n", e.tmpNum);
                break;
            }
            case FLOAT : {
                System.out.format("float %%t%d)\n", e.tmpNum);
                break;
            }
            case BOOL : {
                System.out.format("i1 %%t%d)\n", e.tmpNum);
                break;
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
