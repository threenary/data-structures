package com.threenary.stack;


import com.threenary.node.Node;

/**
 * Self implementation of a Stack
 *
 * @param <T>
 *
 * # Add: O(1)
 * # Remove: O(1)
 * # Access: O(n)
 * # Search: O(n)
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

    public Node<T> pop() {
        Node<T> node = head;
        head = head.getNext();
        return node;
    }
}
