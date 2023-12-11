package org.simplelang;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import org.fusesource.jansi.AnsiConsole;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;

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

            Err programErr = tree.generate();
            if (programErr.errno == Err.Errno.OK) {
                System.err.println("Success!!");
                System.err.println(tree.functions);
            }
            else {
                switch (Ast.ver) {
                    case WINDOWS : {
                        AnsiConsole.systemInstall();
                        System.err.println(Ansi.ansi()
                                .fg(Color.RED)
                                .a("\nerror in file " + args[0] + ", line " + programErr.lineno + ":")
                                .reset());
                        AnsiConsole.systemUninstall();
                        break;
                    }
                    case LINUX : {
                        System.err.format("[\033[31m\033[1mERR\033[0m] (%s) line %d:\n",
                                args[0], programErr.lineno);
                        break;
                    }
                    default : {}
                }

                BufferedReader rd = new BufferedReader(new FileReader(Paths.get(args[0]).toFile()));
                for (int i = 1; i < programErr.lineno; i++) {
                    rd.readLine();
                }
                String errLine = rd.readLine();
                errLine = errLine.trim();
                System.err.format("%d: %s\n\n", programErr.lineno, errLine);
                System.err.println(programErr.errMsg);
            }
        }
    }
}
