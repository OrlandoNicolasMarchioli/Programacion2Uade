package org.uade.tpo.exercise2;

import org.uade.adt.*;
import org.uade.dynamic.GenericSet;
import org.uade.dynamic.GenericStack;

public class Exercise2 {

    /**
     * Ejercicio 2-1: Desarrolle una función que reciba un Stack genérico e invierta sus elementos.
     *
     * @return
     */

    public static GenericStack<String> revertStack(GenericStack<String> stack) {
        GenericStack<String> stackReverted = new GenericStack<>();
        while (stack.getFirst() != null) {
            stackReverted.add(stack.getTop());
            stack.remove();
        }

        return stackReverted;
    }

    /**
     * Ejercicio 2-2 2. Desarrolle una función que copie un Set genérico.
     *
     * @return stackOfSets
     */

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


    public static GenericStack<String> generateStack() {
        GenericStack<String> genericStack = new GenericStack<>();
        genericStack.add("Hello");
        genericStack.add("how");
        genericStack.add("you");
        genericStack.add("are");
        return genericStack;
    }

    public static GenericSet<Integer> generateSet() {
        GenericSet<Integer> set = new GenericSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(4);
        return set;
    }

    @Override
    public String toString() {
        return "Exercise2{}";
    }
}
