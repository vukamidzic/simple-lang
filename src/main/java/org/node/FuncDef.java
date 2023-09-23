package org.node;

import java.util.HashMap;
import java.util.ArrayList;

import org.simplelang.Ast;
import org.error.Err;
import org.error.Err.Errno;
import org.node.Expression.ExprTy;
import org.javatuples.Pair;

public class FuncDef extends Statement {
    public String funcName; 
    public String funcRetType;
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
        System.err.println(args);

        System.out.format("define %s @%s(", funcRetType, funcName);

        ArrayList<String> args_names = new ArrayList<>();
        args_names.addAll(args.keySet());
        int n = args_names.size();
        String ty = "";
        for (int i = 0; i < n-1; ++i) {
            ExprTy t = args.get(args_names.get(i));
            switch (t) { 
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
            //int tmp = Assignment.assignCounter++;
            System.out.format("%s %%%s, ", ty, args_names.get(i));
            tree.addVariable(args_names.get(i), t, Assignment.assignCounter++, Ast.Mut.VAR);
        }

        ExprTy t = args.get(args_names.get(n-1));
        switch (t) {
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
        //int tmp = Assignment.assignCounter++;
        System.out.format("%s %%%s", ty, args_names.get(n-1));
        tree.addVariable(args_names.get(n-1), t, Assignment.assignCounter++, Ast.Mut.VAR);

        System.out.format(") {\n");
        for (String name : args_names) {
            System.out.format("    %%%s.%d = alloca %s\n", 
                name,
                tree.symTable.get(tree.findVariableScope(name)).get(name).getValue1(),
                exprTypeToString(args.get(name))
            );
            System.out.format("    store i32 %%%s, i32* %%%s.%d\n", 
                name, 
                name, 
                tree.symTable.get(tree.findVariableScope(name)).get(name).getValue1()
            );
        }
        Err blockErr = blockOfStmts.codegen(tree);
        if (blockErr.errno != Errno.OK) return blockErr;
        System.out.format("}\n");

        Pair<String, Ast.FuncType> funcPair = new Pair<String,Ast.FuncType>(funcRetType, Ast.FuncType.NONLIB);
        tree.functions.put(funcName, funcPair); //(ty, NONLIB)
        for (String v : args_names) {
            tree.removeVariable(v);
        }

        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);

            Err nextErr = nextNode.codegen(tree);
            if (nextErr.errno != Err.Errno.OK) return nextErr;
        }

        return new Err(Errno.OK, -1, "");
    }

    private String exprTypeToString(Expression.ExprTy type) {
        String res = "";
        switch (type) {
            case INT : res = "i32"; break;
            case FLOAT : res = "double"; break;
            case BOOL : res = "i1"; break;
            default : res = "void"; break;
        }
        return res;
    }
}
