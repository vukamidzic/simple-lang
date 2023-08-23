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
		WHILE=1, FOR=2, TRUE=3, FALSE=4, EQ=5, DSEMIC=6, PLUS=7, MINUS=8, MUL=9, 
		DIV=10, LARROW=11, LESS=12, GREAT=13, CMP_EQ=14, CMP_NEQ=15, AND=16, OR=17, 
		NOT=18, LPAR=19, RPAR=20, LCURL=21, RCURL=22, QMARK=23, COMMA=24, WS=25, 
		NL=26, INT=27, FLOAT=28, ID=29;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"WHILE", "FOR", "TRUE", "FALSE", "EQ", "DSEMIC", "PLUS", "MINUS", "MUL", 
			"DIV", "LARROW", "LESS", "GREAT", "CMP_EQ", "CMP_NEQ", "AND", "OR", "NOT", 
			"LPAR", "RPAR", "LCURL", "RCURL", "QMARK", "COMMA", "WS", "NL", "INT", 
			"FLOAT", "ID"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'while'", "'for'", "'true'", "'false'", "':='", "'::'", "'+'", 
			"'-'", "'*'", "'/'", "'<-'", "'<'", "'>'", "'='", "'/='", "'and'", "'or'", 
			"'not'", "'('", "')'", "'{'", "'}'", "'?'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHILE", "FOR", "TRUE", "FALSE", "EQ", "DSEMIC", "PLUS", "MINUS", 
			"MUL", "DIV", "LARROW", "LESS", "GREAT", "CMP_EQ", "CMP_NEQ", "AND", 
			"OR", "NOT", "LPAR", "RPAR", "LCURL", "RCURL", "QMARK", "COMMA", "WS", 
			"NL", "INT", "FLOAT", "ID"
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
		"\u0004\u0000\u001d\u00a4\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0003\u0018"+
		"\u0083\b\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0003\u0019\u008a\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0003\u001a"+
		"\u008f\b\u001a\u0001\u001a\u0004\u001a\u0092\b\u001a\u000b\u001a\f\u001a"+
		"\u0093\u0001\u001b\u0003\u001b\u0097\b\u001b\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0003\u001c\u009e\b\u001c\u0001\u001c\u0004"+
		"\u001c\u00a1\b\u001c\u000b\u001c\f\u001c\u00a2\u0000\u0000\u001d\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d"+
		"\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/"+
		"\u00181\u00193\u001a5\u001b7\u001c9\u001d\u0001\u0000\u0003\u0003\u0000"+
		"\t\t\r\r  \u0001\u000009\u0002\u0000AZaz\u00a9\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000"+
		"\u0000\u0001;\u0001\u0000\u0000\u0000\u0003A\u0001\u0000\u0000\u0000\u0005"+
		"E\u0001\u0000\u0000\u0000\u0007J\u0001\u0000\u0000\u0000\tP\u0001\u0000"+
		"\u0000\u0000\u000bS\u0001\u0000\u0000\u0000\rV\u0001\u0000\u0000\u0000"+
		"\u000fX\u0001\u0000\u0000\u0000\u0011Z\u0001\u0000\u0000\u0000\u0013\\"+
		"\u0001\u0000\u0000\u0000\u0015^\u0001\u0000\u0000\u0000\u0017a\u0001\u0000"+
		"\u0000\u0000\u0019c\u0001\u0000\u0000\u0000\u001be\u0001\u0000\u0000\u0000"+
		"\u001dg\u0001\u0000\u0000\u0000\u001fj\u0001\u0000\u0000\u0000!n\u0001"+
		"\u0000\u0000\u0000#q\u0001\u0000\u0000\u0000%u\u0001\u0000\u0000\u0000"+
		"\'w\u0001\u0000\u0000\u0000)y\u0001\u0000\u0000\u0000+{\u0001\u0000\u0000"+
		"\u0000-}\u0001\u0000\u0000\u0000/\u007f\u0001\u0000\u0000\u00001\u0082"+
		"\u0001\u0000\u0000\u00003\u0089\u0001\u0000\u0000\u00005\u008e\u0001\u0000"+
		"\u0000\u00007\u0096\u0001\u0000\u0000\u00009\u009d\u0001\u0000\u0000\u0000"+
		";<\u0005w\u0000\u0000<=\u0005h\u0000\u0000=>\u0005i\u0000\u0000>?\u0005"+
		"l\u0000\u0000?@\u0005e\u0000\u0000@\u0002\u0001\u0000\u0000\u0000AB\u0005"+
		"f\u0000\u0000BC\u0005o\u0000\u0000CD\u0005r\u0000\u0000D\u0004\u0001\u0000"+
		"\u0000\u0000EF\u0005t\u0000\u0000FG\u0005r\u0000\u0000GH\u0005u\u0000"+
		"\u0000HI\u0005e\u0000\u0000I\u0006\u0001\u0000\u0000\u0000JK\u0005f\u0000"+
		"\u0000KL\u0005a\u0000\u0000LM\u0005l\u0000\u0000MN\u0005s\u0000\u0000"+
		"NO\u0005e\u0000\u0000O\b\u0001\u0000\u0000\u0000PQ\u0005:\u0000\u0000"+
		"QR\u0005=\u0000\u0000R\n\u0001\u0000\u0000\u0000ST\u0005:\u0000\u0000"+
		"TU\u0005:\u0000\u0000U\f\u0001\u0000\u0000\u0000VW\u0005+\u0000\u0000"+
		"W\u000e\u0001\u0000\u0000\u0000XY\u0005-\u0000\u0000Y\u0010\u0001\u0000"+
		"\u0000\u0000Z[\u0005*\u0000\u0000[\u0012\u0001\u0000\u0000\u0000\\]\u0005"+
		"/\u0000\u0000]\u0014\u0001\u0000\u0000\u0000^_\u0005<\u0000\u0000_`\u0005"+
		"-\u0000\u0000`\u0016\u0001\u0000\u0000\u0000ab\u0005<\u0000\u0000b\u0018"+
		"\u0001\u0000\u0000\u0000cd\u0005>\u0000\u0000d\u001a\u0001\u0000\u0000"+
		"\u0000ef\u0005=\u0000\u0000f\u001c\u0001\u0000\u0000\u0000gh\u0005/\u0000"+
		"\u0000hi\u0005=\u0000\u0000i\u001e\u0001\u0000\u0000\u0000jk\u0005a\u0000"+
		"\u0000kl\u0005n\u0000\u0000lm\u0005d\u0000\u0000m \u0001\u0000\u0000\u0000"+
		"no\u0005o\u0000\u0000op\u0005r\u0000\u0000p\"\u0001\u0000\u0000\u0000"+
		"qr\u0005n\u0000\u0000rs\u0005o\u0000\u0000st\u0005t\u0000\u0000t$\u0001"+
		"\u0000\u0000\u0000uv\u0005(\u0000\u0000v&\u0001\u0000\u0000\u0000wx\u0005"+
		")\u0000\u0000x(\u0001\u0000\u0000\u0000yz\u0005{\u0000\u0000z*\u0001\u0000"+
		"\u0000\u0000{|\u0005}\u0000\u0000|,\u0001\u0000\u0000\u0000}~\u0005?\u0000"+
		"\u0000~.\u0001\u0000\u0000\u0000\u007f\u0080\u0005,\u0000\u0000\u0080"+
		"0\u0001\u0000\u0000\u0000\u0081\u0083\u0007\u0000\u0000\u0000\u0082\u0081"+
		"\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0006\u0018\u0000\u0000\u00852\u0001\u0000\u0000\u0000\u0086\u0087\u0005"+
		"\r\u0000\u0000\u0087\u008a\u0005\n\u0000\u0000\u0088\u008a\u0005\n\u0000"+
		"\u0000\u0089\u0086\u0001\u0000\u0000\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008c\u0006\u0019\u0000"+
		"\u0000\u008c4\u0001\u0000\u0000\u0000\u008d\u008f\u0005-\u0000\u0000\u008e"+
		"\u008d\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f"+
		"\u0091\u0001\u0000\u0000\u0000\u0090\u0092\u0007\u0001\u0000\u0000\u0091"+
		"\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093"+
		"\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094"+
		"6\u0001\u0000\u0000\u0000\u0095\u0097\u0005-\u0000\u0000\u0096\u0095\u0001"+
		"\u0000\u0000\u0000\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0001"+
		"\u0000\u0000\u0000\u0098\u0099\u00035\u001a\u0000\u0099\u009a\u0005.\u0000"+
		"\u0000\u009a\u009b\u00035\u001a\u0000\u009b8\u0001\u0000\u0000\u0000\u009c"+
		"\u009e\u0005_\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009d\u009e"+
		"\u0001\u0000\u0000\u0000\u009e\u00a0\u0001\u0000\u0000\u0000\u009f\u00a1"+
		"\u0007\u0002\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3"+
		"\u0001\u0000\u0000\u0000\u00a3:\u0001\u0000\u0000\u0000\b\u0000\u0082"+
		"\u0089\u008e\u0093\u0096\u009d\u00a2\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}