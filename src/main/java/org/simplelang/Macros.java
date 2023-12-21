package org.simplelang;

import java.util.HashSet;
import java.util.HashMap;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Macros {
    static boolean infiniteMacros = false;

    static public String changeMacros(String input) {
        return changeMacrosHelper(input);
    }   

    static private String changeMacrosHelper(String str) {
        String newStr = str;
        HashMap<String, HashSet<String>> graph = new HashMap<>();

        Pattern patt = Pattern.compile(
            "#macro[\\n\\t\\s]*([A-Z]+)[\\n\\t\\s]*begin[\\n\\t\\s]*([^\\t]*?)[\\n\\t\\s]*end"
        );
        HashMap<String, String> macros = new HashMap<>();
        Matcher match = patt.matcher(str);
        while (match.find()) {
            macros.put(match.group(1).strip(), match.group(2).strip());
        }

        newStr = newStr.replaceAll(patt.toString(), "");

        for (String k : macros.keySet()) {
            for (String x : macros.keySet()) {
                if (graph.get(k) == null) {
                    graph.put(k, new HashSet<>());
                }

                String tmp = macros.get(k);
                Pattern fmt = Pattern.compile(String.format("%s!", x));
                match = fmt.matcher(tmp);
                while (match.find()) {  
                    tmp = tmp.replaceAll(match.group(), macros.get(x));
                    int n = match.group().length();
                    
                    HashSet<String> lst = graph.get(k);
                    lst.add(match.group().substring(0, n-1));
                    graph.put(k, lst);
                }
                macros.put(k, tmp);
            }
        }
        if (hasCycle(graph)) infiniteMacros = true;

        for (String k : macros.keySet()) {
            Pattern fmt = Pattern.compile(String.format("%s!", k));
            match = fmt.matcher(newStr);
            while (match.find()) {  
                newStr = newStr.replaceAll(match.group(), macros.get(k));
            }
        }

        return newStr;
    }

    static private boolean hasCycle(HashMap<String, HashSet<String>> graph) {
        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<String, Boolean> recStack = new HashMap<>();

        for (String k : graph.keySet()) {
            visited.put(k, false);
            recStack.put(k, false);
        }

        for (String k : graph.keySet()) {
            if (visited.get(k) == false) {
                if (DFS(k, graph, visited, recStack) == true) return true;
            }
        }

        return false;
    }

    static private boolean DFS(String current, HashMap<String, HashSet<String>> graph, 
    HashMap<String, Boolean> visited, HashMap<String, Boolean> recStack) {
            visited.put(current, true);
            recStack.put(current, true);

            for (String neigh : graph.get(current)) {
                if (visited.get(neigh) == false) {
                    if (DFS(neigh, graph, visited, recStack)) return true;
                }
                else if (recStack.get(neigh) == true) return true;
            }

            recStack.put(current, false);
            return false;
    }
}