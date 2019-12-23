package com.threenary.queue;

import java.util.Stack;

public class QueueWithTwoStacks<T> {
    private Stack<T> stack = new Stack<>();
    private Stack<T> stackBottomUp = new Stack<>();

    public void enqueue(T element) {
        stack.push(element);
    }

    public int size() {
        return stack.size() + stackBottomUp.size();
    }

    public T dequeue() {
        traverseStacks();
        return stackBottomUp.pop();
    }

    public T peek() {
        traverseStacks();
        return stackBottomUp.peek();
    }

    private void traverseStacks() {
        if (stackBottomUp.isEmpty()) {
            while (!stack.isEmpty()) {
                stackBottomUp.push(stack.pop());
            }
        }
    }
}
