package org.simplelang;

import org.node.Expression;
import org.node.Node;
import org.error.Err;

import java.util.ArrayList;
import java.util.HashMap;
import org.javatuples.Pair;

public class Ast {
    public ArrayList<HashMap<String, Pair<Expression.ExprTy, Integer>>> symTable;

    public Ast() {
        symTable = new ArrayList<>();
    }

    public Node root;

    public Err generate() {
        System.out.println("target triple = \"x86_64-pc-windows-msvc19.29.30138\"\n");
        System.out.println("@s_i = constant [4 x i8] c\"%d\\0A\\00\"");
        System.out.println("@s_f = constant [4 x i8] c\"%f\\0A\\00\"");
        System.out.println("declare i32 @printf(i8 *, ...)\n");
        System.out.println("define i32 @main() {");
        Err err = root.codegen(this);
        System.out.println("    ret i32 0");
        System.out.println("}");
        return err;
    }

    public void addScope() {
        int n = symTable.size();
        symTable.add(new HashMap<>());
        if (n != 0)
            symTable.get(n).putAll(symTable.get(n-1));
    }

    public void removeScope() {
        int n = symTable.size();
        symTable.remove(n-1);
    }

    public void addVariable(String _varName, Expression.ExprTy _ty, int _tmp) {
        int n = symTable.size();
        symTable.get(n-1).put(_varName, Pair.with(_ty, _tmp));
    }

    public int findVariableScope(String _varName) {
        int n = symTable.size();
        for (int i = 0; i < n; i++)
            if (symTable.get(i).containsKey(_varName)) return i;

        return -1;
    }
}
