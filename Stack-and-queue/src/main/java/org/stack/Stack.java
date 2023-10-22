package org.stack;

public interface Stack<E> {
    E push(E item);

    E pop();

    void push(int data);

    E peek();

    boolean empty();
}
