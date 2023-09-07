package org.simplelang;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;

public class ParseErrListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object symbol,
        int line, int charPosInLine, String msg, RecognitionException e) {
        System.out.println(symbol);
        System.err.format("line %d:%d %s\n", line, charPosInLine, msg);
    }
}