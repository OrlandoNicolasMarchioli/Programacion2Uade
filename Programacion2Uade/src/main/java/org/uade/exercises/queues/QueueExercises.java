package org.uade.exercises.queues;

import org.uade.Algorithms.QueueAlgorithms;
import org.uade.dynamic.GenericQueue;

import java.util.List;

public class QueueExercises {

    public static void main(String[] args) {
        GenericQueue<Integer> queue = generateQueue();
        GenericQueue<Integer> queueWithValue = insertValueInTheMiddleOfTheQueue(queue, 10);
        System.out.println(queueWithValue);
    }

    /**
     * Ejercicio 1
     * Generar un algoritmo que agregue un elemento en la mitad de una cola
     */

    private static GenericQueue<Integer> insertValueInTheMiddleOfTheQueue(GenericQueue<Integer> queue, int valueToInsert) {
        GenericQueue<Integer> queueBackUp = QueueAlgorithms.saveQueueInstance(queue);
        int queueCount = QueueAlgorithms.calculateGenericQueueCount(queue);
        queue = queueBackUp;
        List<Integer> listOfValues = QueueAlgorithms.specialQueueToArray(queue);
        for (int i = 0; i < listOfValues.size(); i++) {
            if (i == queueCount / 2 && queueCount % 2 == 0) {
                queue.add(valueToInsert);
            }
            if (i == queueCount / 2 && queueCount % 2 != 0) {
                queue.add(valueToInsert);
            }
            queue.add(listOfValues.get(i));
        }
        return queue;
    }

    private static GenericQueue<Integer> generateQueue() {
        GenericQueue<Integer> queue = new GenericQueue<>();
        queue.add(1);
        queue.add(1);
        queue.add(4);
        queue.add(1);
        queue.add(5);
        queue.add(2);
        queue.add(5);
        queue.add(6);
        return queue;
    }
}
