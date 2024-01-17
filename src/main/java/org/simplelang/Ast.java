package org.simplelang;

import org.node.Expression;
import org.node.Node;
import org.error.Err;
import org.javatuples.Pair;
import org.javatuples.Triplet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Ast {
    public enum OSVersion {WINDOWS, LINUX}
    public static OSVersion ver;
    public enum Mut {VAR, CONST}
    public enum FuncType {LIB, NONLIB}
    public HashMap<String, Pair<String, FuncType>> functions;
    public ArrayList<HashMap<String, Triplet<Expression.ExprTy, Integer, Mut>>> symTable;
    public Node root;

    public Ast() {
        symTable = new ArrayList<>();
        functions = new HashMap<>();
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

    public Stack<Err> generate() {
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
        
        System.out.println("%struct.Array = type { i64, i8* }");
        getLibFuncs();
        System.out.println(";###########################################");
        //System.out.println("define i32 @main() {");
        Stack<Err> errs = root.codegen(this);
        //System.out.println("    ret i32 0");
        //System.out.println("}");
        return errs;
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

    public void removeVariable(String _varName) {
        int n = symTable.size();
        symTable.get(n-1).remove(_varName);
    }

    public int findVariableScope(String _varName) {
        int n = symTable.size();
        for (int i = 0; i < n; i++)
            if (symTable.get(i).containsKey(_varName)) return i;

        return -1;
    }
    
    private void getLibFuncs() {
        try {
            String str = Files.readString(Paths.get("lib.ll"));
            
            Pattern pattern = Pattern.compile("define .* ((\\{ i64, i8\\* \\}|i1|i8|double|i32|void) @([a-zA-Z]+)\\(((i64|i32|double|i1).*\\%[0-9]+\\,.*)+\\))");
            Matcher matcher = pattern.matcher(str);
            
            while (matcher.find()) {
                String foundStr = matcher.group(1);
                String funcType = matcher.group(2);
                String funcString = matcher.group(3);
                System.out.println("declare " + foundStr);
                Pair<String, FuncType> funcPair = new Pair<>(funcType, FuncType.LIB); 
                this.functions.put(funcString, funcPair);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
