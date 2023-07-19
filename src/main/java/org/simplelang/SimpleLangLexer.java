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
		WHILE=1, TRUE=2, FALSE=3, EQ=4, PLUS=5, MINUS=6, MUL=7, DIV=8, LESS=9, 
		GREAT=10, CMP_EQ=11, CMP_NEQ=12, AND=13, OR=14, NOT=15, LPAR=16, RPAR=17, 
		LCURL=18, RCURL=19, WS=20, NL=21, INT=22, ID=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHILE", "TRUE", "FALSE", "EQ", "PLUS", "MINUS", "MUL", "DIV", "LESS", 
			"GREAT", "CMP_EQ", "CMP_NEQ", "AND", "OR", "NOT", "LPAR", "RPAR", "LCURL", 
			"RCURL", "WS", "NL", "INT", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'while'", "'true'", "'false'", "':='", "'+'", "'-'", "'*'", "'/'", 
			"'<'", "'>'", "'='", "'/='", "'and'", "'or'", "'not'", "'('", "')'", 
			"'{'", "'}'", null, "'\\r\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHILE", "TRUE", "FALSE", "EQ", "PLUS", "MINUS", "MUL", "DIV", 
			"LESS", "GREAT", "CMP_EQ", "CMP_NEQ", "AND", "OR", "NOT", "LPAR", "RPAR", 
			"LCURL", "RCURL", "WS", "NL", "INT", "ID"
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
		"\u0004\u0000\u0017}\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0004"+
		"\u0015r\b\u0015\u000b\u0015\f\u0015s\u0001\u0016\u0003\u0016w\b\u0016"+
		"\u0001\u0016\u0004\u0016z\b\u0016\u000b\u0016\f\u0016{\u0000\u0000\u0017"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"\u0001\u0000\u0003\u0003\u0000\t\t\r\r  \u0001\u000009\u0002\u0000AZa"+
		"z\u007f\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000"+
		"\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000"+
		"\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000"+
		"\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000"+
		"\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000"+
		"\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000"+
		"\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000"+
		"\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000"+
		"!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001"+
		"\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000"+
		"\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000"+
		"\u0001/\u0001\u0000\u0000\u0000\u00035\u0001\u0000\u0000\u0000\u0005:"+
		"\u0001\u0000\u0000\u0000\u0007@\u0001\u0000\u0000\u0000\tC\u0001\u0000"+
		"\u0000\u0000\u000bE\u0001\u0000\u0000\u0000\rG\u0001\u0000\u0000\u0000"+
		"\u000fI\u0001\u0000\u0000\u0000\u0011K\u0001\u0000\u0000\u0000\u0013M"+
		"\u0001\u0000\u0000\u0000\u0015O\u0001\u0000\u0000\u0000\u0017Q\u0001\u0000"+
		"\u0000\u0000\u0019T\u0001\u0000\u0000\u0000\u001bX\u0001\u0000\u0000\u0000"+
		"\u001d[\u0001\u0000\u0000\u0000\u001f_\u0001\u0000\u0000\u0000!a\u0001"+
		"\u0000\u0000\u0000#c\u0001\u0000\u0000\u0000%e\u0001\u0000\u0000\u0000"+
		"\'g\u0001\u0000\u0000\u0000)k\u0001\u0000\u0000\u0000+q\u0001\u0000\u0000"+
		"\u0000-v\u0001\u0000\u0000\u0000/0\u0005w\u0000\u000001\u0005h\u0000\u0000"+
		"12\u0005i\u0000\u000023\u0005l\u0000\u000034\u0005e\u0000\u00004\u0002"+
		"\u0001\u0000\u0000\u000056\u0005t\u0000\u000067\u0005r\u0000\u000078\u0005"+
		"u\u0000\u000089\u0005e\u0000\u00009\u0004\u0001\u0000\u0000\u0000:;\u0005"+
		"f\u0000\u0000;<\u0005a\u0000\u0000<=\u0005l\u0000\u0000=>\u0005s\u0000"+
		"\u0000>?\u0005e\u0000\u0000?\u0006\u0001\u0000\u0000\u0000@A\u0005:\u0000"+
		"\u0000AB\u0005=\u0000\u0000B\b\u0001\u0000\u0000\u0000CD\u0005+\u0000"+
		"\u0000D\n\u0001\u0000\u0000\u0000EF\u0005-\u0000\u0000F\f\u0001\u0000"+
		"\u0000\u0000GH\u0005*\u0000\u0000H\u000e\u0001\u0000\u0000\u0000IJ\u0005"+
		"/\u0000\u0000J\u0010\u0001\u0000\u0000\u0000KL\u0005<\u0000\u0000L\u0012"+
		"\u0001\u0000\u0000\u0000MN\u0005>\u0000\u0000N\u0014\u0001\u0000\u0000"+
		"\u0000OP\u0005=\u0000\u0000P\u0016\u0001\u0000\u0000\u0000QR\u0005/\u0000"+
		"\u0000RS\u0005=\u0000\u0000S\u0018\u0001\u0000\u0000\u0000TU\u0005a\u0000"+
		"\u0000UV\u0005n\u0000\u0000VW\u0005d\u0000\u0000W\u001a\u0001\u0000\u0000"+
		"\u0000XY\u0005o\u0000\u0000YZ\u0005r\u0000\u0000Z\u001c\u0001\u0000\u0000"+
		"\u0000[\\\u0005n\u0000\u0000\\]\u0005o\u0000\u0000]^\u0005t\u0000\u0000"+
		"^\u001e\u0001\u0000\u0000\u0000_`\u0005(\u0000\u0000` \u0001\u0000\u0000"+
		"\u0000ab\u0005)\u0000\u0000b\"\u0001\u0000\u0000\u0000cd\u0005{\u0000"+
		"\u0000d$\u0001\u0000\u0000\u0000ef\u0005}\u0000\u0000f&\u0001\u0000\u0000"+
		"\u0000gh\u0007\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ij\u0006\u0013"+
		"\u0000\u0000j(\u0001\u0000\u0000\u0000kl\u0005\r\u0000\u0000lm\u0005\n"+
		"\u0000\u0000mn\u0001\u0000\u0000\u0000no\u0006\u0014\u0000\u0000o*\u0001"+
		"\u0000\u0000\u0000pr\u0007\u0001\u0000\u0000qp\u0001\u0000\u0000\u0000"+
		"rs\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000t,\u0001\u0000\u0000\u0000uw\u0005_\u0000\u0000vu\u0001\u0000\u0000"+
		"\u0000vw\u0001\u0000\u0000\u0000wy\u0001\u0000\u0000\u0000xz\u0007\u0002"+
		"\u0000\u0000yx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{y\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|.\u0001\u0000\u0000\u0000"+
		"\u0004\u0000sv{\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}