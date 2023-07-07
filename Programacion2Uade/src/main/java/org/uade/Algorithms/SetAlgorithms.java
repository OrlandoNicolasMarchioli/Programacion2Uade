package org.uade.Algorithms;

import org.uade.adt.Set;
import org.uade.adt.Stack;
import org.uade.adt.definitions.ISet;
import org.uade.adt.definitions.IStack;
import org.uade.dynamic.GenericSet;

import java.util.ArrayList;
import java.util.List;

public class SetAlgorithms {


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

    public static ISet copy(ISet set) {
        ISet copy = new Set();
        ISet aux = new Set();
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

    public static int calculateStackCount(GenericSet<Integer> set) {
        int count = 0;
        while (!set.isEmpty()) {
            int value = set.choose();
            set.remove(value);
            count++;
        }
        return count;
    }

    public static List<Integer> setToArray(GenericSet<Integer> set) {
        List<Integer> array = new ArrayList();
        while (!set.isEmpty()) {
            int value = set.choose();
            array.add(value);
            set.remove(value);
        }
        return array;
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
}
