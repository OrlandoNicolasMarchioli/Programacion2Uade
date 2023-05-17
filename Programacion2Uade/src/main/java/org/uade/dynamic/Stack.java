package org.uade.dynamic;

import org.uade.adt.definitions.IStack;

import java.util.Arrays;

public class Stack implements IStack {

    private int[] array;
    private int count;

    public Stack() {
        this.array = new int[10];
        this.count = 0;
    }

    public int[] getArray() {
        return array;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public void add(int a) {
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getTop() {
        return this.array[count - 1];
    }


    @Override
    public String toString() {
        return "Stack{" +
                "array=" + Arrays.toString(array) +
                ", count=" + count +
                '}';
    }
}
