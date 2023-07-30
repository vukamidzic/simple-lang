package org.simplelang;

// Generated from src/main/java/org/simplelang/SimpleLang.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHILE=1, TRUE=2, FALSE=3, EQ=4, DSEMIC=5, PLUS=6, MINUS=7, MUL=8, DIV=9, 
		LESS=10, GREAT=11, CMP_EQ=12, CMP_NEQ=13, AND=14, OR=15, NOT=16, LPAR=17, 
		RPAR=18, LCURL=19, RCURL=20, QMARK=21, WS=22, NL=23, INT=24, FLOAT=25, 
		ID=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHILE", "TRUE", "FALSE", "EQ", "DSEMIC", "PLUS", "MINUS", "MUL", "DIV", 
			"LESS", "GREAT", "CMP_EQ", "CMP_NEQ", "AND", "OR", "NOT", "LPAR", "RPAR", 
			"LCURL", "RCURL", "QMARK", "WS", "NL", "INT", "FLOAT", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'while'", "'true'", "'false'", "':='", "'::'", "'+'", "'-'", "'*'", 
			"'/'", "'<'", "'>'", "'='", "'/='", "'and'", "'or'", "'not'", "'('", 
			"')'", "'{'", "'}'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHILE", "TRUE", "FALSE", "EQ", "DSEMIC", "PLUS", "MINUS", "MUL", 
			"DIV", "LESS", "GREAT", "CMP_EQ", "CMP_NEQ", "AND", "OR", "NOT", "LPAR", 
			"RPAR", "LCURL", "RCURL", "QMARK", "WS", "NL", "INT", "FLOAT", "ID"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public SimpleLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u001a\u0094\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016z\b\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0017\u0003\u0017\u007f\b\u0017\u0001\u0017\u0004\u0017\u0082\b\u0017"+
		"\u000b\u0017\f\u0017\u0083\u0001\u0018\u0003\u0018\u0087\b\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0003\u0019\u008e"+
		"\b\u0019\u0001\u0019\u0004\u0019\u0091\b\u0019\u000b\u0019\f\u0019\u0092"+
		"\u0000\u0000\u001a\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005"+
		"\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019"+
		"\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015"+
		"+\u0016-\u0017/\u00181\u00193\u001a\u0001\u0000\u0003\u0003\u0000\t\t"+
		"\r\r  \u0001\u000009\u0002\u0000AZaz\u0099\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00015\u0001\u0000"+
		"\u0000\u0000\u0003;\u0001\u0000\u0000\u0000\u0005@\u0001\u0000\u0000\u0000"+
		"\u0007F\u0001\u0000\u0000\u0000\tI\u0001\u0000\u0000\u0000\u000bL\u0001"+
		"\u0000\u0000\u0000\rN\u0001\u0000\u0000\u0000\u000fP\u0001\u0000\u0000"+
		"\u0000\u0011R\u0001\u0000\u0000\u0000\u0013T\u0001\u0000\u0000\u0000\u0015"+
		"V\u0001\u0000\u0000\u0000\u0017X\u0001\u0000\u0000\u0000\u0019Z\u0001"+
		"\u0000\u0000\u0000\u001b]\u0001\u0000\u0000\u0000\u001da\u0001\u0000\u0000"+
		"\u0000\u001fd\u0001\u0000\u0000\u0000!h\u0001\u0000\u0000\u0000#j\u0001"+
		"\u0000\u0000\u0000%l\u0001\u0000\u0000\u0000\'n\u0001\u0000\u0000\u0000"+
		")p\u0001\u0000\u0000\u0000+r\u0001\u0000\u0000\u0000-y\u0001\u0000\u0000"+
		"\u0000/~\u0001\u0000\u0000\u00001\u0086\u0001\u0000\u0000\u00003\u008d"+
		"\u0001\u0000\u0000\u000056\u0005w\u0000\u000067\u0005h\u0000\u000078\u0005"+
		"i\u0000\u000089\u0005l\u0000\u00009:\u0005e\u0000\u0000:\u0002\u0001\u0000"+
		"\u0000\u0000;<\u0005t\u0000\u0000<=\u0005r\u0000\u0000=>\u0005u\u0000"+
		"\u0000>?\u0005e\u0000\u0000?\u0004\u0001\u0000\u0000\u0000@A\u0005f\u0000"+
		"\u0000AB\u0005a\u0000\u0000BC\u0005l\u0000\u0000CD\u0005s\u0000\u0000"+
		"DE\u0005e\u0000\u0000E\u0006\u0001\u0000\u0000\u0000FG\u0005:\u0000\u0000"+
		"GH\u0005=\u0000\u0000H\b\u0001\u0000\u0000\u0000IJ\u0005:\u0000\u0000"+
		"JK\u0005:\u0000\u0000K\n\u0001\u0000\u0000\u0000LM\u0005+\u0000\u0000"+
		"M\f\u0001\u0000\u0000\u0000NO\u0005-\u0000\u0000O\u000e\u0001\u0000\u0000"+
		"\u0000PQ\u0005*\u0000\u0000Q\u0010\u0001\u0000\u0000\u0000RS\u0005/\u0000"+
		"\u0000S\u0012\u0001\u0000\u0000\u0000TU\u0005<\u0000\u0000U\u0014\u0001"+
		"\u0000\u0000\u0000VW\u0005>\u0000\u0000W\u0016\u0001\u0000\u0000\u0000"+
		"XY\u0005=\u0000\u0000Y\u0018\u0001\u0000\u0000\u0000Z[\u0005/\u0000\u0000"+
		"[\\\u0005=\u0000\u0000\\\u001a\u0001\u0000\u0000\u0000]^\u0005a\u0000"+
		"\u0000^_\u0005n\u0000\u0000_`\u0005d\u0000\u0000`\u001c\u0001\u0000\u0000"+
		"\u0000ab\u0005o\u0000\u0000bc\u0005r\u0000\u0000c\u001e\u0001\u0000\u0000"+
		"\u0000de\u0005n\u0000\u0000ef\u0005o\u0000\u0000fg\u0005t\u0000\u0000"+
		"g \u0001\u0000\u0000\u0000hi\u0005(\u0000\u0000i\"\u0001\u0000\u0000\u0000"+
		"jk\u0005)\u0000\u0000k$\u0001\u0000\u0000\u0000lm\u0005{\u0000\u0000m"+
		"&\u0001\u0000\u0000\u0000no\u0005}\u0000\u0000o(\u0001\u0000\u0000\u0000"+
		"pq\u0005?\u0000\u0000q*\u0001\u0000\u0000\u0000rs\u0007\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000tu\u0006\u0015\u0000\u0000u,\u0001\u0000\u0000"+
		"\u0000vw\u0005\r\u0000\u0000wz\u0005\n\u0000\u0000xz\u0005\n\u0000\u0000"+
		"yv\u0001\u0000\u0000\u0000yx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000"+
		"\u0000{|\u0006\u0016\u0000\u0000|.\u0001\u0000\u0000\u0000}\u007f\u0005"+
		"-\u0000\u0000~}\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000"+
		"\u007f\u0081\u0001\u0000\u0000\u0000\u0080\u0082\u0007\u0001\u0000\u0000"+
		"\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000"+
		"\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000"+
		"\u00840\u0001\u0000\u0000\u0000\u0085\u0087\u0005-\u0000\u0000\u0086\u0085"+
		"\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\u0089\u0003/\u0017\u0000\u0089\u008a\u0005"+
		".\u0000\u0000\u008a\u008b\u0003/\u0017\u0000\u008b2\u0001\u0000\u0000"+
		"\u0000\u008c\u008e\u0005_\u0000\u0000\u008d\u008c\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090\u0001\u0000\u0000\u0000"+
		"\u008f\u0091\u0007\u0002\u0000\u0000\u0090\u008f\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\u0001\u0000\u0000\u0000\u00934\u0001\u0000\u0000\u0000\u0007"+
		"\u0000y~\u0083\u0086\u008d\u0092\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}