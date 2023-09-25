package org.simplelang;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;
import org.antlr.v4.runtime.RecognitionException;

public class ParseErrListener extends BaseErrorListener {
    public String fileName;

    public ParseErrListener(String _fileName) {
        super();
        fileName = _fileName;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object symbol,
        int line, int charPosInLine, String msg, RecognitionException e) {
        String txt = getLine(line);
        Pattern pattern = Pattern.compile("\'.*\'");
        String symbolStr = symbol.toString();
        Matcher matcher = pattern.matcher(symbolStr);
        if (matcher.find()) {
            String res = matcher.group();

            if (System.getProperty("os.name") == "Windows 10") {
                AnsiConsole.systemInstall();
                System.err.println(Ansi.ansi()
                        .fg(Color.RED)
                        .a("\nerror in " + fileName + ", line " + line + ", pos" + charPosInLine + ":")
                        .reset());
                AnsiConsole.systemUninstall();
            }
            else {
                System.err.format("\033[31merror in %s, line %d, pos %d:\n \033[0m", fileName, line, charPosInLine);
            }

            System.err.println("Found symbol " + res);
        }

        //System.err.format("%s\n", msg);
    }

    private String getLine(int i) {
        String line = "";
        try {
			BufferedReader bfReader = new BufferedReader(new FileReader(fileName));
			line = bfReader.readLine(); i--;

			while (i-- > 1) {
				line = bfReader.readLine();
			}

			bfReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        return line;
    } 
}