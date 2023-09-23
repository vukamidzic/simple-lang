package org.simplelang;

// Generated from src/main/java/org/simplelang/SimpleLang.g4 by ANTLR 4.13.1
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
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, WHILE=2, FOR=3, PTR=4, TRUE=5, FALSE=6, TYPE=7, EQ=8, DSEMIC=9, 
		PLUS=10, MINUS=11, MUL=12, DIV=13, LARROW=14, LESS=15, GREAT=16, CMP_EQ=17, 
		CMP_NEQ=18, AND=19, OR=20, NOT=21, LPAR=22, RPAR=23, LCURL=24, RCURL=25, 
		QMARK=26, COMMA=27, WS=28, NL=29, INT=30, FLOAT=31, ID=32;
	public static final int
		RULE_program = 0, RULE_statements = 1, RULE_statement = 2, RULE_ifElseStmt = 3, 
		RULE_forStmt = 4, RULE_whileStmt = 5, RULE_block_of_stmts = 6, RULE_functionDef = 7, 
		RULE_assignment = 8, RULE_statFuncCall = 9, RULE_expr = 10, RULE_logical = 11, 
		RULE_compare = 12, RULE_plusOrMinus = 13, RULE_mulOrDiv = 14, RULE_ptrOp = 15, 
		RULE_atom = 16, RULE_exprFuncCall = 17, RULE_bool = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statements", "statement", "ifElseStmt", "forStmt", "whileStmt", 
			"block_of_stmts", "functionDef", "assignment", "statFuncCall", "expr", 
			"logical", "compare", "plusOrMinus", "mulOrDiv", "ptrOp", "atom", "exprFuncCall", 
			"bool"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'proc'", "'while'", "'for'", "'ptr'", "'true'", "'false'", null, 
			"':='", "'::'", "'+'", "'-'", "'*'", "'/'", "'<-'", "'<'", "'>'", "'='", 
			"'/='", "'and'", "'or'", "'not'", "'('", "')'", "'{'", "'}'", "'?'", 
			"','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "WHILE", "FOR", "PTR", "TRUE", "FALSE", "TYPE", "EQ", "DSEMIC", 
			"PLUS", "MINUS", "MUL", "DIV", "LARROW", "LESS", "GREAT", "CMP_EQ", "CMP_NEQ", 
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
			setState(40);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case WHILE:
			case FOR:
			case LPAR:
			case LCURL:
			case ID:
				_localctx = new ToStatementsContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				statements();
				}
				break;
			case EOF:
				_localctx = new EndOfProgramContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
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
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new MultipleStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				statement();
				setState(43);
				statements();
				}
				break;
			case 2:
				_localctx = new SingleStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
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
	public static class ToFuncDefContext extends StatementContext {
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public ToFuncDefContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToFuncDef(this);
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
	@SuppressWarnings("CheckReturnValue")
	public static class ToForContext extends StatementContext {
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public ToForContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new ToAssignmentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				assignment();
				}
				break;
			case 2:
				_localctx = new ToFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				statFuncCall();
				}
				break;
			case 3:
				_localctx = new ToWhileContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				whileStmt();
				}
				break;
			case 4:
				_localctx = new ToForContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				forStmt();
				}
				break;
			case 5:
				_localctx = new ToIfElseContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				ifElseStmt();
				}
				break;
			case 6:
				_localctx = new ToBlockContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
				block_of_stmts();
				}
				break;
			case 7:
				_localctx = new ToFuncDefContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				functionDef();
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
			setState(67);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new NonEmptyIfContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(57);
				match(LPAR);
				setState(58);
				expr();
				setState(59);
				match(RPAR);
				setState(60);
				match(QMARK);
				setState(61);
				block_of_stmts();
				}
				break;
			case 2:
				_localctx = new EmptyIfContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(63);
				match(LPAR);
				setState(64);
				match(RPAR);
				setState(65);
				match(QMARK);
				setState(66);
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
	public static class ForStmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(SimpleLangParser.FOR, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public TerminalNode ID() { return getToken(SimpleLangParser.ID, 0); }
		public TerminalNode LARROW() { return getToken(SimpleLangParser.LARROW, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(SimpleLangParser.COMMA, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public Block_of_stmtsContext block_of_stmts() {
			return getRuleContext(Block_of_stmtsContext.class,0);
		}
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitForStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_forStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			match(FOR);
			setState(70);
			match(LPAR);
			setState(71);
			match(ID);
			setState(72);
			match(LARROW);
			setState(73);
			expr();
			setState(74);
			match(COMMA);
			setState(75);
			expr();
			setState(76);
			match(RPAR);
			setState(77);
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
		enterRule(_localctx, 10, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(WHILE);
			setState(80);
			match(LPAR);
			setState(81);
			expr();
			setState(82);
			match(RPAR);
			setState(83);
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
		enterRule(_localctx, 12, RULE_block_of_stmts);
		try {
			_localctx = new BlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(LCURL);
			setState(86);
			statements();
			setState(87);
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
	public static class FunctionDefContext extends ParserRuleContext {
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
	 
		public FunctionDefContext() { }
		public void copyFrom(FunctionDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncDefContext extends FunctionDefContext {
		public List<TerminalNode> ID() { return getTokens(SimpleLangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SimpleLangParser.ID, i);
		}
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public Block_of_stmtsContext block_of_stmts() {
			return getRuleContext(Block_of_stmtsContext.class,0);
		}
		public List<TerminalNode> TYPE() { return getTokens(SimpleLangParser.TYPE); }
		public TerminalNode TYPE(int i) {
			return getToken(SimpleLangParser.TYPE, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(SimpleLangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(SimpleLangParser.COMMA, i);
		}
		public FuncDefContext(FunctionDefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionDef);
		int _la;
		try {
			_localctx = new FuncDefContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__0);
			setState(90);
			match(ID);
			setState(91);
			match(LPAR);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(92);
				match(ID);
				setState(93);
				match(TYPE);
				}
			}

			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(96);
				match(COMMA);
				setState(97);
				match(ID);
				setState(98);
				match(TYPE);
				}
				}
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(104);
			match(RPAR);
			setState(105);
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
		enterRule(_localctx, 16, RULE_assignment);
		try {
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new AssignVarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(ID);
				setState(108);
				match(EQ);
				setState(109);
				expr();
				}
				break;
			case 2:
				_localctx = new AssignConstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(ID);
				setState(111);
				match(DSEMIC);
				setState(112);
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
		enterRule(_localctx, 18, RULE_statFuncCall);
		int _la;
		try {
			_localctx = new SFuncCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(ID);
			setState(116);
			match(LPAR);
			setState(117);
			expr();
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(118);
				match(COMMA);
				setState(119);
				expr();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
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
		enterRule(_localctx, 20, RULE_expr);
		try {
			_localctx = new ExpressionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_logical, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToCompareContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(130);
			compare(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(140);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(138);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new AndContext(new LogicalContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical);
						setState(132);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(133);
						match(AND);
						setState(134);
						compare(0);
						}
						break;
					case 2:
						{
						_localctx = new OrContext(new LogicalContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logical);
						setState(135);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(136);
						match(OR);
						setState(137);
						compare(0);
						}
						break;
					}
					} 
				}
				setState(142);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_compare, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToPlusOrMinusContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(144);
			plusOrMinus(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(158);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
					case 1:
						{
						_localctx = new LessContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(146);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(147);
						match(LESS);
						setState(148);
						plusOrMinus(0);
						}
						break;
					case 2:
						{
						_localctx = new GreatContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(149);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(150);
						match(GREAT);
						setState(151);
						plusOrMinus(0);
						}
						break;
					case 3:
						{
						_localctx = new EqContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(152);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(153);
						match(CMP_EQ);
						setState(154);
						plusOrMinus(0);
						}
						break;
					case 4:
						{
						_localctx = new NeqContext(new CompareContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_compare);
						setState(155);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(156);
						match(CMP_NEQ);
						setState(157);
						plusOrMinus(0);
						}
						break;
					}
					} 
				}
				setState(162);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_plusOrMinus, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToMulOrDivContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(164);
			mulOrDiv(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(172);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new PlusContext(new PlusOrMinusContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(166);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(167);
						match(PLUS);
						setState(168);
						mulOrDiv(0);
						}
						break;
					case 2:
						{
						_localctx = new MinusContext(new PlusOrMinusContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_plusOrMinus);
						setState(169);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(170);
						match(MINUS);
						setState(171);
						mulOrDiv(0);
						}
						break;
					}
					} 
				}
				setState(176);
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
	public static class ToPtrContext extends MulOrDivContext {
		public PtrOpContext ptrOp() {
			return getRuleContext(PtrOpContext.class,0);
		}
		public ToPtrContext(MulOrDivContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToPtr(this);
			else return visitor.visitChildren(this);
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

	public final MulOrDivContext mulOrDiv() throws RecognitionException {
		return mulOrDiv(0);
	}

	private MulOrDivContext mulOrDiv(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MulOrDivContext _localctx = new MulOrDivContext(_ctx, _parentState);
		MulOrDivContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_mulOrDiv, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ToPtrContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(178);
			ptrOp();
			}
			_ctx.stop = _input.LT(-1);
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(186);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new MulContext(new MulOrDivContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mulOrDiv);
						setState(180);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(181);
						match(MUL);
						setState(182);
						atom();
						}
						break;
					case 2:
						{
						_localctx = new DivContext(new MulOrDivContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_mulOrDiv);
						setState(183);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(184);
						match(DIV);
						setState(185);
						atom();
						}
						break;
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class PtrOpContext extends ParserRuleContext {
		public PtrOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ptrOp; }
	 
		public PtrOpContext() { }
		public void copyFrom(PtrOpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FromPointerContext extends PtrOpContext {
		public TerminalNode MUL() { return getToken(SimpleLangParser.MUL, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public FromPointerContext(PtrOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFromPointer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToPointerContext extends PtrOpContext {
		public TerminalNode PTR() { return getToken(SimpleLangParser.PTR, 0); }
		public TerminalNode LPAR() { return getToken(SimpleLangParser.LPAR, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(SimpleLangParser.RPAR, 0); }
		public ToPointerContext(PtrOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToPointer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ToAtomContext extends PtrOpContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ToAtomContext(PtrOpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitToAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PtrOpContext ptrOp() throws RecognitionException {
		PtrOpContext _localctx = new PtrOpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ptrOp);
		try {
			setState(199);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PTR:
				_localctx = new ToPointerContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				match(PTR);
				setState(192);
				match(LPAR);
				setState(193);
				atom();
				setState(194);
				match(RPAR);
				}
				break;
			case MUL:
				_localctx = new FromPointerContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(MUL);
				setState(197);
				atom();
				}
				break;
			case TRUE:
			case FALSE:
			case LPAR:
			case INT:
			case FLOAT:
			case ID:
				_localctx = new ToAtomContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(198);
				atom();
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
		enterRule(_localctx, 32, RULE_atom);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new ToBoolContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				bool();
				}
				break;
			case 2:
				_localctx = new ToExprFuncCallContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				exprFuncCall();
				}
				break;
			case 3:
				_localctx = new IntegerContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(203);
				match(INT);
				}
				break;
			case 4:
				_localctx = new FloatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(204);
				match(FLOAT);
				}
				break;
			case 5:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(205);
				match(ID);
				}
				break;
			case 6:
				_localctx = new ParensContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(206);
				match(LPAR);
				setState(207);
				logical(0);
				setState(208);
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
		enterRule(_localctx, 34, RULE_exprFuncCall);
		int _la;
		try {
			_localctx = new EFuncCallContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(ID);
			setState(213);
			match(LPAR);
			setState(214);
			expr();
			setState(219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(215);
				match(COMMA);
				setState(216);
				expr();
				}
				}
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(222);
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
		enterRule(_localctx, 36, RULE_bool);
		try {
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TRUE:
				_localctx = new TrueContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(224);
				match(TRUE);
				}
				break;
			case FALSE:
				_localctx = new FalseContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(225);
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
		case 11:
			return logical_sempred((LogicalContext)_localctx, predIndex);
		case 12:
			return compare_sempred((CompareContext)_localctx, predIndex);
		case 13:
			return plusOrMinus_sempred((PlusOrMinusContext)_localctx, predIndex);
		case 14:
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
		"\u0004\u0001 \u00e5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0003\u0000)\b\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001/\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"8\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"D\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007_\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0005\u0007d\b\u0007\n\u0007\f\u0007g\t\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\br\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\ty\b\t\n"+
		"\t\f\t|\t\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0005\u000b\u008b\b\u000b\n\u000b\f\u000b\u008e\t\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u009f\b\f\n\f\f\f\u00a2"+
		"\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u00ad\b\r\n\r\f\r\u00b0\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u00bb\b\u000e\n\u000e\f\u000e\u00be\t\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00c8\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u00d3\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u00da\b\u0011\n\u0011\f\u0011\u00dd\t\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u00e3\b\u0012\u0001\u0012"+
		"\u0000\u0004\u0016\u0018\u001a\u001c\u0013\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0000"+
		"\u00f1\u0000(\u0001\u0000\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u0004"+
		"7\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\bE\u0001\u0000"+
		"\u0000\u0000\nO\u0001\u0000\u0000\u0000\fU\u0001\u0000\u0000\u0000\u000e"+
		"Y\u0001\u0000\u0000\u0000\u0010q\u0001\u0000\u0000\u0000\u0012s\u0001"+
		"\u0000\u0000\u0000\u0014\u007f\u0001\u0000\u0000\u0000\u0016\u0081\u0001"+
		"\u0000\u0000\u0000\u0018\u008f\u0001\u0000\u0000\u0000\u001a\u00a3\u0001"+
		"\u0000\u0000\u0000\u001c\u00b1\u0001\u0000\u0000\u0000\u001e\u00c7\u0001"+
		"\u0000\u0000\u0000 \u00d2\u0001\u0000\u0000\u0000\"\u00d4\u0001\u0000"+
		"\u0000\u0000$\u00e2\u0001\u0000\u0000\u0000&)\u0003\u0002\u0001\u0000"+
		"\')\u0005\u0000\u0000\u0001(&\u0001\u0000\u0000\u0000(\'\u0001\u0000\u0000"+
		"\u0000)\u0001\u0001\u0000\u0000\u0000*+\u0003\u0004\u0002\u0000+,\u0003"+
		"\u0002\u0001\u0000,/\u0001\u0000\u0000\u0000-/\u0003\u0004\u0002\u0000"+
		".*\u0001\u0000\u0000\u0000.-\u0001\u0000\u0000\u0000/\u0003\u0001\u0000"+
		"\u0000\u000008\u0003\u0010\b\u000018\u0003\u0012\t\u000028\u0003\n\u0005"+
		"\u000038\u0003\b\u0004\u000048\u0003\u0006\u0003\u000058\u0003\f\u0006"+
		"\u000068\u0003\u000e\u0007\u000070\u0001\u0000\u0000\u000071\u0001\u0000"+
		"\u0000\u000072\u0001\u0000\u0000\u000073\u0001\u0000\u0000\u000074\u0001"+
		"\u0000\u0000\u000075\u0001\u0000\u0000\u000076\u0001\u0000\u0000\u0000"+
		"8\u0005\u0001\u0000\u0000\u00009:\u0005\u0016\u0000\u0000:;\u0003\u0014"+
		"\n\u0000;<\u0005\u0017\u0000\u0000<=\u0005\u001a\u0000\u0000=>\u0003\f"+
		"\u0006\u0000>D\u0001\u0000\u0000\u0000?@\u0005\u0016\u0000\u0000@A\u0005"+
		"\u0017\u0000\u0000AB\u0005\u001a\u0000\u0000BD\u0003\f\u0006\u0000C9\u0001"+
		"\u0000\u0000\u0000C?\u0001\u0000\u0000\u0000D\u0007\u0001\u0000\u0000"+
		"\u0000EF\u0005\u0003\u0000\u0000FG\u0005\u0016\u0000\u0000GH\u0005 \u0000"+
		"\u0000HI\u0005\u000e\u0000\u0000IJ\u0003\u0014\n\u0000JK\u0005\u001b\u0000"+
		"\u0000KL\u0003\u0014\n\u0000LM\u0005\u0017\u0000\u0000MN\u0003\f\u0006"+
		"\u0000N\t\u0001\u0000\u0000\u0000OP\u0005\u0002\u0000\u0000PQ\u0005\u0016"+
		"\u0000\u0000QR\u0003\u0014\n\u0000RS\u0005\u0017\u0000\u0000ST\u0003\f"+
		"\u0006\u0000T\u000b\u0001\u0000\u0000\u0000UV\u0005\u0018\u0000\u0000"+
		"VW\u0003\u0002\u0001\u0000WX\u0005\u0019\u0000\u0000X\r\u0001\u0000\u0000"+
		"\u0000YZ\u0005\u0001\u0000\u0000Z[\u0005 \u0000\u0000[^\u0005\u0016\u0000"+
		"\u0000\\]\u0005 \u0000\u0000]_\u0005\u0007\u0000\u0000^\\\u0001\u0000"+
		"\u0000\u0000^_\u0001\u0000\u0000\u0000_e\u0001\u0000\u0000\u0000`a\u0005"+
		"\u001b\u0000\u0000ab\u0005 \u0000\u0000bd\u0005\u0007\u0000\u0000c`\u0001"+
		"\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"ef\u0001\u0000\u0000\u0000fh\u0001\u0000\u0000\u0000ge\u0001\u0000\u0000"+
		"\u0000hi\u0005\u0017\u0000\u0000ij\u0003\f\u0006\u0000j\u000f\u0001\u0000"+
		"\u0000\u0000kl\u0005 \u0000\u0000lm\u0005\b\u0000\u0000mr\u0003\u0014"+
		"\n\u0000no\u0005 \u0000\u0000op\u0005\t\u0000\u0000pr\u0003\u0014\n\u0000"+
		"qk\u0001\u0000\u0000\u0000qn\u0001\u0000\u0000\u0000r\u0011\u0001\u0000"+
		"\u0000\u0000st\u0005 \u0000\u0000tu\u0005\u0016\u0000\u0000uz\u0003\u0014"+
		"\n\u0000vw\u0005\u001b\u0000\u0000wy\u0003\u0014\n\u0000xv\u0001\u0000"+
		"\u0000\u0000y|\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{}\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000"+
		"}~\u0005\u0017\u0000\u0000~\u0013\u0001\u0000\u0000\u0000\u007f\u0080"+
		"\u0003\u0016\u000b\u0000\u0080\u0015\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0006\u000b\uffff\uffff\u0000\u0082\u0083\u0003\u0018\f\u0000\u0083\u008c"+
		"\u0001\u0000\u0000\u0000\u0084\u0085\n\u0003\u0000\u0000\u0085\u0086\u0005"+
		"\u0013\u0000\u0000\u0086\u008b\u0003\u0018\f\u0000\u0087\u0088\n\u0002"+
		"\u0000\u0000\u0088\u0089\u0005\u0014\u0000\u0000\u0089\u008b\u0003\u0018"+
		"\f\u0000\u008a\u0084\u0001\u0000\u0000\u0000\u008a\u0087\u0001\u0000\u0000"+
		"\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u0017\u0001\u0000\u0000"+
		"\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0090\u0006\f\uffff\uffff"+
		"\u0000\u0090\u0091\u0003\u001a\r\u0000\u0091\u00a0\u0001\u0000\u0000\u0000"+
		"\u0092\u0093\n\u0005\u0000\u0000\u0093\u0094\u0005\u000f\u0000\u0000\u0094"+
		"\u009f\u0003\u001a\r\u0000\u0095\u0096\n\u0004\u0000\u0000\u0096\u0097"+
		"\u0005\u0010\u0000\u0000\u0097\u009f\u0003\u001a\r\u0000\u0098\u0099\n"+
		"\u0003\u0000\u0000\u0099\u009a\u0005\u0011\u0000\u0000\u009a\u009f\u0003"+
		"\u001a\r\u0000\u009b\u009c\n\u0002\u0000\u0000\u009c\u009d\u0005\u0012"+
		"\u0000\u0000\u009d\u009f\u0003\u001a\r\u0000\u009e\u0092\u0001\u0000\u0000"+
		"\u0000\u009e\u0095\u0001\u0000\u0000\u0000\u009e\u0098\u0001\u0000\u0000"+
		"\u0000\u009e\u009b\u0001\u0000\u0000\u0000\u009f\u00a2\u0001\u0000\u0000"+
		"\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a1\u0019\u0001\u0000\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0006\r\uffff\uffff\u0000\u00a4\u00a5\u0003\u001c\u000e"+
		"\u0000\u00a5\u00ae\u0001\u0000\u0000\u0000\u00a6\u00a7\n\u0003\u0000\u0000"+
		"\u00a7\u00a8\u0005\n\u0000\u0000\u00a8\u00ad\u0003\u001c\u000e\u0000\u00a9"+
		"\u00aa\n\u0002\u0000\u0000\u00aa\u00ab\u0005\u000b\u0000\u0000\u00ab\u00ad"+
		"\u0003\u001c\u000e\u0000\u00ac\u00a6\u0001\u0000\u0000\u0000\u00ac\u00a9"+
		"\u0001\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u001b"+
		"\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b2"+
		"\u0006\u000e\uffff\uffff\u0000\u00b2\u00b3\u0003\u001e\u000f\u0000\u00b3"+
		"\u00bc\u0001\u0000\u0000\u0000\u00b4\u00b5\n\u0003\u0000\u0000\u00b5\u00b6"+
		"\u0005\f\u0000\u0000\u00b6\u00bb\u0003 \u0010\u0000\u00b7\u00b8\n\u0002"+
		"\u0000\u0000\u00b8\u00b9\u0005\r\u0000\u0000\u00b9\u00bb\u0003 \u0010"+
		"\u0000\u00ba\u00b4\u0001\u0000\u0000\u0000\u00ba\u00b7\u0001\u0000\u0000"+
		"\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001\u0000\u0000"+
		"\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u001d\u0001\u0000\u0000"+
		"\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c0\u0005\u0004\u0000"+
		"\u0000\u00c0\u00c1\u0005\u0016\u0000\u0000\u00c1\u00c2\u0003 \u0010\u0000"+
		"\u00c2\u00c3\u0005\u0017\u0000\u0000\u00c3\u00c8\u0001\u0000\u0000\u0000"+
		"\u00c4\u00c5\u0005\f\u0000\u0000\u00c5\u00c8\u0003 \u0010\u0000\u00c6"+
		"\u00c8\u0003 \u0010\u0000\u00c7\u00bf\u0001\u0000\u0000\u0000\u00c7\u00c4"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c6\u0001\u0000\u0000\u0000\u00c8\u001f"+
		"\u0001\u0000\u0000\u0000\u00c9\u00d3\u0003$\u0012\u0000\u00ca\u00d3\u0003"+
		"\"\u0011\u0000\u00cb\u00d3\u0005\u001e\u0000\u0000\u00cc\u00d3\u0005\u001f"+
		"\u0000\u0000\u00cd\u00d3\u0005 \u0000\u0000\u00ce\u00cf\u0005\u0016\u0000"+
		"\u0000\u00cf\u00d0\u0003\u0016\u000b\u0000\u00d0\u00d1\u0005\u0017\u0000"+
		"\u0000\u00d1\u00d3\u0001\u0000\u0000\u0000\u00d2\u00c9\u0001\u0000\u0000"+
		"\u0000\u00d2\u00ca\u0001\u0000\u0000\u0000\u00d2\u00cb\u0001\u0000\u0000"+
		"\u0000\u00d2\u00cc\u0001\u0000\u0000\u0000\u00d2\u00cd\u0001\u0000\u0000"+
		"\u0000\u00d2\u00ce\u0001\u0000\u0000\u0000\u00d3!\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d5\u0005 \u0000\u0000\u00d5\u00d6\u0005\u0016\u0000\u0000\u00d6"+
		"\u00db\u0003\u0014\n\u0000\u00d7\u00d8\u0005\u001b\u0000\u0000\u00d8\u00da"+
		"\u0003\u0014\n\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da\u00dd\u0001"+
		"\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00db\u00dc\u0001"+
		"\u0000\u0000\u0000\u00dc\u00de\u0001\u0000\u0000\u0000\u00dd\u00db\u0001"+
		"\u0000\u0000\u0000\u00de\u00df\u0005\u0017\u0000\u0000\u00df#\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e3\u0005\u0005\u0000\u0000\u00e1\u00e3\u0005\u0006"+
		"\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e2\u00e1\u0001\u0000"+
		"\u0000\u0000\u00e3%\u0001\u0000\u0000\u0000\u0014(.7C^eqz\u008a\u008c"+
		"\u009e\u00a0\u00ac\u00ae\u00ba\u00bc\u00c7\u00d2\u00db\u00e2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}