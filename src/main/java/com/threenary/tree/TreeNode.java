package com.threenary.tree;

/**
 * Self implementation of a Tree
 *
 * @param <T> # Insert: O(log(n))
 *            # Remove: O(log(n))
 *            # Access: O(log(n))
 *            # Search: O(log(n))
 */
public class TreeNode<T extends Comparable<? super T>> {
    private T data;
    private TreeNode<? extends T> left;
    private TreeNode<? extends T> right;

    public TreeNode(T value) {
        this.data = value;
    }

    public TreeNode<? extends T> getLeft() {
        return this.left;
    }

    public TreeNode<? extends T> getRight() {
        return this.right;
    }

    public void insert(TreeNode<? extends T> node) {
        if (data.compareTo(node.data) >= 0) {
            this.left = node;
        } else {
            this.right = node;
        }
    }
}
