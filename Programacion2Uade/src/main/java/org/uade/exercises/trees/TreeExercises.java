package org.uade.exercises.trees;

import org.uade.adt.BinaryTree;

import static org.uade.Algorithms.TreeAlgorithms.*;

public class TreeExercises {
    public static void main(String[] args) {
        BinaryTree binaryTree = generateHardcodedBinaryTree();
        System.out.println(binaryTree);
        int sumOfNodeValues = sumBinaryTreeNodes(binaryTree);
        System.out.println("The sum of the binary tree nodes is: " + sumOfNodeValues);
        int lowerNodeValues = getTheLowerValueOfTheTree(binaryTree);
        System.out.println("The multiplication of the sum of all the values of the nodes by the smallest value of the nodes is: " + sumOfNodeValues * lowerNodeValues);
        System.out.println("The high of the tree is: " + getBinaryTreeHigh(binaryTree));
        System.out.println();
        BinaryTree completeBinaryTree = generateHardcodedCompleteBinaryTree();
        System.out.println("The binary tree is: " + completeBinaryTree);
        System.out.println("The binary tree is complete?: " + binaryTreeIsComplete(completeBinaryTree));
    }

    /**
     * 1. Ejercicio 1
     * Desarrollar una funcion que reciba un AB y devuelva la suma de sus nodos
     * internos (todo nodo que no es hoja). Al resultado multiplicarlo por el menor
     * valor que se puede encontrar en una de las hojas del arbol.
     */

    private static int sumBinaryTreeNodes(BinaryTree binaryTree) {
        int sumOfLeftNodeValues = 0;
        int sumOfRightNodeValues = 0;
        int rootValue = binaryTree.getValue();
        sumOfLeftNodeValues = travelIntoTheBinaryTreeAndSumValues(binaryTree.getLeft(), binaryTree.getLeft().getValue());
        sumOfRightNodeValues = travelIntoTheBinaryTreeAndSumValues(binaryTree.getRight(), binaryTree.getRight().getValue());
        return rootValue + sumOfRightNodeValues + sumOfLeftNodeValues;
    }

    private static int getTheLowerValueOfTheTree(BinaryTree binaryTree) {
        int firstLowerValue = binaryTree.getLeft().getValue();
        int lowerValue = travelInsideTheTreeToGetTheLowerValue(binaryTree.getLeft(), firstLowerValue);
        return lowerValue;
    }

    /**
     * 2. Ejercicio 2
     * Desarrollar una funcion que reciba un AB y devuelva la altura maxima del mismo.
     */

    private static int getBinaryTreeHigh(BinaryTree binaryTree) {
        int high = 1;
        int highOnLeftSide = travelIntoTheBinaryTreeAndGetTheHigh(binaryTree.getLeft(), high);
        int highOnRightSide = travelIntoTheBinaryTreeAndGetTheHigh(binaryTree.getRight(), high);
        if (highOnLeftSide > highOnRightSide) {
            return highOnLeftSide + high;
        } else if (highOnRightSide > highOnLeftSide) {
            return highOnLeftSide + high;
        }
        return high + highOnLeftSide;
    }

    /**
     * 3. Ejercicio 3
     * Desarrollar una funcion que reciba un AB y devuelva verdadero si es un arbol esta completo (todos sus nodos tienen dos hijos).
     */

    private static boolean binaryTreeIsComplete(BinaryTree binaryTree) {
        boolean isComplete = true;

        boolean leftBranchIsComplete = travelIntoTheBinaryTreeAndShowIfIsComplete(binaryTree.getLeft(), isComplete);
        boolean rightBranchIsComplete = travelIntoTheBinaryTreeAndShowIfIsComplete(binaryTree.getRight(), isComplete);
        if (!leftBranchIsComplete || !rightBranchIsComplete) {
            return false;
        }

        return isComplete;
    }


}
