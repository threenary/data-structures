package com.threenary.queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueueWithTwoStacksShould {

    private QueueWithTwoStacks<Object> queue = new QueueWithTwoStacks<>();

    @Test
    void return_its_size() {
        assertThat(queue.size()).isEqualTo(0);
    }

    @Test
    void store_one_element() {
        queue.enqueue(1);
        assertThat(queue.size()).isEqualTo(1);
    }

    @Test
    void store_more_elements() {
        addIntegersInAscendingOrderToQueue(10);
        assertThat(queue.size()).isEqualTo(9);
    }

    @Test
    void dequeue_inserted_element() {
        queue.enqueue(1);
        assertThat(queue.dequeue()).isEqualTo(1);
    }

    @Test
    void deque_first_inserted_element() {
        addIntegersInAscendingOrderToQueue(2);
        assertThat(queue.dequeue()).isEqualTo(1);
    }

    @Test
    void deque_elements_in_order_of_insertion() {
        int quantity = 5;
        addIntegersInAscendingOrderToQueue(quantity);

        for (int i = 1; i < quantity; i++) {
            assertThat(queue.dequeue()).isEqualTo(i);
        }
    }

    @Test
    void expose_element_in_order_of_insertion() {
        addIntegersInAscendingOrderToQueue(10);
        assertThat(queue.peek()).isEqualTo(1);
    }

    @Test
    void deque_all_elements_in_fifo_order_in_between_queue_operations() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertThat(queue.dequeue()).isEqualTo(1);
        queue.enqueue(3);
        assertThat(queue.dequeue()).isEqualTo(2);
        assertThat(queue.dequeue()).isEqualTo(3);
    }

    @Test
    void peek_the_oldest_element_in_queue() {
        queue.enqueue(1);
        queue.enqueue(2);
        assertThat(queue.peek()).isEqualTo(1);
        queue.enqueue(3);
        queue.enqueue(4);
        assertThat(queue.peek()).isEqualTo(1);
        queue.dequeue();
        assertThat(queue.peek()).isEqualTo(2);
    }


    private void addIntegersInAscendingOrderToQueue(int param) {
        for (int i = 1; i < param; i++) {
            queue.enqueue(i);
        }
    }
}
