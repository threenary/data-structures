package com.threenary.list;

import com.threenary.node.Node;

public class LinkedList<T> {

    private Node<T> head;

    public void prepend(Node<T> node) {
        node.setNext(head);
        if (null != head){
            head.setNext(null);
        }
        head = node;
    }

    public Node<T> head() {
        return this.head;
    }

    public void append(Node<T> node) {
        if(head == null){
            prepend(node);
        }else{
            Node tail = tail();
            tail.setNext(node);
        }
    }

    public Node<T> tail() {
        Node current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        return current;
    }

    public void delete(Node<T> nodeToDelete) {
        if (nodeToDelete.equals(head)) {
            head = head.getNext();
        }else if(head != null){
            Node<T> current = head;
            while (current.getNext() != null){
                if(current.getNext().equals(nodeToDelete)){
                    current.setNext(current.getNext().getNext());
                    return;
                }
                current = current.getNext();
            }
        }

    }
}
