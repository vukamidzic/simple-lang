package org.simplelang;

import org.javatuples.Triplet;
import org.node.Expression;
import org.node.Node;
import org.error.Err;

import java.util.ArrayList;
import java.util.HashMap;

public class Ast {
    public enum OSVersion {WINDOWS, LINUX}
    public OSVersion ver;
    public enum Mut {VAR, CONST}
    public ArrayList<HashMap<String, Triplet<Expression.ExprTy, Integer, Mut>>> symTable;

    public Ast() {
        symTable = new ArrayList<>();
        switch (System.getProperty("os.name")) {
            case "Windows 10" : {
                ver = OSVersion.WINDOWS;
                break;
            }
            case "Linux" : {
                ver = OSVersion.LINUX;
                break;
            }
        }
    }

    public Node root;

    public Err generate() {
        switch (ver) {
            case WINDOWS : {
                System.out.println("target triple = \"x86_64-pc-windows-msvc19.29.30138\"\n");
                break;
            }
            case LINUX : {
                System.out.println("target triple = \"x86_64-pc-linux-gnu\"\n");
                break;
            }
        }
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

    public void addVariable(String _varName, Expression.ExprTy _ty, int _tmp, Mut _assignTy) {
        int n = symTable.size();
        symTable.get(n-1).put(_varName, Triplet.with(_ty, _tmp, _assignTy));
    }

    public int findVariableScope(String _varName) {
        int n = symTable.size();
        for (int i = 0; i < n; i++)
            if (symTable.get(i).containsKey(_varName)) return i;

        return -1;
    }
}
