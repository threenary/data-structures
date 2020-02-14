package com.threenary.tree;

import com.threenary.node.TreeNode;

/**
 * Self implementation of a BinarySearchTree
 *
 * @param <T> # Insert: O(log(n))
 *            # Remove: O(log(n))
 *            # Access: O(log(n))
 *            # Search: O(log(n))
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BinarySearchTree(T value) {
        this.root = new TreeNode<>(value);
    }

    public void insert(T value) {
        TreeNode<T> node = new TreeNode<>(value);
        root.insert(node);
    }

    public void remove(TreeNode<T> node) {
        throw new UnsupportedOperationException();
    }

    public boolean contains(T value) {
        return root.contains(value);
    }

    public void traverseInOrder() {
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    public TreeNode<T> getRoot() {
        return root;
    }

    public int size() {
        return (root != null) ? root.size() : 0;
    }

}
