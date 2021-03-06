package com.threenary.queue;

import com.threenary.node.Node;

/**
 * Self implementation of a Queue
 *
 * @param <T>
 *
 * # Add: O(1)
 * # Remove: O(1)
 * # Access: O(n)
 * # Search: O(n)
 *
 */
public class Queue<T> {
    private Node<T> tail;
    private Node<T> head;

    public void add(Node<T> element) {
        if (null == head) {
            head = element;
            tail = head;
        } else {
            tail.setNext(element);
            tail = element;
        }
    }

    public T peek() {
        return (null == head) ? null : head.getData();
    }

    public Node<T> remove() {
        Node response = head;
        if (head != null) {
            head = head.getNext();
        }
        return response;
    }
}
