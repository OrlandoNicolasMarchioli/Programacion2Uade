package org.uade.dynamic.node;

import org.uade.dynamic.GenericBinaryTree;

public class GenericBinaryTreeNode<T> {

    private T value;
    private GenericBinaryTree left;
    private GenericBinaryTree right;

    public GenericBinaryTreeNode(T value, GenericBinaryTree<T> left, GenericBinaryTree<T> right) {
    }

    public void BinaryTreeNode(T value, GenericBinaryTree left, GenericBinaryTree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericBinaryTree getLeft() {
        return left;
    }

    public void setLeft(GenericBinaryTree left) {
        this.left = left;
    }

    public GenericBinaryTree getRight() {
        return right;
    }

    public void setRight(GenericBinaryTree right) {
        this.right = right;
    }
}

