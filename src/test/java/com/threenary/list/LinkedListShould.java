package com.threenary.list;

import com.threenary.node.Node;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListShould {

    private LinkedList<String> list = new LinkedList<>();;

    @Test
    void return_its_head() {
        assertThat(list.head()).isNull();
    }

    @Test
    void return_its_last_element() {
        Node<String> node = new Node<>("data");
        list.prepend(node);

        assertThat(list.tail()).isEqualTo(node);
    }

    @Test
    void add_one_element_to_its_head() {
        Node<String> node = new Node<>("data");
        list.prepend(node);

        assertThat(list.head()).isEqualTo(node);
    }

    @Test
    public void append_node_to_the_head_when_list_is_empty() {
        Node<String> node = new Node<>("data");
        list.append(node);

        assertThat(list.head()).isEqualTo(node);
    }

    @Test
    public void append_node_to_the_end_when_list_is_not_empty() {
        Node<String> head = new Node<>("data");
        list.prepend(head);

        Node<String> node = new Node<>("data");
        list.append(node);

        assertThat(list.head()).isEqualTo(head);
        assertThat(list.tail()).isEqualTo(node);
    }

    @Test
    public void delete_a_given_node() {
        Node<String> nodeToDelete = new Node<>("data");
        list.append(nodeToDelete);
        list.append(new Node<>("data"));

        list.delete(nodeToDelete);

        Node<String> head = list.head();
        while(head.getNext() != null){
            assertThat(head.equals(nodeToDelete)).isFalse();
        }
    }


}
