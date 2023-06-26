package org.uade.OrlandoNicolasMarchioliExam.trees;

import lombok.ToString;

@ToString
public class BinaryTreeExam implements IBinaryTreeExam {

    private BinaryTreeNodeExam root;

    private int timesToAdd;

    @Override
    public void create(int value, int timesToAdd) {
        this.root = new BinaryTreeNodeExam(value, timesToAdd, null, null);
    }

    @Override
    public int getValue() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getValue();
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public void addLeft(int value, int timesToAdd) {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTreeExam binaryTree = new BinaryTreeExam();
        binaryTree.create(value, timesToAdd);
        this.root.setLeft(binaryTree,timesToAdd);
    }

    @Override
    public void addRight(int value, int timesToAdd) {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        BinaryTreeExam binaryTree = new BinaryTreeExam();
        binaryTree.create(value, timesToAdd);
        this.root.setRight(binaryTree,timesToAdd);
    }

    @Override
    public void removeLeft() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        if(timesToAdd >=1){
            this.root.setLeft(null, timesToAdd - 1);
        }else {
            throw new RuntimeException("You cant delete a value if is only 1 time on the tree");
        }
    }

    @Override
    public void removeRight() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        if(timesToAdd >=1){
            this.root.setRight(null, timesToAdd - 1);
        }else {
            throw new RuntimeException("You cant delete a value if is only 1 time on the tree");
        }
    }

    @Override
    public BinaryTreeExam getLeft() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getLeft();
    }

    @Override
    public BinaryTreeExam getRight() {
        if (this.root == null) {
            throw new RuntimeException("The tree is empty");
        }
        return this.root.getRight();
    }
}
