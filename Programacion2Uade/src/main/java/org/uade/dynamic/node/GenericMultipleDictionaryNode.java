package org.uade.dynamic.node;

import org.uade.adt.definitions.ISet;
import org.uade.dynamic.GenericSet;

public class GenericMultipleDictionaryNode<T> {

    private T key;
    private GenericSet<T> value;
    private GenericMultipleDictionaryNode<T> next;

    public GenericMultipleDictionaryNode(T key, GenericSet<T> value, GenericMultipleDictionaryNode<T> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public GenericSet<T> getValue() {
        return value;
    }

    public void setValue(GenericSet<T> value) {
        this.value = value;
    }

    public GenericMultipleDictionaryNode getNext() {
        return next;
    }

    public void setNext(GenericMultipleDictionaryNode next) {
        this.next = next;
    }
}
