package org.uade.dynamic.node;

public class GenericPriorityNode<T,P extends Comparable> {

    private T value;
    private P priority;
    private GenericPriorityNode next;

    public GenericPriorityNode(T value, P priority, GenericPriorityNode next) {
        this.value = value;
        this.priority = priority;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public P getPriority() {
        return priority;
    }

    public void setPriority(P priority) {
        this.priority = priority;
    }

    public GenericPriorityNode<T,P> getNext() {
        return next;
    }

    public void setNext(GenericPriorityNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "GenericPriorityNode{" +
                "value=" + value +
                ", priority=" + priority +
                ", next=" + next +
                '}';
    }
}
