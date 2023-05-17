package org.uade.dynamic;

import org.uade.adt.definitions.IBinaryTree;
import org.uade.adt.node.BinaryTreeNode;
import org.uade.dynamic.definitions.IGenericBinaryTree;
import org.uade.dynamic.node.GenericBinaryTreeNode;

public class GenericBinaryTree<T> implements IGenericBinaryTree<T> {

    private GenericBinaryTreeNode<T> root;

    public GenericBinaryTree() {
    }

    public GenericBinaryTree(T value, Object o, Object o1) {
    }

    @Override
    public void create(T value) {
        this.root = new GenericBinaryTreeNode<>();
    }

    @Override
    public T getValue() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void addLeft(T value) {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        GenericBinaryTree genericBinaryTree = new GenericBinaryTree();
        genericBinaryTree.create(value);
        this.root.setLeft(genericBinaryTree);
    }

    @Override
    public void addRight(T value) {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        GenericBinaryTree genericBinaryTree = new GenericBinaryTree();
        genericBinaryTree.create(value);
        this.root.setRight(genericBinaryTree);
    }

    @Override
    public void removeLeft() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setLeft(null);
    }

    @Override
    public void removeRight() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        this.root.setRight(null);
    }

    @Override
    public GenericBinaryTree getLeft() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getLeft();
    }

    @Override
    public GenericBinaryTree getRight() {
        if(this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getRight();
    }
}

