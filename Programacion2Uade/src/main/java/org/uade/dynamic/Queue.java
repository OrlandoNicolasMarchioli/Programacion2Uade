package org.uade.dynamic;

import org.uade.adt.definitions.IQueue;
import org.uade.dynamic.node.GenericNode;

public class Queue implements IQueue {

    private GenericNode first;

    @Override
    public void add(int a) {
        GenericNode genericNode = new GenericNode(a, null);
        if(this.first == null) {
            this.first = genericNode;
            return;
        }
        GenericNode candidate = this.first;
        while(candidate.getNext() != null) {
            candidate = candidate.getNext();
        }
        candidate.setNext(genericNode);
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
    public int getFirst() {
        if(this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
            return -1;
        }
        return (int) this.first.getValue();
    }
}
