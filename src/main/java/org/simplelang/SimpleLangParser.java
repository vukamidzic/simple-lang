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
		WHILE=1, TRUE=2, FALSE=3, EQ=4, DSEMIC=5, PLUS=6, MINUS=7, MUL=8, DIV=9, 
		LESS=10, GREAT=11, CMP_EQ=12, CMP_NEQ=13, AND=14, OR=15, NOT=16, LPAR=17, 
		RPAR=18, LCURL=19, RCURL=20, QMARK=21, COMMA=22, WS=23, NL=24, INT=25, 
		FLOAT=26, ID=27;
	public static final int
		RULE_program = 0, RULE_statements = 1, RULE_statement = 2, RULE_ifElseStmt = 3, 
		RULE_whileStmt = 4, RULE_block_of_stmts = 5, RULE_assignment = 6, RULE_statFuncCall = 7, 
		RULE_expr = 8, RULE_logical = 9, RULE_compare = 10, RULE_plusOrMinus = 11, 
		RULE_mulOrDiv = 12, RULE_atom = 13, RULE_exprFuncCall = 14, RULE_bool = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statements", "statement", "ifElseStmt", "whileStmt", "block_of_stmts", 
			"assignment", "statFuncCall", "expr", "logical", "compare", "plusOrMinus", 
			"mulOrDiv", "atom", "exprFuncCall", "bool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'while'", "'true'", "'false'", "':='", "'::'", "'+'", "'-'", "'*'", 
			"'/'", "'<'", "'>'", "'='", "'/='", "'and'", "'or'", "'not'", "'('", 
			"')'", "'{'", "'}'", "'?'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "WHILE", "TRUE", "FALSE", "EQ", "DSEMIC", "PLUS", "MINUS", "MUL", 
			"DIV", "LESS", "GREAT", "CMP_EQ", "CMP_NEQ", "AND", "OR", "NOT", "LPAR", 
			"RPAR", "LCURL", "RCURL", "QMARK", "COMMA", "WS", "NL", "INT", "FLOAT", 
			"ID"
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
			setState(34);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
			case LPAR:
			case LCURL:
			case ID:
				_localctx = new ToStatementsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				statements();
				}
				break;
			case EOF:
				_localctx = new EndOfProgramContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
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
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new MultipleStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(36);
				statement();
				setState(37);
				statements();
				}
				break;
			case 2:
				_localctx = new SingleStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
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
		public StatFuncCallContext statFuncCall() {
			return getRuleContext(StatFuncCallContext.class,0);
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
	public static class ToIfElseContext extends StatementContext {
		public IfElseStmtContext ifElseStmt() {
			return getRuleContext(IfElseStmtContext.class,0);
		}
		public ToIfElseContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToIfElse(this);
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
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ToAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				assignment();
				}
				break;
			case 2:
				_localctx = new ToFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				statFuncCall();
				}
				break;
			case 3:
				_localctx = new ToWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				whileStmt();
				}
				break;
			case 4:
				_localctx = new ToIfElseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				ifElseStmt();
				}
				break;
			case 5:
				_localctx = new ToBlockContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
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
	public static class IfElseStmtContext extends ParserRuleContext {
		public IfElseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifElseStmt; }
	 
		public IfElseStmtContext() { }
		public void copyFrom(IfElseStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NonEmptyIfContext extends IfElseStmtContext {
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public TerminalNode QMARK() { return getToken(SimpleLangParser.QMARK, 0); }
		public Block_of_stmtsContext block_of_stmts() {
			return getRuleContext(Block_of_stmtsContext.class,0);
		}
		public NonEmptyIfContext(IfElseStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitNonEmptyIf(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EmptyIfContext extends IfElseStmtContext {
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public TerminalNode QMARK() { return getToken(SimpleLangParser.QMARK, 0); }
		public Block_of_stmtsContext block_of_stmts() {
			return getRuleContext(Block_of_stmtsContext.class,0);
		}
		public EmptyIfContext(IfElseStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitEmptyIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfElseStmtContext ifElseStmt() throws RecognitionException {
		IfElseStmtContext _localctx = new IfElseStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ifElseStmt);
		try {
			setState(59);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new NonEmptyIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(LPAR);
				setState(50);
				expr();
				setState(51);
				match(RPAR);
				setState(52);
				match(QMARK);
				setState(53);
				block_of_stmts();
				}
				break;
			case 2:
				_localctx = new EmptyIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(LPAR);
				setState(56);
				match(RPAR);
				setState(57);
				match(QMARK);
				setState(58);
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
		enterRule(_localctx, 8, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			match(WHILE);
			setState(62);
			match(LPAR);
			setState(63);
			expr();
			setState(64);
			match(RPAR);
			setState(65);
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
		enterRule(_localctx, 10, RULE_block_of_stmts);
		try {
			_localctx = new BlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(LCURL);
			setState(68);
			statements();
			setState(69);
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
	public static class AssignVarContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode EQ() { return getToken(SimpleLangParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignVarContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssignVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignConstContext extends AssignmentContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode DSEMIC() { return getToken(SimpleLangParser.DSEMIC, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignConstContext(AssignmentContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssignConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_assignment);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new AssignVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				match(ID);
				setState(72);
				match(EQ);
				setState(73);
				expr();
				}
				break;
			case 2:
				_localctx = new AssignConstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(ID);
				setState(75);
				match(DSEMIC);
				setState(76);
				expr();
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
	public static class StatFuncCallContext extends ParserRuleContext {
		public StatFuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statFuncCall; }
	 
		public StatFuncCallContext() { }
		public void copyFrom(StatFuncCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SFuncCallContext extends StatFuncCallContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public SFuncCallContext(StatFuncCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatFuncCallContext statFuncCall() throws RecognitionException {
		StatFuncCallContext _localctx = new StatFuncCallContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statFuncCall);
		int _la;
		try {
			_localctx = new SFuncCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(ID);
			setState(80);
			match(LPAR);
			setState(81);
			expr();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(82);
				match(COMMA);
				setState(83);
				expr();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
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
		enterRule(_localctx, 16, RULE_expr);
		try {
			_localctx = new ExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
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
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_logical, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToCompareContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(94);
			compare(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(102);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new LogicalContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical);
						setState(96);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(97);
						match(AND);
						setState(98);
						compare(0);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new LogicalContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical);
						setState(99);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(100);
						match(OR);
						setState(101);
						compare(0);
						}
						break;
					}
					} 
				}
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_compare, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToPlusOrMinusContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(108);
			plusOrMinus(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(122);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new LessContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(110);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(111);
						match(LESS);
						setState(112);
						plusOrMinus(0);
						}
						break;
					case 2:
						{
						_localctx = new GreatContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(113);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(114);
						match(GREAT);
						setState(115);
						plusOrMinus(0);
						}
						break;
					case 3:
						{
						_localctx = new EqContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(116);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(117);
						match(CMP_EQ);
						setState(118);
						plusOrMinus(0);
						}
						break;
					case 4:
						{
						_localctx = new NeqContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(119);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(120);
						match(CMP_NEQ);
						setState(121);
						plusOrMinus(0);
						}
						break;
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_plusOrMinus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToMulOrDivContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(128);
			mulOrDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(136);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new PlusOrMinusContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(130);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(131);
						match(PLUS);
						setState(132);
						mulOrDiv(0);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new PlusOrMinusContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(133);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(134);
						match(MINUS);
						setState(135);
						mulOrDiv(0);
						}
						break;
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_mulOrDiv, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToAtomContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(142);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(152);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(150);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new MulContext(new MulOrDivContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mulOrDiv);
						setState(144);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(145);
						match(MUL);
						setState(146);
						atom();
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new MulOrDivContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mulOrDiv);
						setState(147);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(148);
						match(DIV);
						setState(149);
						atom();
						}
						break;
					}
					} 
				}
				setState(154);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
	public static class FloatContext extends AtomContext {
		public TerminalNode FLOAT() { return getToken(SimpleLangParser.FLOAT, 0); }
		public FloatContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFloat(this);
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
		public LogicalContext logical() {
			return getRuleContext(LogicalContext.class,0);
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
	@SuppressWarnings("CheckReturnValue")
	public static class ToExprFuncCallContext extends AtomContext {
		public ExprFuncCallContext exprFuncCall() {
			return getRuleContext(ExprFuncCallContext.class,0);
		}
		public ToExprFuncCallContext(AtomContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToExprFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_atom);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new ToBoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				bool();
				}
				break;
			case 2:
				_localctx = new ToExprFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				exprFuncCall();
				}
				break;
			case 3:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(157);
				match(INT);
				}
				break;
			case 4:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(158);
				match(FLOAT);
				}
				break;
			case 5:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(159);
				match(ID);
				}
				break;
			case 6:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(160);
				match(LPAR);
				setState(161);
				logical(0);
				setState(162);
				match(RPAR);
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
	public static class ExprFuncCallContext extends ParserRuleContext {
		public ExprFuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprFuncCall; }
	 
		public ExprFuncCallContext() { }
		public void copyFrom(ExprFuncCallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EFuncCallContext extends ExprFuncCallContext {
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public EFuncCallContext(ExprFuncCallContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitEFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprFuncCallContext exprFuncCall() throws RecognitionException {
		ExprFuncCallContext _localctx = new ExprFuncCallContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_exprFuncCall);
		int _la;
		try {
			_localctx = new EFuncCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(ID);
			setState(167);
			match(LPAR);
			setState(168);
			expr();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(169);
				match(COMMA);
				setState(170);
				expr();
				}
				}
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(176);
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
		enterRule(_localctx, 30, RULE_bool);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
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
		case 9:
			return logical_sempred((LogicalContext)_localctx, predIndex);
		case 10:
			return compare_sempred((CompareContext)_localctx, predIndex);
		case 11:
			return plusOrMinus_sempred((PlusOrMinusContext)_localctx, predIndex);
		case 12:
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
		"\u0004\u0001\u001b\u00b7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0001\u0000\u0001\u0000\u0003\u0000#\b\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0003\u0001)\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00020\b\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003<\b\u0003\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006N\b\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007U\b"+
		"\u0007\n\u0007\f\u0007X\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\tg\b\t\n\t\f\tj\t\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\n{\b\n\n\n\f\n~\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0089\b\u000b\n\u000b\f\u000b\u008c\t\u000b\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u0097\b\f\n"+
		"\f\f\f\u009a\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u00a5\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u00ac\b\u000e\n\u000e\f\u000e\u00af"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0003\u000f\u00b5"+
		"\b\u000f\u0001\u000f\u0000\u0004\u0012\u0014\u0016\u0018\u0010\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		"\u0000\u0000\u00c0\u0000\"\u0001\u0000\u0000\u0000\u0002(\u0001\u0000"+
		"\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u0006;\u0001\u0000\u0000\u0000"+
		"\b=\u0001\u0000\u0000\u0000\nC\u0001\u0000\u0000\u0000\fM\u0001\u0000"+
		"\u0000\u0000\u000eO\u0001\u0000\u0000\u0000\u0010[\u0001\u0000\u0000\u0000"+
		"\u0012]\u0001\u0000\u0000\u0000\u0014k\u0001\u0000\u0000\u0000\u0016\u007f"+
		"\u0001\u0000\u0000\u0000\u0018\u008d\u0001\u0000\u0000\u0000\u001a\u00a4"+
		"\u0001\u0000\u0000\u0000\u001c\u00a6\u0001\u0000\u0000\u0000\u001e\u00b4"+
		"\u0001\u0000\u0000\u0000 #\u0003\u0002\u0001\u0000!#\u0005\u0000\u0000"+
		"\u0001\" \u0001\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#\u0001\u0001"+
		"\u0000\u0000\u0000$%\u0003\u0004\u0002\u0000%&\u0003\u0002\u0001\u0000"+
		"&)\u0001\u0000\u0000\u0000\')\u0003\u0004\u0002\u0000($\u0001\u0000\u0000"+
		"\u0000(\'\u0001\u0000\u0000\u0000)\u0003\u0001\u0000\u0000\u0000*0\u0003"+
		"\f\u0006\u0000+0\u0003\u000e\u0007\u0000,0\u0003\b\u0004\u0000-0\u0003"+
		"\u0006\u0003\u0000.0\u0003\n\u0005\u0000/*\u0001\u0000\u0000\u0000/+\u0001"+
		"\u0000\u0000\u0000/,\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u0000"+
		"/.\u0001\u0000\u0000\u00000\u0005\u0001\u0000\u0000\u000012\u0005\u0011"+
		"\u0000\u000023\u0003\u0010\b\u000034\u0005\u0012\u0000\u000045\u0005\u0015"+
		"\u0000\u000056\u0003\n\u0005\u00006<\u0001\u0000\u0000\u000078\u0005\u0011"+
		"\u0000\u000089\u0005\u0012\u0000\u00009:\u0005\u0015\u0000\u0000:<\u0003"+
		"\n\u0005\u0000;1\u0001\u0000\u0000\u0000;7\u0001\u0000\u0000\u0000<\u0007"+
		"\u0001\u0000\u0000\u0000=>\u0005\u0001\u0000\u0000>?\u0005\u0011\u0000"+
		"\u0000?@\u0003\u0010\b\u0000@A\u0005\u0012\u0000\u0000AB\u0003\n\u0005"+
		"\u0000B\t\u0001\u0000\u0000\u0000CD\u0005\u0013\u0000\u0000DE\u0003\u0002"+
		"\u0001\u0000EF\u0005\u0014\u0000\u0000F\u000b\u0001\u0000\u0000\u0000"+
		"GH\u0005\u001b\u0000\u0000HI\u0005\u0004\u0000\u0000IN\u0003\u0010\b\u0000"+
		"JK\u0005\u001b\u0000\u0000KL\u0005\u0005\u0000\u0000LN\u0003\u0010\b\u0000"+
		"MG\u0001\u0000\u0000\u0000MJ\u0001\u0000\u0000\u0000N\r\u0001\u0000\u0000"+
		"\u0000OP\u0005\u001b\u0000\u0000PQ\u0005\u0011\u0000\u0000QV\u0003\u0010"+
		"\b\u0000RS\u0005\u0016\u0000\u0000SU\u0003\u0010\b\u0000TR\u0001\u0000"+
		"\u0000\u0000UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000WY\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"YZ\u0005\u0012\u0000\u0000Z\u000f\u0001\u0000\u0000\u0000[\\\u0003\u0012"+
		"\t\u0000\\\u0011\u0001\u0000\u0000\u0000]^\u0006\t\uffff\uffff\u0000^"+
		"_\u0003\u0014\n\u0000_h\u0001\u0000\u0000\u0000`a\n\u0003\u0000\u0000"+
		"ab\u0005\u000e\u0000\u0000bg\u0003\u0014\n\u0000cd\n\u0002\u0000\u0000"+
		"de\u0005\u000f\u0000\u0000eg\u0003\u0014\n\u0000f`\u0001\u0000\u0000\u0000"+
		"fc\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000hi\u0001\u0000\u0000\u0000i\u0013\u0001\u0000\u0000\u0000jh\u0001"+
		"\u0000\u0000\u0000kl\u0006\n\uffff\uffff\u0000lm\u0003\u0016\u000b\u0000"+
		"m|\u0001\u0000\u0000\u0000no\n\u0005\u0000\u0000op\u0005\n\u0000\u0000"+
		"p{\u0003\u0016\u000b\u0000qr\n\u0004\u0000\u0000rs\u0005\u000b\u0000\u0000"+
		"s{\u0003\u0016\u000b\u0000tu\n\u0003\u0000\u0000uv\u0005\f\u0000\u0000"+
		"v{\u0003\u0016\u000b\u0000wx\n\u0002\u0000\u0000xy\u0005\r\u0000\u0000"+
		"y{\u0003\u0016\u000b\u0000zn\u0001\u0000\u0000\u0000zq\u0001\u0000\u0000"+
		"\u0000zt\u0001\u0000\u0000\u0000zw\u0001\u0000\u0000\u0000{~\u0001\u0000"+
		"\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0015"+
		"\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0006\u000b"+
		"\uffff\uffff\u0000\u0080\u0081\u0003\u0018\f\u0000\u0081\u008a\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\n\u0003\u0000\u0000\u0083\u0084\u0005\u0006\u0000"+
		"\u0000\u0084\u0089\u0003\u0018\f\u0000\u0085\u0086\n\u0002\u0000\u0000"+
		"\u0086\u0087\u0005\u0007\u0000\u0000\u0087\u0089\u0003\u0018\f\u0000\u0088"+
		"\u0082\u0001\u0000\u0000\u0000\u0088\u0085\u0001\u0000\u0000\u0000\u0089"+
		"\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a"+
		"\u008b\u0001\u0000\u0000\u0000\u008b\u0017\u0001\u0000\u0000\u0000\u008c"+
		"\u008a\u0001\u0000\u0000\u0000\u008d\u008e\u0006\f\uffff\uffff\u0000\u008e"+
		"\u008f\u0003\u001a\r\u0000\u008f\u0098\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\n\u0003\u0000\u0000\u0091\u0092\u0005\b\u0000\u0000\u0092\u0097\u0003"+
		"\u001a\r\u0000\u0093\u0094\n\u0002\u0000\u0000\u0094\u0095\u0005\t\u0000"+
		"\u0000\u0095\u0097\u0003\u001a\r\u0000\u0096\u0090\u0001\u0000\u0000\u0000"+
		"\u0096\u0093\u0001\u0000\u0000\u0000\u0097\u009a\u0001\u0000\u0000\u0000"+
		"\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000"+
		"\u0099\u0019\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009b\u00a5\u0003\u001e\u000f\u0000\u009c\u00a5\u0003\u001c\u000e\u0000"+
		"\u009d\u00a5\u0005\u0019\u0000\u0000\u009e\u00a5\u0005\u001a\u0000\u0000"+
		"\u009f\u00a5\u0005\u001b\u0000\u0000\u00a0\u00a1\u0005\u0011\u0000\u0000"+
		"\u00a1\u00a2\u0003\u0012\t\u0000\u00a2\u00a3\u0005\u0012\u0000\u0000\u00a3"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a4\u009b\u0001\u0000\u0000\u0000\u00a4"+
		"\u009c\u0001\u0000\u0000\u0000\u00a4\u009d\u0001\u0000\u0000\u0000\u00a4"+
		"\u009e\u0001\u0000\u0000\u0000\u00a4\u009f\u0001\u0000\u0000\u0000\u00a4"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a5\u001b\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a7\u0005\u001b\u0000\u0000\u00a7\u00a8\u0005\u0011\u0000\u0000\u00a8"+
		"\u00ad\u0003\u0010\b\u0000\u00a9\u00aa\u0005\u0016\u0000\u0000\u00aa\u00ac"+
		"\u0003\u0010\b\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000\u00ac\u00af\u0001"+
		"\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00ad\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b1\u0005\u0012\u0000\u0000\u00b1\u001d\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b5\u0005\u0002\u0000\u0000\u00b3\u00b5\u0005"+
		"\u0003\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b5\u001f\u0001\u0000\u0000\u0000\u0011\"(/;MVfh"+
		"z|\u0088\u008a\u0096\u0098\u00a4\u00ad\u00b4";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}