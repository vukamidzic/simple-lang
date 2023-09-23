package org.simplelang;

// Generated from src/main/java/org/simplelang/SimpleLang.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code ToStatements}
	 * labeled alternative in {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToStatements(SimpleLangParser.ToStatementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndOfProgram}
	 * labeled alternative in {@link SimpleLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndOfProgram(SimpleLangParser.EndOfProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultipleStat}
	 * labeled alternative in {@link SimpleLangParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultipleStat(SimpleLangParser.MultipleStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleStat}
	 * labeled alternative in {@link SimpleLangParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleStat(SimpleLangParser.SingleStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAssignment}
	 * labeled alternative in {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAssignment(SimpleLangParser.ToAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToFuncCall}
	 * labeled alternative in {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToFuncCall(SimpleLangParser.ToFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToWhile}
	 * labeled alternative in {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToWhile(SimpleLangParser.ToWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToFor}
	 * labeled alternative in {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToFor(SimpleLangParser.ToForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToIfElse}
	 * labeled alternative in {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToIfElse(SimpleLangParser.ToIfElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBlock}
	 * labeled alternative in {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBlock(SimpleLangParser.ToBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToFuncDef}
	 * labeled alternative in {@link SimpleLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToFuncDef(SimpleLangParser.ToFuncDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NonEmptyIf}
	 * labeled alternative in {@link SimpleLangParser#ifElseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonEmptyIf(SimpleLangParser.NonEmptyIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EmptyIf}
	 * labeled alternative in {@link SimpleLangParser#ifElseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyIf(SimpleLangParser.EmptyIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(SimpleLangParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(SimpleLangParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link SimpleLangParser#block_of_stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncDef}
	 * labeled alternative in {@link SimpleLangParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(SimpleLangParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignVar}
	 * labeled alternative in {@link SimpleLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignVar(SimpleLangParser.AssignVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignConst}
	 * labeled alternative in {@link SimpleLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignConst(SimpleLangParser.AssignConstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SFuncCall}
	 * labeled alternative in {@link SimpleLangParser#statFuncCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSFuncCall(SimpleLangParser.SFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Expression}
	 * labeled alternative in {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SimpleLangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link SimpleLangParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(SimpleLangParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link SimpleLangParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(SimpleLangParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToCompare}
	 * labeled alternative in {@link SimpleLangParser#logical}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToCompare(SimpleLangParser.ToCompareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Great}
	 * labeled alternative in {@link SimpleLangParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreat(SimpleLangParser.GreatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPlusOrMinus}
	 * labeled alternative in {@link SimpleLangParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPlusOrMinus(SimpleLangParser.ToPlusOrMinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Neq}
	 * labeled alternative in {@link SimpleLangParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNeq(SimpleLangParser.NeqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Eq}
	 * labeled alternative in {@link SimpleLangParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEq(SimpleLangParser.EqContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Less}
	 * labeled alternative in {@link SimpleLangParser#compare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLess(SimpleLangParser.LessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToMulOrDiv}
	 * labeled alternative in {@link SimpleLangParser#plusOrMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToMulOrDiv(SimpleLangParser.ToMulOrDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Plus}
	 * labeled alternative in {@link SimpleLangParser#plusOrMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(SimpleLangParser.PlusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Minus}
	 * labeled alternative in {@link SimpleLangParser#plusOrMinus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(SimpleLangParser.MinusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPtr}
	 * labeled alternative in {@link SimpleLangParser#mulOrDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPtr(SimpleLangParser.ToPtrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link SimpleLangParser#mulOrDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(SimpleLangParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mul}
	 * labeled alternative in {@link SimpleLangParser#mulOrDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul(SimpleLangParser.MulContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToPointer}
	 * labeled alternative in {@link SimpleLangParser#ptrOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToPointer(SimpleLangParser.ToPointerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FromPointer}
	 * labeled alternative in {@link SimpleLangParser#ptrOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromPointer(SimpleLangParser.FromPointerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToAtom}
	 * labeled alternative in {@link SimpleLangParser#ptrOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToAtom(SimpleLangParser.ToAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToBool}
	 * labeled alternative in {@link SimpleLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToBool(SimpleLangParser.ToBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ToExprFuncCall}
	 * labeled alternative in {@link SimpleLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitToExprFuncCall(SimpleLangParser.ToExprFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Integer}
	 * labeled alternative in {@link SimpleLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(SimpleLangParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Float}
	 * labeled alternative in {@link SimpleLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat(SimpleLangParser.FloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link SimpleLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(SimpleLangParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link SimpleLangParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(SimpleLangParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EFuncCall}
	 * labeled alternative in {@link SimpleLangParser#exprFuncCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEFuncCall(SimpleLangParser.EFuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code True}
	 * labeled alternative in {@link SimpleLangParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue(SimpleLangParser.TrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code False}
	 * labeled alternative in {@link SimpleLangParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalse(SimpleLangParser.FalseContext ctx);
}