package com.threenary.list;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListShould {

    private LinkedList list = new LinkedList();;

    @Test
    public void return_its_head() {
        assertThat(list.head()).isNull();
    }

    @Test
    public void return_its_last_element() {
        LinkedListNode node = new LinkedListNode();
        list.prepend(node);

        assertThat(list.tail()).isEqualTo(node);
    }

    @Test
    public void add_one_element_to_its_head() {
        LinkedListNode node = new LinkedListNode();
        list.prepend(node);

        assertThat(list.head()).isEqualTo(node);
    }

    @Test
    public void append_node_to_the_head_when_list_is_empty() {
        LinkedListNode node = new LinkedListNode();
        list.append(node);

        assertThat(list.head()).isEqualTo(node);
    }

    @Test
    public void append_node_to_the_end_when_list_is_not_empty() {
        LinkedListNode head = new LinkedListNode();
        list.prepend(head);

        LinkedListNode node = new LinkedListNode();
        list.append(node);

        assertThat(list.head()).isEqualTo(head);
        assertThat(list.tail()).isEqualTo(node);
    }

    @Test
    public void delete_a_given_node() {
        LinkedListNode nodeToDelete = new LinkedListNode();
        list.append(nodeToDelete);
        list.append(new LinkedListNode());

        list.delete(nodeToDelete);

        LinkedListNode head = list.head();
        while(head.next() != null){
            assertThat(head.equals(nodeToDelete)).isFalse();
        }
    }


}
