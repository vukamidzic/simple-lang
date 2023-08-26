package org.node;

import org.node.Expression;

public interface Operation {
    public void func(Expression lhs, Expression rhs);
}
