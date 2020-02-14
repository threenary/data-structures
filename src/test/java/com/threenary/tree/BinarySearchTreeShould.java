package com.threenary.tree;

import org.junit.jupiter.api.Test;

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



}