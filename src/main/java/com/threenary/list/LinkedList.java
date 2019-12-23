package com.threenary.list;

public class LinkedList {

    private LinkedListNode head;

    public void prepend(LinkedListNode node) {
        node.next(head);
        if (null != head){
            head.next(null);
        }
        head = node;
    }

    public LinkedListNode head() {
        return this.head;
    }

    public void append(LinkedListNode node) {
        if(head == null){
            prepend(node);
        }else{
            LinkedListNode tail = tail();
            tail.next(node);
        }
    }

    public LinkedListNode tail() {
        LinkedListNode current = head;
        while(current.next() != null){
            current = current.next();
        }
        return current;
    }

    public void delete(LinkedListNode nodeToDelete) {
        if (nodeToDelete.equals(head)) {
            head = head.next();
        }else if(head != null){
            LinkedListNode current = head;
            while (current.next() != null){
                if(current.next().equals(nodeToDelete)){
                    current.next(current.next().next());
                    return;
                }
                current = current.next();
            }
        }

    }
}
