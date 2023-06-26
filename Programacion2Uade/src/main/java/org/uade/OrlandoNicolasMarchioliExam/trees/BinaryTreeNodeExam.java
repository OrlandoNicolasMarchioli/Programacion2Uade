package org.uade.OrlandoNicolasMarchioliExam.trees;

import lombok.ToString;

@ToString
public class BinaryTreeNodeExam {

    private int value;

    private int timesToAdd;
    private BinaryTreeExam left;
    private BinaryTreeExam right;

    public BinaryTreeNodeExam(int value,int timesToAdd, BinaryTreeExam left, BinaryTreeExam right) {
        this.value = value;
        this.timesToAdd = timesToAdd;
        this.left = left;
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public int getTimesToAdd() {
        return timesToAdd;
    }

    public void setTimesToAdd(int timesToAdd) {
        this.timesToAdd = timesToAdd;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeExam getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeExam left, int timesToAdd) {
        this.left = left;
        this.timesToAdd = timesToAdd;
    }

    public BinaryTreeExam getRight() {
        return right;
    }

    public void setRight(BinaryTreeExam right, int timesToAdd) {
        this.right = right;
        this.timesToAdd = timesToAdd;
    }
}
