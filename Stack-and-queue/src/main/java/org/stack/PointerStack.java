package org.stack;

import java.util.ArrayList;
import java.util.List;

public class PointerStack implements Stack<Integer> {
    private Node top;
    private int countElements = 0;

    PointerStack() {
        this.top = null;
    }


    @Override
    public Integer push(Integer data) {
        countElements++;
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        return top.data;
    }

    @Override
    public Integer pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        countElements--;
        int data = top.data;
        top = top.next;
        return data;
    }

    @Override
    public Integer peek() {
        if (empty()) {
            return null;
        }
        return top.data;
    }

    @Override
    public boolean empty() {
        return top == null;
    }

    @Override
    public int size() {
        return countElements;
    }

    @Override
    public List<Integer> getElements() {
        Stack<Integer> reverse = reverse();
        List<Integer> result = new ArrayList<>(countElements);
        while (!reverse.empty()) {
            result.add(reverse.pop());
        }
        return result;
    }

    @Override
    public Stack<Integer> reverse() {
        Stack<Integer> result = new PointerStack();
        if (empty()) {
            return result;
        }
        for (Node node = top; node != null; node = node.next) {
            result.push(node.data);
        }
        return result;
    }

    @Override
    public void print(){
        
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

}
