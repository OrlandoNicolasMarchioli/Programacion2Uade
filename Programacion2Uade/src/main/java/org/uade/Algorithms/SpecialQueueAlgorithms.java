package org.uade.Algorithms;

import org.uade.adt.SpecialQueue;
import org.uade.adt.Stack;

public class SpecialQueueAlgorithms {

    public static int calculateSpecialQueueCount(SpecialQueue queue) {
        int count = 0;
        while (!queue.isEmpty()) {
            queue.getTop();
            queue.remove();
            count++;
        }
        return count;
    }

    public static SpecialQueue saveSpecialQueueInstance(SpecialQueue queue) {
        SpecialQueue copy = new SpecialQueue();
        SpecialQueue aux = new SpecialQueue();
        while (!queue.isEmpty()) {
            aux.add(queue.getTop());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.getTop());
            copy.add(aux.getTop());
            aux.remove();
        }
        return copy;
    }

    public static Stack[] specialQueueToArray(SpecialQueue queue) {
        Stack[] array = new Stack[10];
        int count = 0;
        while (!queue.isEmpty()) {
            array[count] = queue.getTop();
            queue.remove();
            count++;
        }
        return array;
    }

    public static int[] SpecialQueueOfIntegersToArray(SpecialQueue queue) {
        int[] array = new int[0];
        int count = 0;
        SpecialQueue queueToPassValues = saveSpecialQueueInstance(queue);

        while (!queue.isEmpty()) {
            array[count] = queue.getTop().getTop();
            queue.remove();
        }
        queue = queueToPassValues;
        return array;
    }
}
