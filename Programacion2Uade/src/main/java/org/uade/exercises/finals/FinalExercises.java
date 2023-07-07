package org.uade.exercises.finals;

import org.uade.adt.Dictionary;
import org.uade.adt.Graph;
import org.uade.dynamic.GenericDictionary;
import org.uade.dynamic.GenericSet;

public class FinalExercises {

    public static void main(String[] args) {
        AdjacencyMatrix matrix = AdjacencyMatrix.generateAndaddValuesToMatrix();
        matrix.print();
        System.out.println("Is the graph directed and no directed?: " + verifyIfIsDirectedAndNoDirected(matrix));
        System.out.println();
        AdjacencyMatrix matrixWithRecursiveNodes = AdjacencyMatrix.generateAdjacentMatrixWithRecursiveNodes();
        matrixWithRecursiveNodes.print();
        System.out.println("The matrix has recursive vectors in all the nodes? " + verifyIfAllTheNodesHasAnRecursiveVertex(matrixWithRecursiveNodes));
        System.out.println("The matrix has recursive vectors in all the nodes? " + verifyIfAllTheNodesHasAnRecursiveVertex(matrix));
        System.out.println();
        System.out.println("The count of input and output vectors per node is: " + numberOfEntryAndOutVectorsPerGraphNode(matrix));

    }

    /**
     * Verificar si el grafo es dirigido y no dirigido al mismo tiempo
     */

    public static boolean verifyIfIsDirectedAndNoDirected(AdjacencyMatrix matrix) {
        boolean isDirectedAndNoDirected = travelTheAdjacencyMatrixAndValidateDirectedAndNoDirected(matrix);
        return isDirectedAndNoDirected;
    }

    public static boolean travelTheAdjacencyMatrixAndValidateDirectedAndNoDirected(AdjacencyMatrix matrix) {
        int directedConnections = 0;
        int noDirectedConnections = 0;
        for (int i = 0; i < matrix.getMatrix()[0].length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                if (matrix.getMatrix()[i][j] > 1) {
                    directedConnections += 1;
                } else if (matrix.getMatrix()[i][j] == 1) {
                    noDirectedConnections += 1;
                }
            }
        }

        if (directedConnections >= 1 && noDirectedConnections >= 1) {
            return true;
        }

        return false;
    }

    /**
     * Verificar si todos los nodos del grafo tienen un camino reflexivo
     */

    public static boolean verifyIfAllTheNodesHasAnRecursiveVertex(AdjacencyMatrix matrix) {
        boolean allTheNodesAreRecursive = allTheNodesAreRecursive(matrix);
        return allTheNodesAreRecursive;
    }

    public static boolean allTheNodesAreRecursive(AdjacencyMatrix matrix) {
        int countOfNodes = matrix.getMatrix().length;
        int recursiveNodes = 0;
        for (int i = 0; i < matrix.getMatrix()[0].length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                if (i == j && matrix.getMatrix()[i][j] > 0) {
                    recursiveNodes += 1;
                }
            }
        }

        if (recursiveNodes == countOfNodes) {
            return true;
        }

        return false;
    }

    /**
     * Realizar una funcion que cuente el numero de vectores de entrada y salida para cada nodo
     */

    public static Dictionary numberOfEntryAndOutVectorsPerGraphNode(AdjacencyMatrix matrix) {
        Dictionary nodesWithVectors = travelIntoMatrixAndGetTheNodesConnections(matrix);
        return nodesWithVectors;
    }

    public static Dictionary travelIntoMatrixAndGetTheNodesConnections(AdjacencyMatrix matrix) {
        Dictionary nodesWithVectors = new Dictionary();
        nodesWithVectors = outputVectorsPerNode(matrix, nodesWithVectors);
        nodesWithVectors = inputVectorsPerNode(matrix,nodesWithVectors);
        return nodesWithVectors;
    }

    public static Dictionary outputVectorsPerNode(AdjacencyMatrix matrix, Dictionary dictionary) {
        //Initiate the dictionary in 0
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            dictionary.add(i, 0);
        }
        //first I travel node per node and add the number of output vectors per node (recursive node counts * 2)
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            for (int j = 0; j < matrix.getMatrix().length; j++) {
                if (i == j && matrix.getMatrix()[i][j] > 0) {
                    dictionary.add(i, dictionary.getValue(i) + 2);
                } else if (matrix.getMatrix()[i][j] > 0) {
                    dictionary.add(i, dictionary.getValue(i) + 1);
                }
            }
        }
        return dictionary;
    }

    public static Dictionary inputVectorsPerNode(AdjacencyMatrix matrix, Dictionary dictionary) {
        //travel into columns of the matrix, because are the input vectors to the node
        for (int i = 0; i < matrix.getMatrix()[0].length - 1; i++) {
            for (int j = 0; j < matrix.getMatrix().length; j++) {
                if (matrix.getMatrix()[i][j] > 0 && i != j) {
                    dictionary.add(i, dictionary.getValue(i) + 1);
                }
            }
        }
        return dictionary;
    }

}
