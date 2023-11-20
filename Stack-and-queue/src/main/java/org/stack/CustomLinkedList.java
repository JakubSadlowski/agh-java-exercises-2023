package org.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CustomLinkedList {
    private Node tail;
    private Node head;

    int size = 0;

    public CustomLinkedList add(Integer value) {
        if (isEmpty()) {
            head = tail = new Node(value);
        } else {
            head.next = new Node(value);
            head = head.next;
        }
        size++;
        return this;
    }

    public int get(int index) {
        Node node = getNode(index);
        return node != null ? node.value : null;
    }

    Node getNode(int index) {
        if (isEmpty() || index > size) {
            return null;
        }
        int indexCounter = 0;
        for (Node node = tail; node != null; node = node.next) {
            if (indexCounter == index) {
                return node;
            }
            indexCounter++;
        }
        return null;
    }

    public List<Integer> getElements() {
        if (isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();
        for (Node node = tail; node != null; node = node.next) {
            list.add(node.value);
        }
        return Collections.unmodifiableList(list);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public String toString() {
        return Arrays.toString(getElements().toArray());
    }

    private void clear() {
        tail = head = null;
    }

    public void merge(CustomLinkedList list2) {
        Node node1 = this.tail, node2 = list2.tail;

        while (node1 != null && node2 != null) {
            Node node1Next = node1.next;
            Node node2Next = node2.next;
            node1.next = node2;
            node2.next = node1Next;

            if (node1Next != null && node2Next != null) {
                node1 = node1Next;
                node2 = node2Next;
            } else if (node1Next != null && node2Next == null) {
                break;
            } else {
                node1 = node1.next;
                while (node2Next != null) {
                    node1.next = node2Next;
                    node1 = node1.next;
                    node2Next = node2Next.next;
                }
                break;
            }
        }
        list2.clear();
    }


    public static class Node {
        Node next;
        Integer value;

        Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{value=" + value + ", next=" + (next == null ? "empty" : "not empty") + "}";
        }
    }

}
