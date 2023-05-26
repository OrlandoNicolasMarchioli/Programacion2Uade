package org.uade.exercises.trees;

import org.uade.adt.BinaryTree;
import org.uade.dynamic.GenericBinaryTree;

import static org.uade.Algorithms.TreeAlgorithms.*;

public class TreeExercises {
    public static void main(String[] args) {
        BinaryTree binaryTree = generateHardcodedBinaryTree();
        System.out.println(binaryTree);
        System.out.println("The sum of the binary tree nodes is: " + sumBinaryTreeNodes(binaryTree));
        System.out.println("The multiplication of the sum of all the values of the nodes by the smallest value of the nodes is: ");
    }

    /**
     * 1. Ejercicio 1
     * Desarrollar una funcion que reciba un AB y devuelva la suma de sus nodos
     * internos (todo nodo que no es hoja). Al resultado multiplicarlo por el menor
     * valor que se puede encontrar en una de las hojas del arbol.
     */

    public static int sumBinaryTreeNodes(BinaryTree binaryTree) {
        int sumOfLeftNodeValues = 0;
        int sumOfRightNodeValues = 0;
        int rootValue = binaryTree.getValue();
        sumOfLeftNodeValues = travelIntoTheBinaryTreeAndSumValues(binaryTree.getLeft(), binaryTree.getLeft().getValue());
        sumOfRightNodeValues = travelIntoTheBinaryTreeAndSumValues(binaryTree.getRight(), binaryTree.getRight().getValue());
        int total = rootValue + sumOfRightNodeValues + sumOfLeftNodeValues;

        return total;
    }


}
