package org.node;

import java.util.ArrayList;
import java.util.Stack;
import org.simplelang.Ast;
import org.error.Err;

abstract public class Node {
    public int lineno;
    public ArrayList<Node> children;
    public Node() {
        children = new ArrayList<>();
    }
    abstract public Stack<Err> codegen(Ast tree);
}
