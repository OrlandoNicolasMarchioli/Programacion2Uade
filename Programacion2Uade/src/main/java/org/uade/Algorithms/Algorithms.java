package org.uade.Algorithms;

import org.uade.adt.SpecialQueue;
import org.uade.adt.Stack;
import org.uade.dynamic.GenericSet;
import org.uade.dynamic.GenericStack;

import java.util.ArrayList;
import java.util.List;

public class Algorithms {
    public static final int STACK_SIZE = 10;

    public static GenericStack<String> revertStack(GenericStack<String> stack) {
        GenericStack<String> stackReverted = new GenericStack<>();
        while (stack.getFirst() != null) {
            stackReverted.add(stack.getTop());
            stack.remove();
        }

        return stackReverted;
    }

    public static GenericStack<GenericSet> copySet(GenericSet set) {
        GenericSet setCopied = copy(set);
        GenericStack<GenericSet> stackOfSets = new GenericStack<>();
        stackOfSets.add(set);
        stackOfSets.add(setCopied);

        return stackOfSets;
    }

    public static GenericSet<Integer> copy(GenericSet<Integer> set) {
        GenericSet<Integer> copy = new GenericSet<>();
        GenericSet<Integer> aux = new GenericSet<>();
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
        while (!queue.isEmpty()) {
            queue.getTop();
            queue.remove();
            count++;
        }
        return count;
    }
}
