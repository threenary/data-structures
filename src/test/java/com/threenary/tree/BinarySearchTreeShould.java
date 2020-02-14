package com.threenary.tree;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeShould {

    @Test
    public void return_root_entry() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        assertThat(bst.getRoot().getData()).isEqualTo(100);
    }

    @Test
    public void insert_smaller_value_node_to_the_left_when_empty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        var lowerValue = 5;

        bst.insert(lowerValue);

        assertThat(bst.getRoot().getLeft().getData().intValue()).isEqualTo(lowerValue);
    }

    @Test
    public void insert_bigger_value_node_to_the_right_when_empty() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        var higherValue = 500;

        bst.insert(higherValue);

        assertThat(bst.getRoot().getRight().getData().intValue()).isEqualTo(higherValue);
    }

    @Test
    public void insert_node_as_left_leaf_when_tree_not_empty_an_lower_value() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        var firstLeftValue = 90;
        bst.insert(firstLeftValue);

        var secondLeftValue = 50;
        bst.insert(secondLeftValue);

        assertThat(bst.getRoot().getLeft().getData().intValue()).isNotEqualTo(secondLeftValue);
        assertThat(bst.getRoot().getLeft().getLeft().getData().intValue()).isEqualTo(secondLeftValue);
    }

    @Test
    public void insert_node_as_right_leaf_when_tree_not_empty_an_bigger_value() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        var firstRightValue = 120;
        bst.insert(firstRightValue);

        var secondRightValue = 150;
        bst.insert(secondRightValue);

        assertThat(bst.getRoot().getRight().getData().intValue()).isNotEqualTo(secondRightValue);
        assertThat(bst.getRoot().getRight().getRight().getData().intValue()).isEqualTo(secondRightValue);
    }

    @Test
    public void identify_if_a_value_exists_in_the_root() {
        var value = 50;
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(value);

        assertThat(bst.contains(value)).isTrue();
    }

    @Test
    public void identify_if_a_value_exists_in_any_branch() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        for (int i = 0; i < 10; i++) {
            bst.insert(i * ThreadLocalRandom.current().nextInt());
        }
        var value = 55;
        bst.insert(value);

        assertThat(bst.contains(value)).isTrue();
    }

    @Test
    public void return_the_count_of_nodes_in_branches_plus_root() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(55);
        var expectedSize = 10;
        for (int i = 0; i < expectedSize; i++) {
            bst.insert(i);
        }

        assertThat(bst.size()).isEqualTo(expectedSize + 1);
    }

    @Test
    public void return_one_when_only_root() {
        assertThat(new BinarySearchTree<>(10).size()).isEqualTo(1);
    }

    @Test
    public void print_values_in_order_from_left_to_right() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(10);
        bst.insert(5);
        bst.insert(8);
        bst.insert(15);

        List<Integer> result = bst.traverseInOrder();
        assertThat(result).containsExactly(5,8,10,15);
    }


}