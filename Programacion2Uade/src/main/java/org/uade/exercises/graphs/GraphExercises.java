package org.uade.exercises.graphs;

import org.uade.Algorithms.SetAlgorithms;
import org.uade.adt.Graph;
import org.uade.adt.definitions.ISet;
import org.uade.adt.node.Node;
import org.uade.dynamic.Set;

import java.util.ArrayList;
import java.util.List;

public class GraphExercises {

    public static void main(String[] args) {
        /**
         * ejercicio 1
         */
        Graph graph = generateNewGraph();
        System.out.println("El grafo es: " + graph);
        System.out.println("Los indices reflexivos son: " + returnListOfReflexivesNodes(graph));

    }

    /**
     * Ejercicio 1
     * Sea M matriz de adyacencia de un grafo G devolver una lista con los índices de los nodos reflexivos de
     * la matriz
     */

    public static List<Integer> returnListOfReflexivesNodes(Graph graph) {
        List<Integer> reflexiveNodes = getReflexiveNodes(graph);

        return reflexiveNodes;
    }

    /**
     *
     * @param graph
     * @return
     */

//    public static boolean isUndirectedGraph(Graph graph){
//        boolean isUndirected = travelIntoGraphAndSearchConnections(graph);
//    }
//
//    public static boolean travelIntoGraphAndSearchConnections(Graph graph){
//        ISet graphNodeKeys = graph.nodes();
//        graph.
//    }

    public static List<Integer> getReflexiveNodes(Graph graph) {
        List<Integer> reflexiveNodeIndexes = new ArrayList<>();
        ISet nodesBackUp = SetAlgorithms.copy(graph.nodes());
        List<Integer> listOfNodeKeys = SetAlgorithms.setToArray(nodesBackUp);
        for (int i = 0; i < listOfNodeKeys.size(); i++) {
            int key = graph.nodes().choose();
            if(graph.edgeExists(key,key)){
                reflexiveNodeIndexes.add(key);
                graph.removeNode(key);
            }
        }
        return reflexiveNodeIndexes;
    }

    public static Graph generateNewGraph() {
        Graph graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.addEdge(1, 1, 1);
        graph.addEdge(2, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(3, 2, 4);
        graph.addEdge(3, 3, 1);
        graph.addEdge(4, 3, 3);
        graph.addEdge(3, 1, 1);
        graph.addEdge(4, 1, 2);
        graph.addEdge(4, 4, 2);
        graph.addEdge(5, 1, 3);
        graph.addEdge(5, 2, 4);

        return graph;
    }
}
