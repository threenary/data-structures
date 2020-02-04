package com.threenary.stack;

import com.threenary.node.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackShould {

    private Stack<String> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void return_true_if_stack_has_no_elements() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void adds_element_to_the_stack() {
        Node<String> node = new Node<>("element");
        stack.push(node);

        assertFalse(stack.isEmpty());
    }

    @Test
    public void return_the_head_data_when_no_empty() {
        Node<String> node = new Node<>("element");
        stack.push(node);

        assertThat(stack.peek()).isEqualTo(node.getData());
    }

    @Test
    public void return_data_of_the_last_element_added() {
        Node<String> node1 = new Node<>("node1");
        stack.push(node1);
        Node<String> node2 = new Node<>("node2");
        stack.push(node2);

        assertThat(stack.peek()).isEqualTo(node2.getData());
    }

    @Test
    public void extract_the_last_node_inserted() {
        Node<String> node1 = new Node<>("node1");
        stack.push(node1);
        Node<String> node2 = new Node<>("node2");
        stack.push(node2);

        assertThat(stack.pop()).isEqualTo(node2);
        assertThat(stack.peek()).isEqualTo(node1.getData());
    }
}