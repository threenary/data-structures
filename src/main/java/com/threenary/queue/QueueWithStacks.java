package com.threenary.queue;

import java.util.Stack;

/**
 * <code>Queue</code> implemented with two <code>Stack</code>
 *
 * @param <T>
 */
public class QueueWithStacks<T> {
    private Stack<T> stackNewest = new Stack<>();
    private Stack<T> stackOldest = new Stack<>();

    public void enqueue(T element) {
        stackNewest.push(element);
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public T dequeue() {
        if (stackOldest.isEmpty()) {
            traverseStacks();
        }
        return stackOldest.pop();
    }

    public T peek() {
        if (stackOldest.isEmpty()) {
            traverseStacks();
        }
        return stackOldest.peek();
    }

    private void traverseStacks() {
        while (!stackNewest.isEmpty()) {
            stackOldest.push(stackNewest.pop());
        }
    }
}
