package org.node;

import org.simplelang.Ast;
import org.error.Err;

public class Block extends Statement {
    public Node stmts;
    public boolean canAddScope = true;
    public Block() {super();}

    @Override
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: Block node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);
        
        if (canAddScope) tree.addScope();
        Err stmtsErr = stmts.codegen(tree);
        if (stmtsErr.errno != Err.Errno.OK) return stmtsErr;
        tree.removeScope();
        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);
            Err nextErr = nextNode.codegen(tree);
            if (nextErr.errno != Err.Errno.OK) return nextErr;
        }

        return new Err(Err.Errno.OK, -1, "");
    }

    // returns first node from inside of block
    public Node getFirstStmt() {return stmts;}

    // checks if the block contains any return statements
    public boolean containsRetStmt() {
        Statement curr = (Statement) this.stmts;

        while (curr.children.size() > 0) {
            if (curr instanceof Return) return true; 
            curr = (Statement) curr.children.get(0);
        }

        return (curr instanceof Return);
    }
}
