package org.uade.dynamic;

import org.uade.dynamic.definitions.IGenericStack;
import org.uade.dynamic.node.GenericNode;

public class GenericStack<T> implements IGenericStack<T> {
    private GenericNode<T> first;

    public GenericStack() {
    }

    @Override
    public void add(T a) {
        this.first = new GenericNode(a, this.first);
    }

    @Override
    public void remove() {
        if (this.first == null) {
            System.out.println("No se puede desapilar una pila vacia");
            return;
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public T getTop() {
        if (this.first == null) {
            System.out.println("No se puede obtener el tope una pila vacia");
        }
        return this.first.getValue();
    }

    public GenericNode<T> getFirst() {
        return first;
    }

    public void setFirst(GenericNode<T> first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "GenericStack{" +
                "first=" + first +
                +
                        '}';
    }
}
