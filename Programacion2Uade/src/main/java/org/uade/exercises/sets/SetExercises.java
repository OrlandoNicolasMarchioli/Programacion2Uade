package org.uade.exercises.sets;

import org.uade.Algorithms.QueueAlgorithms;
import org.uade.Algorithms.SetAlgorithms;
import org.uade.Algorithms.StackAlgorithms;
import org.uade.dynamic.GenericQueue;
import org.uade.dynamic.GenericSet;
import org.uade.dynamic.GenericStack;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SetExercises {
    private static SetAlgorithms setAlgorithms;

    private static StackAlgorithms stackAlgorithms;

    private static QueueAlgorithms queueAlgorithms;

    public static void main(String[] args) {
        GenericSet<Integer> set1 = generateGenericSet(4);
        GenericSet<Integer> set2 = generateGenericSet(6);
        GenericSet<Integer> set1BackUp = setAlgorithms.copy(set1);
        GenericSet<Integer> set2BackUp = setAlgorithms.copy(set2);
        System.out.println("The sets are: " + set1 + set2);
        System.out.println("The symmetric difference between sets is: " + symmetricDifference(set1, set2));
        set1 = set1BackUp;
        set2 = set2BackUp;
        System.out.println();

        System.out.println("The sets are: " + set1() + set2());
        System.out.println("The sets are equals?: " + equalSets(set1(), set2()));

        System.out.println();
        System.out.println("The set is: " + set1() + set2());
        System.out.println("The set cardinality is: " + setCardinality(generateGenericSet(10)));

        System.out.println();

        System.out.println("The set between stack and queue is : " + generateSetWithStackAndQueue
                (stackAlgorithms.generateGenericStackOfIntegers(5), queueAlgorithms.generateGenericQueueOfIntegers(5)));

    }

    /**
     * Implementar la diferencia simétrica utilizando estos métodos.
     * Implementar la diferencia simétrica sin utilizarlos.
     * Implementar la igualdad entre conjuntos.
     * Calcular la cardinalidad del conjunto.
     * Generar el conjunto de elementos que están tanto en la Pila P y en la Cola C.
     * Determinar si los elementos de una Pila P son los mismos que los de una Cola C. No interesa el
     * orden ni si están repetidos o no.
     */

    public static GenericSet<Integer> symmetricDifference(GenericSet<Integer> set1, GenericSet<Integer> set2) {
        GenericSet<Integer> symmetricSet = new GenericSet<>();

        List<Integer> set1Values = setAlgorithms.setToArray(set1);
        List<Integer> set2Values = setAlgorithms.setToArray(set2);
        int count = 0;
        for (int i = 0; i < set1Values.size(); i++) {
            int value = set1Values.get(count);
            if (!set2Values.contains(value)) {
                symmetricSet.add(value);
            }
            count++;
        }
        for (int i = 0; i < set2Values.size(); i++) {
            int value = set2Values.get(i);
            if (!set1Values.contains(value)) {
                symmetricSet.add(value);
            }
            count++;
        }

        return symmetricSet;
    }

    public static boolean equalSets(GenericSet<Integer> set1, GenericSet<Integer> set2) {
        boolean areEquals = true;
        GenericSet<Integer> set1BackUp = setAlgorithms.copy(set1);
        GenericSet<Integer> set2BackUp = setAlgorithms.copy(set2);

        List<Integer> set1Values = setAlgorithms.setToArray(set1);
        List<Integer> set2Values = setAlgorithms.setToArray(set2);
        Collections.sort(set1Values);
        Collections.sort(set2Values);
        if (set1Values.size() == set2Values.size()) {
            for (int i = 0; i < set1Values.size(); i++) {
                if (set2Values.get(i) != set1Values.get(i)) {
                    areEquals = false;
                }
            }
        } else {
            areEquals = false;
        }
        set1 = set1BackUp;
        set2 = set2BackUp;
        return areEquals;
    }

    public static int setCardinality(GenericSet<Integer> set) {
        GenericSet<Integer> setBackUp = setAlgorithms.copy(set);
        int count = 0;
        while (!set.isEmpty()) {
            int value = set.choose();
            count++;
            set.remove(value);
        }
        set = setBackUp;
        return count;
    }

    public static GenericSet<Integer> generateSetWithStackAndQueue(GenericStack<Integer> stack, GenericQueue<Integer> queue) {
        GenericSet<Integer> set = new GenericSet<>();
        GenericQueue<Integer> queueBackUp = queueAlgorithms.saveQueueInstance(queue);
        GenericStack<Integer> stackBackUp = stackAlgorithms.saveGenericStackInstance(stack);
        List<Integer> queueValueList = queueAlgorithms.specialQueueToArray(queue);
        List<Integer> stackValueList = stackAlgorithms.genericStackToList(stack);
        for (int i = 0; i < queueValueList.size(); i++) {
            set.add(queueValueList.get(i));
        }
        for (int i = 0; i < stackValueList.size(); i++) {
            set.add(stackValueList.get(i));
        }
        stack = stackBackUp;
        queue = queueBackUp;
        return set;
    }

    public static GenericSet<Integer> generateGenericSet(int setRange) {
        GenericSet<Integer> set = new GenericSet<>();
        for (int i = 0; i < setRange; i++) {
            int randomValue = new Random().nextInt(101);
            set.add(randomValue);
        }

        return set;
    }

    public static GenericSet<Integer> set1() {
        GenericSet<Integer> set = new GenericSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        return set;
    }

    public static GenericSet<Integer> set2() {
        GenericSet<Integer> set = new GenericSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        return set;
    }


}
