package org.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList {
    private Node firstNode;
    private Node lastNode;

    int count = 0;

    public void add(Integer value) {
        if (empty()) {
            firstNode = new Node();
            lastNode = firstNode;
            firstNode.value = value;
            return;
        }
        lastNode.next = new Node();
        lastNode = lastNode.next;
        lastNode.value = value;
        count++;
    }

    public Node get(int index) {
        if (empty()) {
            return null;
        }
        int counter = 0;
        for (Node node = firstNode; node != null; node = node.next) {
            if (counter >= index) {
                return node;
            }
            counter++;
        }
        return null;
    }

    public List<Integer> getElements() {
        if (empty()) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        for (Node node = firstNode; node != null; node = node.next) {
            list.add(node.value);
        }
        return list;
    }

    private int getSize() {
        return count;
    }
// a->c->b
// c->d
    public void merge(CustomList list) {
        int inputListSize = list.getSize();
        int counter = 0;
        for (Node node = firstNode; node != null; node = node.next) {
            if (counter < inputListSize) {
                Node inputListNode = list.get(counter++);
                Node next = node.next;
                node.next = inputListNode;
                node.next.next = next;
            }
        }
    }


    public boolean empty() {
        return firstNode == null;
    }


    public static class Node {
        Node next;
        Integer value;
    }

}
