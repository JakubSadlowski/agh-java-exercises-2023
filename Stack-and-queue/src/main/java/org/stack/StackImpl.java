package org.stack;

public class StackImpl {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }
    }

    private Node top;
    public Node getTop() {
        return top;
    }

    public int getDataFromStack(){
        return top.getData();
    }

    StackImpl() {
        this.top = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1;
        }
        int data = top.data;
        top = top.next;
        return data;
    }

    public void printStack() {
        Node current = top;
        System.out.println("Stack contents:");
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void selectMultiples(int[] sequence, int l) {
        for (int num : sequence) {
            if (num % l == 0) {
                push(num);
            }
        }
    }
}
