package org.uade.Algorithms;

import org.uade.adt.BinaryTree;
import org.uade.dynamic.GenericBinaryTree;
import org.uade.dynamic.node.GenericBinaryTreeNode;

import java.util.Random;

public class TreeAlgorithms<T> {

    public static BinaryTree generateBinaryTree(int range){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(5);
        int value = new Random().nextInt(20);
        for (int i = 0; i < range; i++) {
            binaryTree = addRecursive(binaryTree,value);
        }
        return binaryTree;
    }

    public static BinaryTree addRecursive(BinaryTree current, int value) {
        int rValue = new Random().nextInt(20);
        if (current == null) {
            BinaryTree binaryTree = new BinaryTree();
            binaryTree.create(5);
            return binaryTree;
        }

        if (value < current.getValue()) {
            current.addLeft(value);
            addRecursive(current,rValue);
        } else if (value > current.getValue()) {
            current.addRight(value);
            addRecursive(current,rValue);
        } else {
            // value already exists
            return current;
        }

        return current;
    }

    public static int travelIntoTheBinaryTreeAndSumValues(BinaryTree binaryTree, int sumOfValues) {
        if (binaryTree.getLeft() != null && binaryTree.getRight() != null) {
            if(binaryTree.getLeft().getLeft() != null || binaryTree.getLeft().getRight() != null){
                if(binaryTree.getLeft().getLeft() != null){
                    sumOfValues = sumOfValues + binaryTree.getLeft().getValue();
                    BinaryTree newBranch = binaryTree.getLeft();
                    return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
                }if(binaryTree.getLeft().getRight() != null){
                    sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                    BinaryTree newBranch = binaryTree.getRight();
                    return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
                }
            }
            if(binaryTree.getRight().getLeft() != null || binaryTree.getRight().getRight() != null){
                if(binaryTree.getRight().getLeft() != null){
                    sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                    BinaryTree newBranch = binaryTree.getLeft();
                    return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
                }if(binaryTree.getRight().getRight() != null){
                    sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                    BinaryTree newBranch = binaryTree.getRight();
                    return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
                }
            }
        } else if (binaryTree.getRight() != null && binaryTree.getLeft() == null) {
            if(binaryTree.getRight().getLeft() != null){
                sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                BinaryTree newBranch = binaryTree.getLeft();
                return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
            }if(binaryTree.getRight().getRight() != null){
                sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                BinaryTree newBranch = binaryTree.getRight();
                return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
            }
        } else if (binaryTree.getLeft() != null  && binaryTree.getRight() == null) {
            if(binaryTree.getLeft().getLeft() != null){
                sumOfValues = sumOfValues + binaryTree.getLeft().getValue();
                BinaryTree newBranch = binaryTree.getLeft();
                return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
            }if(binaryTree.getLeft().getRight() != null){
                sumOfValues = sumOfValues + binaryTree.getRight().getValue();
                BinaryTree newBranch = binaryTree.getRight();
                return travelIntoTheBinaryTreeAndSumValues(newBranch, sumOfValues);
            }
        }
        return sumOfValues;
    }

    public static BinaryTree generateHardcodedBinaryTree(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(5);
        int value = new Random().nextInt(20);
        binaryTree.addLeft(3);
        binaryTree.addRight(7);
        BinaryTree firstLeftLevel = binaryTree.getLeft();
        BinaryTree firstRightLevel = binaryTree.getRight();

        firstLeftLevel.addLeft(2);
        firstLeftLevel.addRight(4);
        firstRightLevel.addLeft(6);
        firstRightLevel.addRight(9);

        BinaryTree secondLeftLeftLevel = firstLeftLevel.getLeft();

        BinaryTree secondRightRightLevel = firstRightLevel.getRight();

        secondLeftLeftLevel.addLeft(1);
        secondRightRightLevel.addRight(12);
        secondRightRightLevel.addLeft(8);

        return binaryTree;
    }


}
