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
        }else {
            insertRight(node);
        }
    }

    private void insertRight(TreeNode<T> node) {
        if(right != null) {
            this.right.insert(node);
        }else{
            this.right = node;
        }
    }

    private void insertLeft(TreeNode<T> node) {
        if(left != null){
            this.left.insert(node);
        }else{
            this.left = node;
        }
    }

    public TreeNode<T> getLeft() {
        return this.left;
    }

    public TreeNode<T> getRight() {
        return this.right;
    }
}
