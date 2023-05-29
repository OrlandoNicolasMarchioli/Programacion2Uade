package org.uade.tpo.exercise1;

import org.uade.adt.SpecialQueue;
import org.uade.adt.Stack;

import java.util.ArrayList;
import java.util.List;

public class Exercise1 {

    private static int STACK_SIZE = 10;

    /**
     * 1-a Desarrolle una función que reciba una instancia de QueueOfStacks, y calcule su traza.
     *
     * @param specialQueque
     * @return trace of special queque array
     */
    public static int calculateTrace(SpecialQueue specialQueque) {
        int traceValue = 0;
        SpecialQueue specialQueueBackUp = saveSpecialQueueInstance(specialQueque);
        Stack[] stacks = specialQueueToArray(specialQueque);
        Stack stackBackUp = saveSpecialStackInstance(stacks[0]);
        int stackLength = calculateStackCount(stacks[0]);
        stacks[0] = stackBackUp;
        specialQueque = specialQueueBackUp;
        for (int i = 0; i < stackLength; i++) {
            for (int j = 0; j < stacks.length; j++) {
                int count = 0;
                if (i == j) {
                    while (count != j) {
                        stacks[i].getTop();
                        stacks[i].remove();
                        count++;
                    }
                    traceValue = traceValue + stacks[i].getTop();
                }
            }
        }

        return traceValue;
    }

    /**
     * 1-b Desarrolle una función que reciba una instancia de QueueOfStacks, y devuelva su traspuesta.
     *
     * @param specialQueque
     * @return transposed of special queque array
     */

    public static List<Stack> generateListOfStacksFromSpecialQueque(SpecialQueue specialQueque) {
        List<Stack> stacks = new ArrayList<>();
        SpecialQueue specialQueueBackup = saveSpecialQueueInstance(specialQueque);
        int specialQueueCount = calculateSpecialQueueCount(specialQueque);
        specialQueque = specialQueueBackup;
        for (int i = 0; i < specialQueueCount; i++) {
            Stack stack = new Stack();
            stacks.add(stack);
        }
        return stacks;
    }

    public static List<Stack> generateTransposed(SpecialQueue specialQueque) {
        SpecialQueue specialQueueBackup = saveSpecialQueueInstance(specialQueque);
        SpecialQueue specialQueueDoubleBackUp = saveSpecialQueueInstance(specialQueque);
        Stack[] specialQuequeStack = specialQueueToArray(specialQueque);
        specialQueque = saveSpecialQueueInstance(specialQueueBackup);
        //Generate an empty matrix
        List<Stack> stacksTransposed = generateListOfStacksFromSpecialQueque(specialQueque);
        specialQueque = specialQueueDoubleBackUp;
        int count = calculateSpecialQueueCount(specialQueueBackup);
        for (int i = 0; i < count; i++) {
            int counter = 0;

            while (stacksTransposed.get(i) != null && counter < stacksTransposed.size()) {
                int basePosition = 0;
                stacksTransposed.get(basePosition + counter).add(specialQuequeStack[i].getTop());
                counter++;
            }

        }

        return stacksTransposed;
    }

    /**
     * 1-c Desarrolle una función que reciba dos instancias de QueueOfStacks y devuelva una nueva instancia de
     * QueueOfStacks que represente la suma matricial.
     *
     * @return sum of special queques arrays
     * @params specialQueque1, specialQueque2
     */

    public static SpecialQueue sumOfQuequeArrays(SpecialQueue specialQueque1, SpecialQueue specialQueque2) {
        SpecialQueue specialQueue1BackUp = saveSpecialQueueInstance(specialQueque1);
        List<Stack> sumOfSpecialQueques = generateListOfStacksFromSpecialQueque(specialQueque1);
        specialQueque1 = specialQueue1BackUp;
        SpecialQueue specialQueue2BackUp = saveSpecialQueueInstance(specialQueque2);
        SpecialQueue specialQueueSecondBackUp = saveSpecialQueueInstance(specialQueue1BackUp);
        Stack[] stacksFromSpecialQueque1 = specialQueueToArray(specialQueque1);
        Stack[] stacksFromSpecialQueque2 = specialQueueToArray(specialQueque2);
        int specialQueuesSize = sumOfSpecialQueques.size();

        specialQueque1 = specialQueueSecondBackUp;
        specialQueque2 = specialQueue2BackUp;
        Stack stackBackUp = saveSpecialStackInstance(stacksFromSpecialQueque1[0]);
        int stackCount = calculateStackCount(stacksFromSpecialQueque1[0]);
        stacksFromSpecialQueque1[0] = stackBackUp;
        try {
            if (stacksFromSpecialQueque1.length == stacksFromSpecialQueque2.length) {
                for (int i = 0; i < specialQueuesSize; i++) {
                    int counter = 0;
                    while (counter < stackCount) {
                        sumOfSpecialQueques.get(i).add(stacksFromSpecialQueque1[i].getTop() + stacksFromSpecialQueque2[i].getTop());
                        counter++;
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }

        SpecialQueue specialQuequeWithSum = new SpecialQueue();

        for (int i = 0; i < sumOfSpecialQueques.size(); i++) {
            specialQuequeWithSum.add(sumOfSpecialQueques.get(i));
        }

        return specialQuequeWithSum;
    }

    public static int[] stackToArray(Stack stack) {
        int[] array = new int[0];
        int count = 0;
        Stack stackToPassValues = saveSpecialStackInstance(stack);
        while (!stack.isEmpty()) {
            stackToPassValues.add(stack.getTop());
            stack.remove();
        }
        stack = stackToPassValues;
        return array;
    }

    public static int[] SpecialQueueToArray(SpecialQueue queue) {
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


    public static int calculateStackCount(Stack stack) {
        int count = 0;
        Stack stackBackup = saveSpecialStackInstance(stack);
        while (!stack.isEmpty()) {
            stack.getTop();
            stack.remove();
            count++;
        }
        stack = stackBackup;
        return count;
    }

    public static Stack[] specialQueueToArray(SpecialQueue queue) {
        Stack[] array = new Stack[STACK_SIZE];
        int count = 0;
        while (!queue.isEmpty()) {
            array[count] = queue.getTop();
            queue.remove();
            count++;
        }
        return array;
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

    public static Stack saveSpecialStackInstance(Stack stack) {
        Stack copy = new Stack();
        Stack aux = new Stack();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            stack.add(aux.getTop());
            copy.add(aux.getTop());
            aux.remove();
        }
        return copy;
    }

    public static int calculateSpecialQueueCount(SpecialQueue queue) {
        int count = 0;
//        SpecialQueue backUp = saveSpecialQueueInstance(queue);
        while (!queue.isEmpty()) {
            queue.getTop();
            queue.remove();
            count++;
        }
//        queue = backUp;
        return count;
    }

    public static SpecialQueue initiateQuequeMatrix() {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        SpecialQueue matrix = new SpecialQueue();

        stack1.add(1);
        stack1.add(1);
        stack1.add(1);

        stack2.add(2);
        stack2.add(2);
        stack2.add(2);

        stack3.add(3);
        stack3.add(3);
        stack3.add(3);

        matrix.add(stack1);
        matrix.add(stack2);
        matrix.add(stack3);

        return matrix;
    }


}
