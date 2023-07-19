package org.simplelang;

import org.node.*;
import org.node.arithmetic.*;
import org.node.basic.*;
import org.node.comp.*;
import org.node.logic.*;

public class SimpleLangVisitorImpl extends SimpleLangBaseVisitor<Node> {
    @Override
    public Node visitBlock(SimpleLangParser.BlockContext ctx) {
        Block blockNode = new Block();
        blockNode.lineno = ctx.getStart().getLine();
        blockNode.stmts = visit(ctx.statements());
        return blockNode;
    }
    @Override
    public Node visitSingleStat(SimpleLangParser.SingleStatContext ctx) {
        return visit(ctx.statement());
    }

    @Override
    public Node visitMultipleStat(SimpleLangParser.MultipleStatContext ctx) {
        Statement statNode = (Statement)visit(ctx.statement());
        Statement nextStat = (Statement)visit(ctx.statements());
        statNode.children.add(nextStat);

        return statNode;
    }

    @Override
    public Node visitAssign(SimpleLangParser.AssignContext ctx) {
        Assignment assignNode = new Assignment();
        assignNode.lineno = ctx.getStart().getLine();
        assignNode.varName = ctx.ID().getText();
        assignNode.exprValue = (Expression)visit(ctx.expr());
        return assignNode;
    }

    @Override
    public Node visitFunctionCall(SimpleLangParser.FunctionCallContext ctx) {
        FuncCall funcCallNode = new FuncCall();
        funcCallNode.lineno = ctx.getStart().getLine();
        funcCallNode.outValue = (Expression)visit(ctx.expr());
        return funcCallNode;
    }

    @Override
    public Node visitWhileStmt(SimpleLangParser.WhileStmtContext ctx) {
        While whileNode = new While();
        whileNode.lineno = ctx.getStart().getLine();
        whileNode.cond = (Expression) visit(ctx.expr());
        whileNode.blockOfStmts = (Block) visit(ctx.block_of_stmts());
        return whileNode;
    }

    @Override
    public Node visitExpression(SimpleLangParser.ExpressionContext ctx) {
        return visit(ctx.logical());
    }

    @Override
    public Node visitOr(SimpleLangParser.OrContext ctx) {
        Or orNode = new Or();
        orNode.lineno = ctx.getStart().getLine();
        orNode.children.add(visit(ctx.logical()));
        orNode.children.add(visit(ctx.compare()));
        return orNode;
    }

    @Override
    public Node visitAnd(SimpleLangParser.AndContext ctx) {
        And andNode = new And();
        andNode.lineno = ctx.getStart().getLine();
        andNode.children.add(visit(ctx.logical()));
        andNode.children.add(visit(ctx.compare()));
        return andNode;
    }

    @Override public Node visitGreat(SimpleLangParser.GreatContext ctx) {
        Great greatNode = new Great();
        greatNode.lineno = ctx.getStart().getLine();
        greatNode.children.add(visit(ctx.compare()));
        greatNode.children.add(visit(ctx.plusOrMinus()));
        return greatNode;
    }

    @Override public Node visitLess(SimpleLangParser.LessContext ctx) {
        Less lessNode = new Less();
        lessNode.lineno = ctx.getStart().getLine();
        lessNode.children.add(visit(ctx.compare()));
        lessNode.children.add(visit(ctx.plusOrMinus()));
        return lessNode;
    }

    @Override public Node visitNeq(SimpleLangParser.NeqContext ctx) {
        Neq neqNode = new Neq();
        neqNode.lineno = ctx.getStart().getLine();
        neqNode.children.add(visit(ctx.compare()));
        neqNode.children.add(visit(ctx.plusOrMinus()));
        return neqNode;
    }

    @Override public Node visitEq(SimpleLangParser.EqContext ctx) {
        Eq eqNode = new Eq();
        eqNode.lineno = ctx.getStart().getLine();
        eqNode.children.add(visit(ctx.compare()));
        eqNode.children.add(visit(ctx.plusOrMinus()));
        return eqNode;
    }

    @Override
    public Node visitPlus(SimpleLangParser.PlusContext ctx) {
        Plus plusNode = new Plus();
        plusNode.lineno = ctx.getStart().getLine();
        plusNode.children.add(visit(ctx.plusOrMinus()));
        plusNode.children.add(visit(ctx.mulOrDiv()));
        return plusNode;
    }

    @Override
    public Node visitMinus(SimpleLangParser.MinusContext ctx) {
        Minus minusNode = new Minus();
        minusNode.lineno = ctx.getStart().getLine();
        minusNode.children.add(visit(ctx.plusOrMinus()));
        minusNode.children.add(visit(ctx.mulOrDiv()));
        return minusNode;
    }

    @Override
    public Node visitMul(SimpleLangParser.MulContext ctx) {
        Mul mulNode = new Mul();
        mulNode.lineno = ctx.getStart().getLine();
        mulNode.children.add(visit(ctx.mulOrDiv()));
        mulNode.children.add(visit(ctx.atom()));
        return mulNode;
    }

    @Override
    public Node visitDiv(SimpleLangParser.DivContext ctx) {
        Div divNode = new Div();
        divNode.lineno = ctx.getStart().getLine();
        divNode.children.add(visit(ctx.mulOrDiv()));
        divNode.children.add(visit(ctx.atom()));
        return divNode;
    }

    @Override
    public Node visitInteger(SimpleLangParser.IntegerContext ctx) {
        Int intNode = new Int();
        intNode.lineno = ctx.getStart().getLine();
        intNode.numValue = Integer.parseInt(ctx.INT().getText());
        return intNode;
    }

    @Override public Node visitTrue(SimpleLangParser.TrueContext ctx) {
        Bool boolNode = new Bool(true);
        boolNode.lineno = ctx.getStart().getLine();
        return boolNode;
    }

    @Override public Node visitFalse(SimpleLangParser.FalseContext ctx) {
        Bool boolNode = new Bool(false);
        boolNode.lineno = ctx.getStart().getLine();
        return boolNode;
    }

    @Override
    public Node visitVariable(SimpleLangParser.VariableContext ctx) {
        Var varNode = new Var();
        varNode.lineno = ctx.getStart().getLine();
        varNode.varName = ctx.ID().getText();
        return varNode;
    }

    @Override
    public Node visitParens(SimpleLangParser.ParensContext ctx) {
        return visit(ctx.compare());
    }
}