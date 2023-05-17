package org.uade.Algorithms;

import org.uade.adt.SpecialQueue;
import org.uade.adt.Stack;
import org.uade.dynamic.GenericQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QueueAlgorithms {
    public static int calculateGenericQueueCount(GenericQueue<Integer> queue) {
        int count = 0;
        while (!queue.isEmpty()) {
            queue.getFirst();
            queue.remove();
            count++;
        }
        return count;
    }

    public static GenericQueue<Integer> saveQueueInstance(GenericQueue<Integer> queue) {
        GenericQueue<Integer> copy = new GenericQueue<>();
        GenericQueue<Integer> aux = new GenericQueue<>();
        while (!queue.isEmpty()) {
            aux.add(queue.getFirst());
            queue.remove();
        }
        while (!aux.isEmpty()) {
            queue.add(aux.getFirst());
            copy.add(aux.getFirst());
            aux.remove();
        }
        return copy;
    }

    public static List<Integer> specialQueueToArray(GenericQueue<Integer> queue) {
        List<Integer> array = new ArrayList();
        int count = 0;
        while (!queue.isEmpty()) {
            array.add(queue.getFirst());
            queue.remove();
            count++;
        }
        return array;
    }

    public static GenericQueue<Integer> generateGenericQueueOfIntegers(int queueRange){
        GenericQueue<Integer> queue = new GenericQueue<>();
        for (int i = 0; i < queueRange; i++) {
            queue.add(new Random().nextInt(100));
        }
        return queue;
    }

}
