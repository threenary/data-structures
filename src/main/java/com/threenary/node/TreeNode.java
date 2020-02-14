package com.threenary.node;

public class TreeNode<T extends Comparable<T>> {
    private T data;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.data = value;
    }

    public T getData() {
        return data;
    }

    public void insert(TreeNode<T> node) {
        if (data.compareTo(node.data) >= 0) {
            insertLeft(node);
        } else {
            insertRight(node);
        }
    }

    private void insertRight(TreeNode<T> node) {
        if (right != null) {
            this.right.insert(node);
        } else {
            this.right = node;
        }
    }

    private void insertLeft(TreeNode<T> node) {
        if (left != null) {
            this.left.insert(node);
        } else {
            this.left = node;
        }
    }

    public TreeNode<T> getLeft() {
        return this.left;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }

    public boolean contains(T value) {
        return this.getData().equals(value)
                || isContainedInLeftBranch(value)
                || isContainedInRightBranch(value);
    }

    private boolean isContainedInRightBranch(T value) {
        return (null != right) && this.getRight().contains(value);
    }

    private boolean isContainedInLeftBranch(T value) {
        return (null != left) && this.getLeft().contains(value);
    }

    public int size() {
        return 1 + countLeft() + countRight();
    }

    private int countLeft() {
        return (left != null) ? left.size() : 0;
    }

    private int countRight() {
        return (right != null) ? right.size() : 0;
    }
}
