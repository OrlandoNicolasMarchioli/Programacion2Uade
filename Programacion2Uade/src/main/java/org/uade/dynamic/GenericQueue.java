package org.uade.dynamic;

import org.uade.adt.node.Node;
import org.uade.dynamic.definitions.IGenericQueue;
import org.uade.dynamic.node.GenericNode;

public class GenericQueue<T> implements IGenericQueue<T> {

    private GenericNode<T> first;

    @Override
    public void add(T a) {
        GenericNode<T> node = new GenericNode<>(a, null);
        if(this.first == null) {
            this.first = node;
            return;
        }
        GenericNode candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(node);
    }

    @Override
    public void remove() {
        if(this.first == null) {
            System.out.println("No se puede desacolar una cola vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public T getFirst() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
        }
        return this.first.getValue();
    }

    @Override
    public String toString() {
        return "GenericQueue{" +
                "first=" + first +
                '}';
    }
}
