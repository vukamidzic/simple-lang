package org.simplelang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.error.Err;

public class Main {
    public static void main(String[] args) throws Exception {
        CharStream input = CharStreams.fromStream(Files.newInputStream(Paths.get(args[0])));
        SimpleLangLexer lexer = new SimpleLangLexer(input);
        SimpleLangParser parser = new SimpleLangParser(new CommonTokenStream(lexer));

        ParseTree parseTree = parser.program();
        SimpleLangVisitorImpl simpleLangVisitor = new SimpleLangVisitorImpl();
        Ast tree = new Ast();

        tree.root = simpleLangVisitor.visit(parseTree); //defining root of AST
        tree.addScope(); //generating a global scope

        Err programErr = tree.generate();
        if (programErr.errno == Err.Errno.OK) {
            System.err.println("Success!!");
        } else {
            BufferedReader rd = new BufferedReader(new FileReader(Paths.get(args[0]).toFile()));
            for (int i = 1; i < programErr.lineno; i++) {
                rd.readLine();
            }
            /*System.err.format(
                    "\n\\u001B[31merror in file %s, line %d: \\u001B[0m\n",
                    args[0], programErr.lineno);*/
            AnsiConsole.systemInstall();
            System.err.println(Ansi.ansi()
                    .fg(Color.RED)
                    .a("\nerror in file " + args[0] + ", line " + programErr.lineno + ":")
                    .reset());
            AnsiConsole.systemUninstall();
            String errLine = rd.readLine();
            errLine = errLine.trim();
            System.err.format("%d: %s\n\n", programErr.lineno, errLine);
            System.err.println(programErr.errMsg);
        }
    }
}