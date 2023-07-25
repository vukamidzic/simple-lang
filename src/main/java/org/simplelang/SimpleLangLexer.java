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
		LCURL=18, RCURL=19, QMARK=20, WS=21, NL=22, INT=23, FLOAT=24, ID=25;
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
			"RCURL", "QMARK", "WS", "NL", "INT", "FLOAT", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'while'", "'true'", "'false'", "':='", "'+'", "'-'", "'*'", "'/'", 
			"'<'", "'>'", "'='", "'/='", "'and'", "'or'", "'not'", "'('", "')'", 
			"'{'", "'}'", "'?'", null, "'\\r\\n'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHILE", "TRUE", "FALSE", "EQ", "PLUS", "MINUS", "MUL", "DIV", 
			"LESS", "GREAT", "CMP_EQ", "CMP_NEQ", "AND", "OR", "NOT", "LPAR", "RPAR", 
			"LCURL", "RCURL", "QMARK", "WS", "NL", "INT", "FLOAT", "ID"
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
		"\u0004\u0000\u0019\u008d\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0003"+
		"\u0016x\b\u0016\u0001\u0016\u0004\u0016{\b\u0016\u000b\u0016\f\u0016|"+
		"\u0001\u0017\u0003\u0017\u0080\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0003\u0018\u0087\b\u0018\u0001\u0018\u0004\u0018"+
		"\u008a\b\u0018\u000b\u0018\f\u0018\u008b\u0000\u0000\u0019\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u0018"+
		"1\u0019\u0001\u0000\u0003\u0003\u0000\t\t\r\r  \u0001\u000009\u0002\u0000"+
		"AZaz\u0091\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001"+
		"\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000"+
		"\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u0001"+
		"3\u0001\u0000\u0000\u0000\u00039\u0001\u0000\u0000\u0000\u0005>\u0001"+
		"\u0000\u0000\u0000\u0007D\u0001\u0000\u0000\u0000\tG\u0001\u0000\u0000"+
		"\u0000\u000bI\u0001\u0000\u0000\u0000\rK\u0001\u0000\u0000\u0000\u000f"+
		"M\u0001\u0000\u0000\u0000\u0011O\u0001\u0000\u0000\u0000\u0013Q\u0001"+
		"\u0000\u0000\u0000\u0015S\u0001\u0000\u0000\u0000\u0017U\u0001\u0000\u0000"+
		"\u0000\u0019X\u0001\u0000\u0000\u0000\u001b\\\u0001\u0000\u0000\u0000"+
		"\u001d_\u0001\u0000\u0000\u0000\u001fc\u0001\u0000\u0000\u0000!e\u0001"+
		"\u0000\u0000\u0000#g\u0001\u0000\u0000\u0000%i\u0001\u0000\u0000\u0000"+
		"\'k\u0001\u0000\u0000\u0000)m\u0001\u0000\u0000\u0000+q\u0001\u0000\u0000"+
		"\u0000-w\u0001\u0000\u0000\u0000/\u007f\u0001\u0000\u0000\u00001\u0086"+
		"\u0001\u0000\u0000\u000034\u0005w\u0000\u000045\u0005h\u0000\u000056\u0005"+
		"i\u0000\u000067\u0005l\u0000\u000078\u0005e\u0000\u00008\u0002\u0001\u0000"+
		"\u0000\u00009:\u0005t\u0000\u0000:;\u0005r\u0000\u0000;<\u0005u\u0000"+
		"\u0000<=\u0005e\u0000\u0000=\u0004\u0001\u0000\u0000\u0000>?\u0005f\u0000"+
		"\u0000?@\u0005a\u0000\u0000@A\u0005l\u0000\u0000AB\u0005s\u0000\u0000"+
		"BC\u0005e\u0000\u0000C\u0006\u0001\u0000\u0000\u0000DE\u0005:\u0000\u0000"+
		"EF\u0005=\u0000\u0000F\b\u0001\u0000\u0000\u0000GH\u0005+\u0000\u0000"+
		"H\n\u0001\u0000\u0000\u0000IJ\u0005-\u0000\u0000J\f\u0001\u0000\u0000"+
		"\u0000KL\u0005*\u0000\u0000L\u000e\u0001\u0000\u0000\u0000MN\u0005/\u0000"+
		"\u0000N\u0010\u0001\u0000\u0000\u0000OP\u0005<\u0000\u0000P\u0012\u0001"+
		"\u0000\u0000\u0000QR\u0005>\u0000\u0000R\u0014\u0001\u0000\u0000\u0000"+
		"ST\u0005=\u0000\u0000T\u0016\u0001\u0000\u0000\u0000UV\u0005/\u0000\u0000"+
		"VW\u0005=\u0000\u0000W\u0018\u0001\u0000\u0000\u0000XY\u0005a\u0000\u0000"+
		"YZ\u0005n\u0000\u0000Z[\u0005d\u0000\u0000[\u001a\u0001\u0000\u0000\u0000"+
		"\\]\u0005o\u0000\u0000]^\u0005r\u0000\u0000^\u001c\u0001\u0000\u0000\u0000"+
		"_`\u0005n\u0000\u0000`a\u0005o\u0000\u0000ab\u0005t\u0000\u0000b\u001e"+
		"\u0001\u0000\u0000\u0000cd\u0005(\u0000\u0000d \u0001\u0000\u0000\u0000"+
		"ef\u0005)\u0000\u0000f\"\u0001\u0000\u0000\u0000gh\u0005{\u0000\u0000"+
		"h$\u0001\u0000\u0000\u0000ij\u0005}\u0000\u0000j&\u0001\u0000\u0000\u0000"+
		"kl\u0005?\u0000\u0000l(\u0001\u0000\u0000\u0000mn\u0007\u0000\u0000\u0000"+
		"no\u0001\u0000\u0000\u0000op\u0006\u0014\u0000\u0000p*\u0001\u0000\u0000"+
		"\u0000qr\u0005\r\u0000\u0000rs\u0005\n\u0000\u0000st\u0001\u0000\u0000"+
		"\u0000tu\u0006\u0015\u0000\u0000u,\u0001\u0000\u0000\u0000vx\u0005-\u0000"+
		"\u0000wv\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000xz\u0001\u0000"+
		"\u0000\u0000y{\u0007\u0001\u0000\u0000zy\u0001\u0000\u0000\u0000{|\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000"+
		"}.\u0001\u0000\u0000\u0000~\u0080\u0005-\u0000\u0000\u007f~\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0003-\u0016\u0000\u0082\u0083\u0005.\u0000\u0000"+
		"\u0083\u0084\u0003-\u0016\u0000\u00840\u0001\u0000\u0000\u0000\u0085\u0087"+
		"\u0005_\u0000\u0000\u0086\u0085\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u008a\u0007"+
		"\u0002\u0000\u0000\u0089\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001"+
		"\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008b\u008c\u0001"+
		"\u0000\u0000\u0000\u008c2\u0001\u0000\u0000\u0000\u0006\u0000w|\u007f"+
		"\u0086\u008b\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}