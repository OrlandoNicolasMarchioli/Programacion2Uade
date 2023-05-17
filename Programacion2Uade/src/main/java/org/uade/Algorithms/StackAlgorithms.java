package org.uade.Algorithms;

import org.uade.adt.Stack;
import org.uade.adt.definitions.IStack;
import org.uade.dynamic.GenericQueue;
import org.uade.dynamic.GenericStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StackAlgorithms {

    public static void print(IStack stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.getTop());
            stack.remove();
        }
    }

    public static IStack copy(IStack stack) {
        IStack copy = new Stack();
        IStack aux = new Stack();
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

    public static GenericStack<Integer> saveGenericStackInstance(GenericStack<Integer> stack) {
        GenericStack<Integer> copy = new GenericStack<>();
        GenericStack<Integer> aux = new GenericStack<>();
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

    public static void revert(IStack stack) {
        IStack aux = new Stack();
        IStack aux2 = new Stack();
        while (!stack.isEmpty()) {
            aux.add(stack.getTop());
            stack.remove();
        }
        while (!aux.isEmpty()) {
            aux2.add(aux.getTop());
            aux.remove();
        }
        while (!aux2.isEmpty()) {
            stack.add(aux2.getTop());
            aux2.remove();
        }
    }

    public static int calculateStackCount(Stack stack) {
        int count = 0;
        while (!stack.isEmpty()) {
            stack.getTop();
            stack.remove();
            count++;
        }
        return count;
    }

    public static int[] stackToArray(Stack stack) {
        int[] array = new int[0];
        Stack stackToPassValues = new Stack();
        while (!stack.isEmpty()) {
            stackToPassValues.add(stack.getTop());
            stack.remove();
        }
        return array;
    }

    public static List<Integer> genericStackToList(GenericStack<Integer> stack) {
        List<Integer> array = new ArrayList<>();
        while (!stack.isEmpty()) {
            array.add(stack.getTop());
            stack.remove();
        }
        return array;
    }

    public static GenericStack<Integer> generateGenericStackOfIntegers(int queueRange){
        GenericStack<Integer> stack = new GenericStack<>();
        for (int i = 0; i < queueRange; i++) {
            stack.add(new Random().nextInt(100));
        }
        return stack;
    }

}
