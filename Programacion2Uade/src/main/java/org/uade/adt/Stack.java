package org.uade.adt;

import org.uade.adt.definitions.IStack;

import java.util.Arrays;

public class Stack implements IStack {

    private final int[] array;
    private int count;

    public Stack() {
        this.array = new int[10];
        this.count = 0;
    }

    @Override
    public void add(int a) {
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if (count == 0) {
            System.out.println("Error, no se puede desapilar una pila vacia");
            return;
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getTop() {
        if (count == 0) {
            System.out.println("Error, no se puede obtener el tope de una pila vacia");
            return -1;
        }
        return this.array[this.count - 1];
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "array=" + Arrays.toString(array) +
                ", count=" + count +
                '}';
    }
}
