package org.stack;

import java.util.List;

public interface Queue {

    boolean isEmpty();

    boolean isFull();

    void add(int data);

    Integer poll();

    int indexOf(int value);

    int remove(int index);

    List<Integer> getElements();
}
