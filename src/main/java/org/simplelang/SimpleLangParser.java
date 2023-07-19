package org.simplelang;

// Generated from src/main/java/org/simplelang/SimpleLang.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		WHILE=1, TRUE=2, FALSE=3, EQ=4, PLUS=5, MINUS=6, MUL=7, DIV=8, LESS=9, 
		GREAT=10, CMP_EQ=11, CMP_NEQ=12, AND=13, OR=14, NOT=15, LPAR=16, RPAR=17, 
		LCURL=18, RCURL=19, WS=20, NL=21, INT=22, ID=23;
	public static final int
		RULE_program = 0, RULE_statements = 1, RULE_statement = 2, RULE_whileStmt = 3, 
		RULE_block_of_stmts = 4, RULE_assignment = 5, RULE_funcCall = 6, RULE_expr = 7, 
		RULE_logical = 8, RULE_compare = 9, RULE_plusOrMinus = 10, RULE_mulOrDiv = 11, 
		RULE_atom = 12, RULE_bool = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statements", "statement", "whileStmt", "block_of_stmts", 
			"assignment", "funcCall", "expr", "logical", "compare", "plusOrMinus", 
			"mulOrDiv", "atom", "bool"
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

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EndOfProgramContext extends ProgramContext {
		public TerminalNode EOF() { return getToken(SimpleLangParser.EOF, 0); }
		public EndOfProgramContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitEndOfProgram(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToStatementsContext extends ProgramContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ToStatementsContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
			case LCURL:
			case ID:
				_localctx = new ToStatementsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				statements();
				}
				break;
			case EOF:
				_localctx = new EndOfProgramContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(29);
				match(EOF);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
	 
		public StatementsContext() { }
		public void copyFrom(StatementsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SingleStatContext extends StatementsContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public SingleStatContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSingleStat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultipleStatContext extends StatementsContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public MultipleStatContext(StatementsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMultipleStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statements);
		try {
			setState(36);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new MultipleStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				statement();
				setState(33);
				statements();
				}
				break;
			case 2:
				_localctx = new SingleStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToFuncCallContext extends StatementContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public ToFuncCallContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToWhileContext extends StatementContext {
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public ToWhileContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToWhile(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToBlockContext extends StatementContext {
		public Block_of_stmtsContext block_of_stmts() {
			return getRuleContext(Block_of_stmtsContext.class,0);
		}
		public ToBlockContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToAssignmentContext extends StatementContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ToAssignmentContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ToAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				assignment();
				}
				break;
			case 2:
				_localctx = new ToFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				funcCall();
				}
				break;
			case 3:
				_localctx = new ToWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				whileStmt();
				}
				break;
			case 4:
				_localctx = new ToBlockContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(41);
				block_of_stmts();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(SimpleLangParser.WHILE, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public Block_of_stmtsContext block_of_stmts() {
			return getRuleContext(Block_of_stmtsContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			match(WHILE);
			setState(45);
			match(LPAR);
			setState(46);
			expr();
			setState(47);
			match(RPAR);
			setState(48);
			block_of_stmts();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Block_of_stmtsContext extends ParserRuleContext {
		public Block_of_stmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_of_stmts; }
	 
		public Block_of_stmtsContext() { }
		public void copyFrom(Block_of_stmtsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends Block_of_stmtsContext {
		public TerminalNode LCURL() { return getToken(SimpleLangParser.LCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(SimpleLangParser.RCURL, 0); }
		public BlockContext(Block_of_stmtsContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_of_stmtsContext block_of_stmts() throws RecognitionException {
		Block_of_stmtsContext _localctx = new Block_of_stmtsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block_of_stmts);
		try {
			_localctx = new BlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(LCURL);
			setState(51);
			statements();
			setState(52);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	 
		public AssignmentContext() { }
		public void copyFrom(AssignmentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode EQ() { return getToken(SimpleLangParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_assignment);
		try {
			_localctx = new AssignContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(ID);
			setState(55);
			match(EQ);
			setState(56);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallContext extends ParserRuleContext {
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
	 
		public FuncCallContext() { }
		public void copyFrom(FuncCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends FuncCallContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public FunctionCallContext(FuncCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcCall);
		try {
			_localctx = new FunctionCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(ID);
			setState(59);
			match(LPAR);
			setState(60);
			expr();
			setState(61);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ExprContext {
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public ExpressionContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr);
		try {
			_localctx = new ExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			logical(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LogicalContext extends ParserRuleContext {
		public LogicalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logical; }
	 
		public LogicalContext() { }
		public void copyFrom(LogicalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends LogicalContext {
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public TerminalNode OR() { return getToken(SimpleLangParser.OR, 0); }
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public OrContext(LogicalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends LogicalContext {
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
		}
		public TerminalNode AND() { return getToken(SimpleLangParser.AND, 0); }
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public AndContext(LogicalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToCompareContext extends LogicalContext {
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public ToCompareContext(LogicalContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToCompare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalContext logical() throws RecognitionException {
		return logical(0);
	}

	private LogicalContext logical(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicalContext _localctx = new LogicalContext(_ctx, _parentState);
		LogicalContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_logical, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToCompareContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(66);
			compare(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(74);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new LogicalContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical);
						setState(68);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(69);
						match(AND);
						setState(70);
						compare(0);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new LogicalContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical);
						setState(71);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(72);
						match(OR);
						setState(73);
						compare(0);
						}
						break;
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompareContext extends ParserRuleContext {
		public CompareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare; }
	 
		public CompareContext() { }
		public void copyFrom(CompareContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreatContext extends CompareContext {
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public TerminalNode GREAT() { return getToken(SimpleLangParser.GREAT, 0); }
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public GreatContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitGreat(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToPlusOrMinusContext extends CompareContext {
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public ToPlusOrMinusContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToPlusOrMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NeqContext extends CompareContext {
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public TerminalNode CMP_NEQ() { return getToken(SimpleLangParser.CMP_NEQ, 0); }
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public NeqContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitNeq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqContext extends CompareContext {
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public TerminalNode CMP_EQ() { return getToken(SimpleLangParser.CMP_EQ, 0); }
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public EqContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitEq(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessContext extends CompareContext {
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public TerminalNode LESS() { return getToken(SimpleLangParser.LESS, 0); }
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public LessContext(CompareContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitLess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompareContext compare() throws RecognitionException {
		return compare(0);
	}

	private CompareContext compare(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CompareContext _localctx = new CompareContext(_ctx, _parentState);
		CompareContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_compare, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToPlusOrMinusContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(80);
			plusOrMinus(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(94);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new LessContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(82);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(83);
						match(LESS);
						setState(84);
						plusOrMinus(0);
						}
						break;
					case 2:
						{
						_localctx = new GreatContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(85);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(86);
						match(GREAT);
						setState(87);
						plusOrMinus(0);
						}
						break;
					case 3:
						{
						_localctx = new EqContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(88);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(89);
						match(CMP_EQ);
						setState(90);
						plusOrMinus(0);
						}
						break;
					case 4:
						{
						_localctx = new NeqContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(91);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(92);
						match(CMP_NEQ);
						setState(93);
						plusOrMinus(0);
						}
						break;
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PlusOrMinusContext extends ParserRuleContext {
		public PlusOrMinusContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusOrMinus; }
	 
		public PlusOrMinusContext() { }
		public void copyFrom(PlusOrMinusContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToMulOrDivContext extends PlusOrMinusContext {
		public MulOrDivContext mulOrDiv() {
			return getRuleContext(MulOrDivContext.class,0);
		}
		public ToMulOrDivContext(PlusOrMinusContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToMulOrDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusContext extends PlusOrMinusContext {
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(SimpleLangParser.PLUS, 0); }
		public MulOrDivContext mulOrDiv() {
			return getRuleContext(MulOrDivContext.class,0);
		}
		public PlusContext(PlusOrMinusContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitPlus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusContext extends PlusOrMinusContext {
		public PlusOrMinusContext plusOrMinus() {
			return getRuleContext(PlusOrMinusContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(SimpleLangParser.MINUS, 0); }
		public MulOrDivContext mulOrDiv() {
			return getRuleContext(MulOrDivContext.class,0);
		}
		public MinusContext(PlusOrMinusContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMinus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PlusOrMinusContext plusOrMinus() throws RecognitionException {
		return plusOrMinus(0);
	}

	private PlusOrMinusContext plusOrMinus(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PlusOrMinusContext _localctx = new PlusOrMinusContext(_ctx, _parentState);
		PlusOrMinusContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_plusOrMinus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToMulOrDivContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(100);
			mulOrDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(110);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(108);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new PlusOrMinusContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(102);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(103);
						match(PLUS);
						setState(104);
						mulOrDiv(0);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new PlusOrMinusContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(105);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(106);
						match(MINUS);
						setState(107);
						mulOrDiv(0);
						}
						break;
					}
					} 
				}
				setState(112);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MulOrDivContext extends ParserRuleContext {
		public MulOrDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulOrDiv; }
	 
		public MulOrDivContext() { }
		public void copyFrom(MulOrDivContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivContext extends MulOrDivContext {
		public MulOrDivContext mulOrDiv() {
			return getRuleContext(MulOrDivContext.class,0);
		}
		public TerminalNode DIV() { return getToken(SimpleLangParser.DIV, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public DivContext(MulOrDivContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulContext extends MulOrDivContext {
		public MulOrDivContext mulOrDiv() {
			return getRuleContext(MulOrDivContext.class,0);
		}
		public TerminalNode MUL() { return getToken(SimpleLangParser.MUL, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public MulContext(MulOrDivContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMul(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToAtomContext extends MulOrDivContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ToAtomContext(MulOrDivContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MulOrDivContext mulOrDiv() throws RecognitionException {
		return mulOrDiv(0);
	}

	private MulOrDivContext mulOrDiv(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulOrDivContext _localctx = new MulOrDivContext(_ctx, _parentState);
		MulOrDivContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_mulOrDiv, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToAtomContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(114);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(122);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new MulContext(new MulOrDivContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mulOrDiv);
						setState(116);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(117);
						match(MUL);
						setState(118);
						atom();
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new MulOrDivContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mulOrDiv);
						setState(119);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(120);
						match(DIV);
						setState(121);
						atom();
						}
						break;
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
	 
		public AtomContext() { }
		public void copyFrom(AtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends AtomContext {
		public TerminalNode INT() { return getToken(SimpleLangParser.INT, 0); }
		public IntegerContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VariableContext extends AtomContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public VariableContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends AtomContext {
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public CompareContext compare() {
			return getRuleContext(CompareContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public ParensContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitParens(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToBoolContext extends AtomContext {
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public ToBoolContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_atom);
		try {
			setState(134);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
			case FALSE:
				_localctx = new ToBoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				bool();
				}
				break;
			case INT:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				match(INT);
				}
				break;
			case ID:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(ID);
				}
				break;
			case LPAR:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(LPAR);
				setState(131);
				compare(0);
				setState(132);
				match(RPAR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolContext extends ParserRuleContext {
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
	 
		public BoolContext() { }
		public void copyFrom(BoolContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueContext extends BoolContext {
		public TerminalNode TRUE() { return getToken(SimpleLangParser.TRUE, 0); }
		public TrueContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTrue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseContext extends BoolContext {
		public TerminalNode FALSE() { return getToken(SimpleLangParser.FALSE, 0); }
		public FalseContext(BoolContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFalse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_bool);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				match(FALSE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return logical_sempred((LogicalContext)_localctx, predIndex);
		case 9:
			return compare_sempred((CompareContext)_localctx, predIndex);
		case 10:
			return plusOrMinus_sempred((PlusOrMinusContext)_localctx, predIndex);
		case 11:
			return mulOrDiv_sempred((MulOrDivContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logical_sempred(LogicalContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean compare_sempred(CompareContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 5);
		case 3:
			return precpred(_ctx, 4);
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean plusOrMinus_sempred(PlusOrMinusContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 3);
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean mulOrDiv_sempred(MulOrDivContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0017\u008d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0001\u0000\u0003\u0000\u001f"+
		"\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001%"+
		"\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002+"+
		"\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bK\b\b\n\b\f\bN\t\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t_\b\t\n\t\f\tb\t\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005"+
		"\nm\b\n\n\n\f\np\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b{\b"+
		"\u000b\n\u000b\f\u000b~\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u0087\b\f\u0001\r\u0001\r\u0003\r\u008b\b\r"+
		"\u0001\r\u0000\u0004\u0010\u0012\u0014\u0016\u000e\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0000\u0091\u0000"+
		"\u001e\u0001\u0000\u0000\u0000\u0002$\u0001\u0000\u0000\u0000\u0004*\u0001"+
		"\u0000\u0000\u0000\u0006,\u0001\u0000\u0000\u0000\b2\u0001\u0000\u0000"+
		"\u0000\n6\u0001\u0000\u0000\u0000\f:\u0001\u0000\u0000\u0000\u000e?\u0001"+
		"\u0000\u0000\u0000\u0010A\u0001\u0000\u0000\u0000\u0012O\u0001\u0000\u0000"+
		"\u0000\u0014c\u0001\u0000\u0000\u0000\u0016q\u0001\u0000\u0000\u0000\u0018"+
		"\u0086\u0001\u0000\u0000\u0000\u001a\u008a\u0001\u0000\u0000\u0000\u001c"+
		"\u001f\u0003\u0002\u0001\u0000\u001d\u001f\u0005\u0000\u0000\u0001\u001e"+
		"\u001c\u0001\u0000\u0000\u0000\u001e\u001d\u0001\u0000\u0000\u0000\u001f"+
		"\u0001\u0001\u0000\u0000\u0000 !\u0003\u0004\u0002\u0000!\"\u0003\u0002"+
		"\u0001\u0000\"%\u0001\u0000\u0000\u0000#%\u0003\u0004\u0002\u0000$ \u0001"+
		"\u0000\u0000\u0000$#\u0001\u0000\u0000\u0000%\u0003\u0001\u0000\u0000"+
		"\u0000&+\u0003\n\u0005\u0000\'+\u0003\f\u0006\u0000(+\u0003\u0006\u0003"+
		"\u0000)+\u0003\b\u0004\u0000*&\u0001\u0000\u0000\u0000*\'\u0001\u0000"+
		"\u0000\u0000*(\u0001\u0000\u0000\u0000*)\u0001\u0000\u0000\u0000+\u0005"+
		"\u0001\u0000\u0000\u0000,-\u0005\u0001\u0000\u0000-.\u0005\u0010\u0000"+
		"\u0000./\u0003\u000e\u0007\u0000/0\u0005\u0011\u0000\u000001\u0003\b\u0004"+
		"\u00001\u0007\u0001\u0000\u0000\u000023\u0005\u0012\u0000\u000034\u0003"+
		"\u0002\u0001\u000045\u0005\u0013\u0000\u00005\t\u0001\u0000\u0000\u0000"+
		"67\u0005\u0017\u0000\u000078\u0005\u0004\u0000\u000089\u0003\u000e\u0007"+
		"\u00009\u000b\u0001\u0000\u0000\u0000:;\u0005\u0017\u0000\u0000;<\u0005"+
		"\u0010\u0000\u0000<=\u0003\u000e\u0007\u0000=>\u0005\u0011\u0000\u0000"+
		">\r\u0001\u0000\u0000\u0000?@\u0003\u0010\b\u0000@\u000f\u0001\u0000\u0000"+
		"\u0000AB\u0006\b\uffff\uffff\u0000BC\u0003\u0012\t\u0000CL\u0001\u0000"+
		"\u0000\u0000DE\n\u0003\u0000\u0000EF\u0005\r\u0000\u0000FK\u0003\u0012"+
		"\t\u0000GH\n\u0002\u0000\u0000HI\u0005\u000e\u0000\u0000IK\u0003\u0012"+
		"\t\u0000JD\u0001\u0000\u0000\u0000JG\u0001\u0000\u0000\u0000KN\u0001\u0000"+
		"\u0000\u0000LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000M\u0011"+
		"\u0001\u0000\u0000\u0000NL\u0001\u0000\u0000\u0000OP\u0006\t\uffff\uffff"+
		"\u0000PQ\u0003\u0014\n\u0000Q`\u0001\u0000\u0000\u0000RS\n\u0005\u0000"+
		"\u0000ST\u0005\t\u0000\u0000T_\u0003\u0014\n\u0000UV\n\u0004\u0000\u0000"+
		"VW\u0005\n\u0000\u0000W_\u0003\u0014\n\u0000XY\n\u0003\u0000\u0000YZ\u0005"+
		"\u000b\u0000\u0000Z_\u0003\u0014\n\u0000[\\\n\u0002\u0000\u0000\\]\u0005"+
		"\f\u0000\u0000]_\u0003\u0014\n\u0000^R\u0001\u0000\u0000\u0000^U\u0001"+
		"\u0000\u0000\u0000^X\u0001\u0000\u0000\u0000^[\u0001\u0000\u0000\u0000"+
		"_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000"+
		"\u0000a\u0013\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000cd\u0006"+
		"\n\uffff\uffff\u0000de\u0003\u0016\u000b\u0000en\u0001\u0000\u0000\u0000"+
		"fg\n\u0003\u0000\u0000gh\u0005\u0005\u0000\u0000hm\u0003\u0016\u000b\u0000"+
		"ij\n\u0002\u0000\u0000jk\u0005\u0006\u0000\u0000km\u0003\u0016\u000b\u0000"+
		"lf\u0001\u0000\u0000\u0000li\u0001\u0000\u0000\u0000mp\u0001\u0000\u0000"+
		"\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000o\u0015\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qr\u0006\u000b\uffff\uffff"+
		"\u0000rs\u0003\u0018\f\u0000s|\u0001\u0000\u0000\u0000tu\n\u0003\u0000"+
		"\u0000uv\u0005\u0007\u0000\u0000v{\u0003\u0018\f\u0000wx\n\u0002\u0000"+
		"\u0000xy\u0005\b\u0000\u0000y{\u0003\u0018\f\u0000zt\u0001\u0000\u0000"+
		"\u0000zw\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000"+
		"\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0017\u0001\u0000\u0000\u0000"+
		"~|\u0001\u0000\u0000\u0000\u007f\u0087\u0003\u001a\r\u0000\u0080\u0087"+
		"\u0005\u0016\u0000\u0000\u0081\u0087\u0005\u0017\u0000\u0000\u0082\u0083"+
		"\u0005\u0010\u0000\u0000\u0083\u0084\u0003\u0012\t\u0000\u0084\u0085\u0005"+
		"\u0011\u0000\u0000\u0085\u0087\u0001\u0000\u0000\u0000\u0086\u007f\u0001"+
		"\u0000\u0000\u0000\u0086\u0080\u0001\u0000\u0000\u0000\u0086\u0081\u0001"+
		"\u0000\u0000\u0000\u0086\u0082\u0001\u0000\u0000\u0000\u0087\u0019\u0001"+
		"\u0000\u0000\u0000\u0088\u008b\u0005\u0002\u0000\u0000\u0089\u008b\u0005"+
		"\u0003\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u0089\u0001"+
		"\u0000\u0000\u0000\u008b\u001b\u0001\u0000\u0000\u0000\r\u001e$*JL^`l"+
		"nz|\u0086\u008a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}