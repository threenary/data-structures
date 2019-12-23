package com.threenary.list;

public class LinkedListNode {
    private LinkedListNode next;

    public void next(LinkedListNode node) {
        this.next = node;
    }

    public LinkedListNode next() {
        return next;
    }
}
