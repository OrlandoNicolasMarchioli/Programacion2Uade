package org.uade.dynamic;

import org.uade.dynamic.definitions.IGenericQueueWithPriority;
import org.uade.dynamic.node.GenericPriorityNode;

public class GenericQueueWithPriority<T, P extends Comparable> implements IGenericQueueWithPriority<T, P> {
    private GenericPriorityNode<T, P> first;

    @Override
    public void add(T a, P priority) {
        if (this.first == null) {
            this.first = new GenericPriorityNode(a, priority, null);
            return;
        }
        GenericPriorityNode candidate = this.first;
        while (candidate.getNext() != null && candidate.getPriority().compareTo(priority) == 1) {
            candidate = candidate.getNext();
        }
        candidate.setNext(new GenericPriorityNode(a, priority, candidate.getNext()));
    }

    @Override
    public void remove() {
        if (this.first == null) {
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
        if (this.first == null) {
            System.out.println("No se puede obtener el primero una cola vacia");
        }
        return this.first.getValue();
    }

    public void setFirst(GenericPriorityNode<T,P> first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "GenericQueueWithPriority{}";
    }
}
