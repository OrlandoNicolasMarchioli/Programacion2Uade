package org.uade.adt;

import org.uade.adt.definitions.IQueue;

public class Queue implements IQueue {

    private final int[] array;
    private int count;

    public Queue() {
        this.array = new int[10000];
        this.count = 0;
    }
    @Override
    public void add(int a) {
        this.array[this.count] = a;
        this.count++;
    }

    @Override
    public void remove() {
        if(count == 0) {
            System.out.println("Error, no se puede desacolar una cola vacia");
            return;
        }
        for(int i = 0; i < this.array.length - 1; i++) {
            this.array[i] = this.array[i+1];
        }
        this.count--;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int getFirst() {
        if(count == 0) {
            System.out.println("Error, no se puede obtener el primero de una cola vacia");
            return -1;
        }
        return this.array[0];
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
}
