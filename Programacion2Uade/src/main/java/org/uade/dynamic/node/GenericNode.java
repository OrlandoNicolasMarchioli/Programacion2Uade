package org.uade.dynamic.node;

public class GenericNode<T> {

    private T value;
    private GenericNode<T> next;

    public GenericNode(T value, GenericNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public GenericNode<T> getNext() {
        return next;
    }

    public void setNext(GenericNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "GenericNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
