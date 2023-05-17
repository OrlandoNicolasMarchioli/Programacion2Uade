package org.uade.dynamic;

import org.uade.adt.definitions.ISpecialQueue;
import org.uade.adt.Stack;

import java.util.Arrays;

public class SpecialQueue implements ISpecialQueue {

    private Stack[] array;

    private int count;

    public SpecialQueue() {
        this.array = new Stack[10000];
        this.count = 0;
    }


    @Override
    public void add(Stack a) {
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        Stack newArray[] = new Stack[this.array.length - 1];
        for (int i = 1; i < this.array.length; i++) {
            newArray[i - 1] = this.array[i];
        }
        this.count --;
        this.array = newArray;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public Stack getTop() {
        return this.array[0];
    }

    public int getCount() {
        return count;
    }

    public Stack[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "SpecialRow{" +
                "array=" + Arrays.toString(array) +
                ", count=" + count +
                '}';
    }

    public void setArray(Stack[] array) {
        this.array = array;
    }

}
