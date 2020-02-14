package com.threenary.tree;

import com.threenary.node.TreeNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTreeShould {

    @Test
    public void return_root_entry() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        assertThat(bst.getRoot().getData()).isEqualTo(100);
    }

    @Test
    public void insert_a_node_to_its_left_when_lower_than_root() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        var lowerValue = 5;

        bst.insert(lowerValue);

        assertThat(bst.getRoot().getLeft().getData().intValue()).isEqualTo(lowerValue);
    }

    @Test
    public void insert_a_node_to_its_right_when_higher_than_root() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(100);
        var higherValue = 500;

        bst.insert(higherValue);

        assertThat(bst.getRoot().getRight().getData().intValue()).isEqualTo(higherValue);
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


}