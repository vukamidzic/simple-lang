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
		WHILE=1, FOR=2, PTR=3, TRUE=4, FALSE=5, EQ=6, DSEMIC=7, PLUS=8, MINUS=9, 
		MUL=10, DIV=11, LARROW=12, LESS=13, GREAT=14, CMP_EQ=15, CMP_NEQ=16, AND=17, 
		OR=18, NOT=19, LPAR=20, RPAR=21, LCURL=22, RCURL=23, QMARK=24, COMMA=25, 
		WS=26, NL=27, INT=28, FLOAT=29, ID=30;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHILE", "FOR", "PTR", "TRUE", "FALSE", "EQ", "DSEMIC", "PLUS", "MINUS", 
			"MUL", "DIV", "LARROW", "LESS", "GREAT", "CMP_EQ", "CMP_NEQ", "AND", 
			"OR", "NOT", "LPAR", "RPAR", "LCURL", "RCURL", "QMARK", "COMMA", "WS", 
			"NL", "INT", "FLOAT", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'while'", "'for'", "'ptr'", "'true'", "'false'", "':='", "'::'", 
			"'+'", "'-'", "'*'", "'/'", "'<-'", "'<'", "'>'", "'='", "'/='", "'and'", 
			"'or'", "'not'", "'('", "')'", "'{'", "'}'", "'?'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHILE", "FOR", "PTR", "TRUE", "FALSE", "EQ", "DSEMIC", "PLUS", 
			"MINUS", "MUL", "DIV", "LARROW", "LESS", "GREAT", "CMP_EQ", "CMP_NEQ", 
			"AND", "OR", "NOT", "LPAR", "RPAR", "LCURL", "RCURL", "QMARK", "COMMA", 
			"WS", "NL", "INT", "FLOAT", "ID"
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
		"\u0004\u0000\u001e\u00aa\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0003"+
		"\u0019\u0089\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0003\u001a\u0090\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0003"+
		"\u001b\u0095\b\u001b\u0001\u001b\u0004\u001b\u0098\b\u001b\u000b\u001b"+
		"\f\u001b\u0099\u0001\u001c\u0003\u001c\u009d\b\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0003\u001d\u00a4\b\u001d\u0001"+
		"\u001d\u0004\u001d\u00a7\b\u001d\u000b\u001d\f\u001d\u00a8\u0000\u0000"+
		"\u001e\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006"+
		"\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e\u0001\u0000\u0003\u0003"+
		"\u0000\t\t\r\r  \u0001\u000009\u0002\u0000AZaz\u00af\u0000\u0001\u0001"+
		"\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001"+
		"\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000"+
		"\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000"+
		"\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000"+
		"\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000"+
		"\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000"+
		"\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000"+
		"\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000"+
		"\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'"+
		"\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000"+
		"\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000"+
		"\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005"+
		"\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000"+
		"\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0001=\u0001\u0000\u0000\u0000"+
		"\u0003C\u0001\u0000\u0000\u0000\u0005G\u0001\u0000\u0000\u0000\u0007K"+
		"\u0001\u0000\u0000\u0000\tP\u0001\u0000\u0000\u0000\u000bV\u0001\u0000"+
		"\u0000\u0000\rY\u0001\u0000\u0000\u0000\u000f\\\u0001\u0000\u0000\u0000"+
		"\u0011^\u0001\u0000\u0000\u0000\u0013`\u0001\u0000\u0000\u0000\u0015b"+
		"\u0001\u0000\u0000\u0000\u0017d\u0001\u0000\u0000\u0000\u0019g\u0001\u0000"+
		"\u0000\u0000\u001bi\u0001\u0000\u0000\u0000\u001dk\u0001\u0000\u0000\u0000"+
		"\u001fm\u0001\u0000\u0000\u0000!p\u0001\u0000\u0000\u0000#t\u0001\u0000"+
		"\u0000\u0000%w\u0001\u0000\u0000\u0000\'{\u0001\u0000\u0000\u0000)}\u0001"+
		"\u0000\u0000\u0000+\u007f\u0001\u0000\u0000\u0000-\u0081\u0001\u0000\u0000"+
		"\u0000/\u0083\u0001\u0000\u0000\u00001\u0085\u0001\u0000\u0000\u00003"+
		"\u0088\u0001\u0000\u0000\u00005\u008f\u0001\u0000\u0000\u00007\u0094\u0001"+
		"\u0000\u0000\u00009\u009c\u0001\u0000\u0000\u0000;\u00a3\u0001\u0000\u0000"+
		"\u0000=>\u0005w\u0000\u0000>?\u0005h\u0000\u0000?@\u0005i\u0000\u0000"+
		"@A\u0005l\u0000\u0000AB\u0005e\u0000\u0000B\u0002\u0001\u0000\u0000\u0000"+
		"CD\u0005f\u0000\u0000DE\u0005o\u0000\u0000EF\u0005r\u0000\u0000F\u0004"+
		"\u0001\u0000\u0000\u0000GH\u0005p\u0000\u0000HI\u0005t\u0000\u0000IJ\u0005"+
		"r\u0000\u0000J\u0006\u0001\u0000\u0000\u0000KL\u0005t\u0000\u0000LM\u0005"+
		"r\u0000\u0000MN\u0005u\u0000\u0000NO\u0005e\u0000\u0000O\b\u0001\u0000"+
		"\u0000\u0000PQ\u0005f\u0000\u0000QR\u0005a\u0000\u0000RS\u0005l\u0000"+
		"\u0000ST\u0005s\u0000\u0000TU\u0005e\u0000\u0000U\n\u0001\u0000\u0000"+
		"\u0000VW\u0005:\u0000\u0000WX\u0005=\u0000\u0000X\f\u0001\u0000\u0000"+
		"\u0000YZ\u0005:\u0000\u0000Z[\u0005:\u0000\u0000[\u000e\u0001\u0000\u0000"+
		"\u0000\\]\u0005+\u0000\u0000]\u0010\u0001\u0000\u0000\u0000^_\u0005-\u0000"+
		"\u0000_\u0012\u0001\u0000\u0000\u0000`a\u0005*\u0000\u0000a\u0014\u0001"+
		"\u0000\u0000\u0000bc\u0005/\u0000\u0000c\u0016\u0001\u0000\u0000\u0000"+
		"de\u0005<\u0000\u0000ef\u0005-\u0000\u0000f\u0018\u0001\u0000\u0000\u0000"+
		"gh\u0005<\u0000\u0000h\u001a\u0001\u0000\u0000\u0000ij\u0005>\u0000\u0000"+
		"j\u001c\u0001\u0000\u0000\u0000kl\u0005=\u0000\u0000l\u001e\u0001\u0000"+
		"\u0000\u0000mn\u0005/\u0000\u0000no\u0005=\u0000\u0000o \u0001\u0000\u0000"+
		"\u0000pq\u0005a\u0000\u0000qr\u0005n\u0000\u0000rs\u0005d\u0000\u0000"+
		"s\"\u0001\u0000\u0000\u0000tu\u0005o\u0000\u0000uv\u0005r\u0000\u0000"+
		"v$\u0001\u0000\u0000\u0000wx\u0005n\u0000\u0000xy\u0005o\u0000\u0000y"+
		"z\u0005t\u0000\u0000z&\u0001\u0000\u0000\u0000{|\u0005(\u0000\u0000|("+
		"\u0001\u0000\u0000\u0000}~\u0005)\u0000\u0000~*\u0001\u0000\u0000\u0000"+
		"\u007f\u0080\u0005{\u0000\u0000\u0080,\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0005}\u0000\u0000\u0082.\u0001\u0000\u0000\u0000\u0083\u0084\u0005?"+
		"\u0000\u0000\u00840\u0001\u0000\u0000\u0000\u0085\u0086\u0005,\u0000\u0000"+
		"\u00862\u0001\u0000\u0000\u0000\u0087\u0089\u0007\u0000\u0000\u0000\u0088"+
		"\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0006\u0019\u0000\u0000\u008b4\u0001\u0000\u0000\u0000\u008c\u008d"+
		"\u0005\r\u0000\u0000\u008d\u0090\u0005\n\u0000\u0000\u008e\u0090\u0005"+
		"\n\u0000\u0000\u008f\u008c\u0001\u0000\u0000\u0000\u008f\u008e\u0001\u0000"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0006\u001a"+
		"\u0000\u0000\u00926\u0001\u0000\u0000\u0000\u0093\u0095\u0005-\u0000\u0000"+
		"\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000"+
		"\u0095\u0097\u0001\u0000\u0000\u0000\u0096\u0098\u0007\u0001\u0000\u0000"+
		"\u0097\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000"+
		"\u009a8\u0001\u0000\u0000\u0000\u009b\u009d\u0005-\u0000\u0000\u009c\u009b"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0001\u0000\u0000\u0000\u009e\u009f\u00037\u001b\u0000\u009f\u00a0\u0005"+
		".\u0000\u0000\u00a0\u00a1\u00037\u001b\u0000\u00a1:\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a4\u0005_\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a7\u0007\u0002\u0000\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9<\u0001\u0000\u0000\u0000\b"+
		"\u0000\u0088\u008f\u0094\u0099\u009c\u00a3\u00a8\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}