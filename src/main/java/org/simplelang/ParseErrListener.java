package org.simplelang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;
import org.antlr.v4.runtime.RecognitionException;

public class ParseErrListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object symbol,
        int line, int charPosInLine, String msg, RecognitionException e) {
        Pattern pattern = Pattern.compile("\'.*\'");
        String symbolStr = symbol.toString();
        Matcher matcher = pattern.matcher(symbolStr);
        if (matcher.find()) {
            String res = matcher.group();
            System.err.println(res);
        }

        if (System.getProperty("os.name") == "Windows 10") {
            AnsiConsole.systemInstall();
            System.err.println(Ansi.ansi()
                    .fg(Color.RED)
                    .a("\nerror in file, line " + line + ":")
                    .reset());
            AnsiConsole.systemUninstall();
        }
        else {
            System.err.format("\033[31merror in file, line %d:\n \033[0m", line);
        }

        System.err.format("%s\n", msg);
    }
}