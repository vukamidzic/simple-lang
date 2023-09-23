package org.node;

import java.util.HashMap;
import java.util.ArrayList;

import org.simplelang.Ast;
import org.error.Err;
import org.error.Err.Errno;
import org.node.Expression.ExprTy;

public class FuncDef extends Statement {
    public String funcName; 
    public HashMap<String, ExprTy> args;
    public Block blockOfStmts; // body of a function definition

    public FuncDef(String _funcName) {
        super();
        args = new HashMap<>();
        funcName = _funcName;
    }

    @Override
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: FuncDef node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);

        System.out.format("define i32 @%s(", funcName);

        ArrayList<String> args_names = new ArrayList<>();
        args_names.addAll(args.keySet());
        int n = args_names.size();
        String ty = "";
        for (int i = 0; i < n-1; ++i) {
            switch (args.get(args_names.get(i))) {
                case INT : 
                    ty = "i32";
                    break;
                case FLOAT : 
                    ty = "double";
                    break;
                case BOOL : 
                    ty = "i1";
                    break;
                default : 
                    return new Err(Errno.ERR_TY, lineno, "Undefined type!!");
            }
            System.out.format("%s %%%s, ", ty, args_names.get(i));
        }

        switch (args.get(args_names.get(n-1))) {
            case INT : 
                ty = "i32";
                break;
            case FLOAT : 
                ty = "double";
                break;
            case BOOL : 
                ty = "i1";
                break;
            default : 
                return new Err(Errno.ERR_TY, lineno, "Undefined type!!");
        }
        System.out.format("%s %%%s", ty, args_names.get(n-1));

        System.out.format(") {\n");
        Err blockErr = blockOfStmts.codegen(tree);
        if (blockErr.errno != Errno.OK) return blockErr;
        System.out.format("}\n");

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);

            Err nextErr = nextNode.codegen(tree);
            if (nextErr.errno != Err.Errno.OK) return nextErr;
        }

        return new Err(Errno.OK, -1, "");
    }
}
