package com.threenary.tree;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TreeNodeShould {

    @Test
    public void insert_a_node_to_its_left_when_lower() {
        TreeNode<Integer> treeNode = new TreeNode<>(5);
        TreeNode<Integer> leftNode = new TreeNode<>(2);

        treeNode.insert(leftNode);

        assertThat(treeNode.getLeft()).isEqualTo(leftNode);
    }

    @Test
    public void insert_a_node_to_its_right_when_bigger() {
        TreeNode<Integer> treeNode = new TreeNode<>(5);
        TreeNode<Integer> rightNode = new TreeNode<>(10);

        treeNode.insert(rightNode);

        assertThat(treeNode.getRight()).isEqualTo(rightNode);
    }



}