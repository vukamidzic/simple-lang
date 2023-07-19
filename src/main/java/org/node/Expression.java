package org.node;

abstract public class Expression extends Node {
    public enum ExprTy {INT, BOOL}
    public ExprTy exprTy;
    public static int tmpCounter;
    public int tmpNum;
    public Expression() {
        super();
        tmpCounter = 0;
    }
}
