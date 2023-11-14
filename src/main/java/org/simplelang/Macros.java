package org.simplelang;

import java.util.HashMap;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Macros {
    static public String changeMacros(String input) {
        return changeMacrosHelper(input);
    }   

    static private String changeMacrosHelper(String str) {
        String newStr = str;

        Pattern patt = Pattern.compile(
            "#macro[\\n\\t\\s]*([A-Z]+)[\\n\\t\\s]*\\[[\\n\\t\\s]*([^\\t]*?)[\\n\\t\\s]*\\]"
        );
        HashMap<String, String> macros = new HashMap<>();
        Matcher match = patt.matcher(str);
        while (match.find()) {
            macros.put(match.group(1).strip(), match.group(2).strip());
        }
        System.err.println(macros);

        newStr = newStr.replaceAll(patt.toString(), "");

        for (String k : macros.keySet()) {
            for (String x : macros.keySet()) {
                if (!k.equals(x)) {
                    String tmp = macros.get(k);
                    Pattern fmt = Pattern.compile(String.format("%s!", x));
                    match = fmt.matcher(tmp);
                    while (match.find()) {  
                        tmp = tmp.replaceAll(match.group(), macros.get(x));
                    }
                    macros.put(k, tmp);
                }
            }
        }
        System.err.println(macros);

        for (String k : macros.keySet()) {
            Pattern fmt = Pattern.compile(String.format("%s!", k));
            match = fmt.matcher(newStr);
            while (match.find()) {  
                newStr = newStr.replaceAll(match.group(), macros.get(k));
            }
        }

        return newStr;
    }
}