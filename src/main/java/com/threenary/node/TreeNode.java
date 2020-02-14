package com.threenary.node;

import java.util.LinkedList;
import java.util.List;

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
        if (data.compareTo(node.getData()) >= 0) {
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

    public void setLeft(TreeNode<T> node) {
        if (data.compareTo(node.getData()) > 0) {
            throw new IllegalArgumentException("Can't add a bigger value in the left branch");
        }
        this.left = node;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }

    public void setRight(TreeNode<T> node) {
        if (data.compareTo(node.getData()) <= 0) {
            throw new IllegalArgumentException("Can't add a lower value in the right branch");
        }
        this.right = node;
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

    public void remove(T value) {

    }

    public List<T> traverseInOrder() {
        List<T> result = new LinkedList<>();
        if (left != null) {
            result.addAll(left.traverseInOrder());
        }
        result.add(data);
        if (right != null) {
            result.addAll(right.traverseInOrder());
        }
        return result;
    }
}
