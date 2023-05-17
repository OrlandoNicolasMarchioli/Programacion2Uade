package org.uade.dynamic;

import org.uade.dynamic.definitions.IGenericSet;
import org.uade.dynamic.node.GenericNode;

import java.util.Objects;
import java.util.Random;

public class GenericSet<T> implements IGenericSet<T> {

    private GenericNode<T> first;
    private int count;

    @Override
    public void add(T a) {
        if (this.first == null) {
            this.first = new GenericNode(a, null);
            this.count++;
            return;
        }

        if (this.first.getValue() == a) {
            return;
        }

        GenericNode<T> candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
            if (candidate.getValue() == a) {
                return;
            }
        }
        candidate.setNext(new GenericNode<>(a, null));
        this.count++;
    }

    @Override
    public void remove(T a) {
        if (this.first == null || (this.first.getNext() == null && this.first.getValue() != a)) {
            return;
        }

        if (this.first != null && this.first.getNext() == null) {
            if (this.first.getValue() == a) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if (this.first.getValue() == a) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        GenericNode backup = this.first;
        GenericNode candidate = this.first.getNext();

        while (candidate != null) {
            if (candidate.getValue() == a) {
                backup.setNext(candidate.getNext());
                this.count--;
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public T choose() {
        if (this.count == 0) {
            System.out.println("No se puede elegir un elemento del conjunto vacio");
        }
        int randomIndex = (new Random()).nextInt(this.count);
        GenericNode<T> candidate = this.first;
        for (int i = 1; i <= randomIndex; i++) {
            candidate = candidate.getNext();
        }
        return candidate.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericSet<T> set = (GenericSet<T>) o;
        return count == set.count && Objects.equals(first, set.first);
    }

    public GenericNode<T> getFirst() {
        return first;
    }

    public void setFirst(GenericNode<T> first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "GenericSet{" +
                "first=" + first +
                ", count=" + count +
                '}';
    }
}
