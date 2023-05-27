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
        int high = 0;
        high = travelIntoTheBinaryTreeAndGetTheHigh(binaryTree, high);
        return high + 1;
    }

    /**
     * 3. Ejercicio 3
     * Desarrollar una funcion que reciba un AB y devuelva verdadero si es un arbol perfecto.
     */


}
