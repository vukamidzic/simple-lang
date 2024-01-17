package org.simplelang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

// import org.fusesource.jansi.AnsiConsole;
// import org.fusesource.jansi.Ansi;
// import org.fusesource.jansi.Ansi.Color;

import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.error.Err;

public class Main {
    public static void main(String[] args) throws Exception {
        String formattedInput = Macros.changeMacros(stringsToArrays(Files.readString(Paths.get(args[0]))));
        if (Macros.infiniteMacros) {
            System.err.format("\033[31merror in file %s: infinite macros!!!\n", args[0]);
            return;
        }

        CharStream input = CharStreams.fromStream(new ByteArrayInputStream(formattedInput.getBytes()));
        SimpleLangLexer lexer = new SimpleLangLexer(input);
        SimpleLangParser parser = new SimpleLangParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(new ParseErrListener(args[0]));

        ParseTree parseTree = parser.program();
        SimpleLangVisitorImpl simpleLangVisitor = new SimpleLangVisitorImpl();
        Ast tree = new Ast();

        tree.root = simpleLangVisitor.visit(parseTree); //defining root of AST
        if (tree.root != null) {
            tree.addScope(); //generating a global scope

            Stack<Err> programErrs = tree.generate();
            if (programErrs.size() == 0) {
                System.err.println("Success!!");
                System.err.println(tree.functions);
            }
            else {
                switch (Ast.ver) {
                    case WINDOWS : break;
                    case LINUX : {
                        for (Err e : programErrs) {
                            System.err.println("***********************");
                            System.err.format("[\033[31m\033[1mERR\033[0m] (%s) line %d:\n",
                                args[0], e.lineno);

                            BufferedReader rd = new BufferedReader(new FileReader(Paths.get(args[0]).toFile()));
                            for (int i = 1; i < e.lineno; i++) {
                                rd.readLine(); 
                            }
                            String errLine = rd.readLine();
                            errLine = errLine.trim();

                            char[] underline = new char[e.errChunk.length()];
                            Arrays.fill(underline, '~');

                            int pos = errLine.indexOf(e.errChunk);
                            char[] whitespaces = new char[pos+3];
                            Arrays.fill(whitespaces, ' ');

                            System.err.format("%d: %s\n", e.lineno, errLine);
                            System.err.println(String.valueOf(whitespaces) + String.valueOf(underline));
                            System.err.println(e.errMsg);
                            System.err.println("***********************");
                        }
                        break;
                    }
                    default : break;
                }
            }
        }
    }

    private static String stringsToArrays(String input) {
        String new_input = input;
        Pattern patt = Pattern.compile("\"(.*?)\"");
        Matcher match = patt.matcher(new_input);

        while (match.find()) {
            String s = match.group();
            String chunk = match.group(1);
            new_input = new_input.replaceAll(s, makeStr(chunk));
        }

        return new_input;
    }

    private static String makeStr(String s) {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("arrayFrom(");
        char[] chars = s.toCharArray();

        for (char c : chars) {
            strBuild.append(String.format("\'%s\',", c));
        }
        strBuild.deleteCharAt(strBuild.length()-1);
        strBuild.append(')');

        return strBuild.toString();
    }
}
