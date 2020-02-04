package com.threenary.stack;


import com.threenary.node.Node;

/**
 * Self implementation of a Stack
 *
 * @param <T>
 */
public class Stack<T> {

    private Node<T> head;

    public boolean isEmpty() {
        return (head == null);
    }

    public T peek() {
        return isEmpty() ? null : head.getData();
    }

    public void push(Node<T> node) {
        node.setNext(head);
        this.head = node;
    }
}
