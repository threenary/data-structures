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
    public void setUp(){
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
        String element = "element";
        Node<String> node = new Node<>(element);
        stack.push(node);

        assertThat(stack.peek()).isEqualTo(element);
    }


}