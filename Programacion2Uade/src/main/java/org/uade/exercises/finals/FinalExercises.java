package org.uade.exercises.finals;

import org.uade.adt.BinaryTree;
import org.uade.adt.Dictionary;
import org.uade.adt.definitions.IBinaryTree;

import static org.uade.Algorithms.TreeAlgorithms.generateHardcodedBinaryTree;

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
        System.out.println();
        BinaryTree tree = generateHardcodedBinaryTree();
        System.out.println("The dictionary of node ancestors is: " + getAllTheNodeAncestors(tree));

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
        boolean isRecursive = false;
        for (int i = 0; i < matrix.getMatrix()[0].length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                if (i == j && matrix.getMatrix()[i][j] > 0) {
                    isRecursive = true;
                }
            }
        }

        return isRecursive;
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
        nodesWithVectors = inputVectorsPerNode(matrix, nodesWithVectors);
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

    /**
     * Dado un nodo n1, decimos que n2 es ancestro de n1 si n1 esta en alguna
     * de las ramas de n2. Desarrolle un metodo estatico que reciba un ABB
     * y devolver un Diccionario Simple donde cada clave del diccionario es un
     * nodo que no es hoja, y como valor asociado a la clave la suma de los
     * ancentros de este nodo.
     */

    public static Dictionary getAllTheNodeAncestors(BinaryTree binaryTree) {
        int rootNode = binaryTree.getValue();

        Dictionary dictionary = new Dictionary();
        BinaryTree leftBinaryTree = binaryTree.getLeft();
        BinaryTree rightBinaryTree = binaryTree.getRight();
        dictionary = getAncestorsPerNode(leftBinaryTree, dictionary);
        dictionary = getAncestorsPerNode(rightBinaryTree, dictionary);
        int leftSum = dictionary.getValue(binaryTree.getLeft().getValue());
        int rightSum = dictionary.getValue(binaryTree.getRight().getValue());
        int sum = binaryTree.getValue() + leftSum + rightSum + binaryTree.getLeft().getValue() + binaryTree.getRight().getValue();
        dictionary.add(rootNode, sum);
        return dictionary;
    }

    public static Dictionary getAncestorsPerNode(BinaryTree tree, Dictionary dictionary) {
        if (tree.getLeft() != null && tree.getRight() == null) {
            dictionary.add(tree.getValue(), getSumOfValues(tree.getLeft(),tree.getLeft().getValue()));
            getAncestorsPerNode(tree.getLeft(), dictionary);
        }
        if (tree.getLeft() != null && tree.getRight() != null) {
            if (tree.getLeft().getLeft() != null) {
                dictionary.add(tree.getValue(), getSumOfValues(tree.getLeft(), tree.getLeft().getValue() + tree.getRight().getValue()));
                getAncestorsPerNode(tree.getLeft(), dictionary);
            }
            if (tree.getLeft().getRight() != null) {
                dictionary.add(tree.getValue(), getSumOfValues(tree.getLeft(), tree.getLeft().getValue() + tree.getRight().getValue()));
                getAncestorsPerNode(tree.getLeft(), dictionary);
            }
            if (tree.getRight().getRight() != null) {
                dictionary.add(tree.getValue(), getSumOfValues(tree.getRight(), tree.getLeft().getValue() + tree.getRight().getValue()));
                getAncestorsPerNode(tree.getLeft(), dictionary);
            }
            if (tree.getRight().getLeft() != null) {
                dictionary.add(tree.getValue(), getSumOfValues(tree.getRight(), tree.getLeft().getValue() + tree.getRight().getValue()));
                getAncestorsPerNode(tree.getLeft(), dictionary);
            }
        }
        if (tree.getRight() != null && tree.getLeft() == null) {
            dictionary.add(tree.getValue(),  getSumOfValues(tree.getRight(),tree.getRight().getValue()));
            getAncestorsPerNode(tree.getRight(), dictionary);
        }
        return dictionary;
    }
    public static int getSumOfValues(IBinaryTree binaryTree, int sumOfValues) {
        if (binaryTree.getLeft() != null) {
            sumOfValues = sumOfValues + binaryTree.getLeft().getValue();
            getSumOfValues(binaryTree.getLeft(), sumOfValues);
        }
        if (binaryTree.getRight() != null) {
            sumOfValues = sumOfValues + binaryTree.getRight().getValue();
            getSumOfValues(binaryTree.getRight(), sumOfValues);
        }
        return sumOfValues;
    }

}
