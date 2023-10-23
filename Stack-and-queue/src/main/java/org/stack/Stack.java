package org.stack;

import java.util.List;

public interface Stack<E> {
    E push(E item);

    E pop();

    E peek();

    boolean empty();

    int size();

    List<E> getElements();

    Stack<E> reverse();

    void print();
}
