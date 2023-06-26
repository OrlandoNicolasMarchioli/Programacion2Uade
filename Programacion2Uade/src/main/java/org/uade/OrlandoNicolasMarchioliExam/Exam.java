package org.uade.OrlandoNicolasMarchioliExam;

import org.uade.adt.BinaryTree;
import org.uade.adt.definitions.IBinaryTree;
import org.uade.adt.definitions.ISet;
import org.uade.OrlandoNicolasMarchioliExam.dictionary.Dictionary;
import org.uade.OrlandoNicolasMarchioliExam.dictionary.Set;
import org.uade.OrlandoNicolasMarchioliExam.queues.PriorityQueue;

import java.util.ArrayList;
import java.util.List;

public class Exam {
    public static void main(String[] args) {
        //Exercise 1B
        BinaryTree binaryTree = generateHardcodedBinaryTree();
        System.out.println(binaryTree);
        int sumOfNodeValues = sumBinaryTreeNodes(binaryTree);
        System.out.println("The sum of the binary tree nodes is: " + sumOfNodeValues);

        //Exercise 2A
        PriorityQueue firstQueue = generatePriorityQueue();
        PriorityQueue secondQueue = generatePriorityQueue();
        System.out.println("The first queue is: " + firstQueue);
        System.out.println("The second queue is: " + secondQueue);
        System.out.println("The queues combined are: " + joinPriorityQueues(firstQueue, secondQueue));

        //Exercise 2B
        Dictionary firstDictionary = firstDictionary();
        Dictionary secondDictionary = secondDictionary();
        System.out.println("The dictionarys are" + firstDictionary + " and " + secondDictionary);
        System.out.println("The dictionary keys are different?: " + theDictionaryKeysAreDifferent(firstDictionary,secondDictionary));
    }

    /**
     * Preconditions: The binary tree has to be initiated;
     *
     * @param binaryTree
     * @return sum of all values inside binary nodes
     */
    private static int sumBinaryTreeNodes(BinaryTree binaryTree) {
        int sumOfLeftNodeValues;
        int sumOfRightNodeValues;
        int rootValue = binaryTree.getValue();
        //Travel into the left branch
        sumOfLeftNodeValues = getSumOfValues(binaryTree.getLeft(), binaryTree.getLeft().getValue());
        sumOfRightNodeValues = getSumOfValues(binaryTree.getRight(), binaryTree.getRight().getValue());

        return rootValue + sumOfLeftNodeValues + sumOfRightNodeValues;
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

    private static BinaryTree generateHardcodedBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.create(5);
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

    /**
     * Preconditions: Both queues have to have the same count of values;
     *
     * @param firstQueue
     * @param secondQueue
     * @return
     */
    private static PriorityQueue joinPriorityQueues(PriorityQueue firstQueue, PriorityQueue secondQueue) {
        PriorityQueue queueCombined = new PriorityQueue();
        PriorityQueue firstQueueBackUp = saveQueueInstance(firstQueue);
        PriorityQueue secondQueueBackUp = saveQueueInstance(secondQueue);
        List<Integer> firstQueuePriorities = new ArrayList<>();
        while (!firstQueue.isEmpty()) {
            queueCombined.add(firstQueue.getFirst(), firstQueue.getPriority());
            firstQueue.remove();
        }
        firstQueue = firstQueueBackUp;
        firstQueuePriorities = getQueuePrioritiesInOrder(firstQueue);
        int maxFirstQueuePriority = getMaxValueOfList(firstQueuePriorities);
        PriorityQueue secondFirstQueueBackUp = saveQueueInstance(firstQueue);
        firstQueue = secondFirstQueueBackUp;
        while (!secondQueue.isEmpty()) {
            queueCombined.add(2 * secondQueue.getPriority() + maxFirstQueuePriority, secondQueue.getPriority());
            secondQueue.remove();
        }
        secondQueue = secondQueueBackUp;
        return queueCombined;
    }

    private static List<Integer> getQueuePrioritiesInOrder(PriorityQueue queue) {
        List<Integer> priorities = new ArrayList<>();
        while (!queue.isEmpty()) {
            priorities.add(queue.getPriority());
            queue.remove();
        }
        return priorities;
    }

    private static int getMaxValueOfList(List<Integer> integers) {
        int maxValue = 0;
        for (int i = 0; i < integers.size(); i++) {
            if (integers.get(i) > maxValue) {
                maxValue = integers.get(i);
            }
        }
        return maxValue;
    }

    private static PriorityQueue generatePriorityQueue() {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.add(1, 1);
        priorityQueue.add(2, 2);
        priorityQueue.add(3, 3);
        return priorityQueue;
    }

    public static PriorityQueue saveQueueInstance(PriorityQueue queue) {
        PriorityQueue copy = new PriorityQueue();
        PriorityQueue aux = new PriorityQueue();
        while (!queue.isEmpty()) {
            aux.add(queue.getFirst(), queue.getPriority());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.getFirst(), aux.getPriority());
            copy.add(aux.getFirst(), aux.getPriority());
            aux.remove();
        }
        return copy;
    }

    private static boolean theDictionaryKeysAreDifferent(Dictionary firstDictionary,Dictionary secondDictionary){
        boolean areDifferent = true;
        ISet firstDictionaryKeys = firstDictionary.getKeys();
        ISet secondDictionarykeys = secondDictionary.getKeys();
        List<Integer> firstKeyList = setToArray(firstDictionaryKeys);
        List<Integer> secondKeyList = setToArray(secondDictionarykeys);
        for (int i = 0; i < firstKeyList.size(); i++) {
            if(secondKeyList.contains(firstKeyList.get(i))){
                return false;
            }
        }
        return areDifferent;
    }

    public static List<Integer> setToArray(ISet set) {
        List<Integer> array = new ArrayList();
        while (!set.isEmpty()) {
            int value = set.choose();
            array.add(value);
            set.remove(value);
        }
        return array;
    }
    public static Set copy(ISet set) {
        Set copy = new Set();
        Set aux = new Set();
        while (!set.isEmpty()) {
            int value = set.choose();
            aux.add(value);
            set.remove(value);
        }
        while (!aux.isEmpty()) {
            int value = aux.choose();
            set.add(value);
            copy.add(value);
            aux.remove(value);
        }
        return copy;
    }

    private static Dictionary firstDictionary() {
        Dictionary dictionary = new Dictionary();
        dictionary.add(1, 2);
        dictionary.add(2, 3);
        dictionary.add(3, 4);
        dictionary.add(4, 5);
        return dictionary;
    }

    private static Dictionary secondDictionary() {
        Dictionary dictionary = new Dictionary();
        dictionary.add(6, 3);
        dictionary.add(7, 10);
        dictionary.add(8, 44);
        dictionary.add(9, 7);
        return dictionary;
    }

}
