package com.threenary.queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueueShould {

    private Queue<String> queue = new Queue<>();

    @Test
    void show_null_when_has_no_elements() {
        assertThat(queue.peek()).isNull();
    }

    @Test
    public void show_head_element_data() {
        Node<String> element = new Node<>("data");
        queue.add(element);

        assertThat(queue.peek()).isEqualTo(element.getData());
    }

    @Test
    void add_element_to_its_head_when_empty() {
        Node<String> element = new Node<>("data");
        queue.add(element);

        assertThat(queue.peek()).isEqualTo(element.getData());
    }

    @Test
    void add_element_to_tail_when_not_empty() {
        Node<String> firstNode = new Node<>("firstData");
        queue.add(firstNode);
        Node<String> secondNode = new Node<>("secondData");
        queue.add(secondNode);

        //then
        assertThat(queue.peek()).isEqualTo(firstNode.getData());
    }

    @Test
    public void remove_the_oldest_element_and_update_head() {
        Node<String> oldestNode = new Node<>("firstData");
        queue.add(oldestNode);
        Node<String> secondNode = new Node<>("secondData");
        queue.add(secondNode);

        assertThat(queue.remove()).isEqualTo(oldestNode);
        assertThat(queue.peek()).isEqualTo(secondNode.getData());
    }

    @Test
    public void return_elements_in_fifo_order() {
        Node<String> firstNode = new Node<>("first");
        Node<String> secondNode = new Node<>("second");
        Node<String> thirdNode = new Node<>("third");
        Node<String> fourthNode = new Node<>("fourth");

        queue.add(firstNode);
        queue.add(secondNode);
        queue.add(thirdNode);
        queue.add(fourthNode);

        assertThat(queue.remove()).isEqualTo(firstNode);
        assertThat(queue.remove()).isEqualTo(secondNode);
        assertThat(queue.remove()).isEqualTo(thirdNode);
        assertThat(queue.remove()).isEqualTo(fourthNode);
    }
}
