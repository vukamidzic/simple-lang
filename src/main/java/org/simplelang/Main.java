package org.simplelang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;

import java.util.Arrays;
import java.util.Stack;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.error.Err;

public class Main {
    public static void main(String[] args) throws Exception {
        System.err.println(Files.readString(Paths.get(args[0])));
        String formattedInput = Macros.changeMacros(Files.readString(Paths.get(args[0])));

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
                        System.err.println("***********************");
                        for (Err e : programErrs) {
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
                        }
                        System.err.println("***********************");
                        break;
                    }
                    default : break;
                }
            }
        }
    }
}
