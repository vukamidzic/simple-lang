package org.node;

import org.simplelang.Ast;
import org.error.Err;

public class Block extends Statement {
    public Node stmts;

    public Block() {super();}

    @Override
    public Err codegen(Ast tree) {
        System.err.format("(line %d)Node: Block node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);
        tree.addScope();
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
}
