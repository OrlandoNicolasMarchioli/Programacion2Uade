package org.uade.dynamic;

import org.uade.adt.definitions.IDictionary;
import org.uade.adt.node.DictionaryNode;
import org.uade.dynamic.definitions.IGenericDictionary;
import org.uade.dynamic.node.GenericDictionaryNode;

public class GenericDictionary<T> implements IGenericDictionary<T> {

    private GenericDictionaryNode<T> first;
    private int size;

    public GenericDictionary() {
        size = 0;
    }

    @Override
    public void add(T key, T value) {
        if (this.first == null) {
            this.first = new GenericDictionaryNode<>(key, value, null);
            this.size++;
            return;
        }
        GenericDictionaryNode<T> index = indexOfKey(key);
        if (index != null) {
            index.setValue(value); // Si la key ya existe, se reemplaza el value
            return;
        }
        GenericDictionaryNode<T> lastNode = this.first;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        lastNode.setNext(new GenericDictionaryNode<>(key, value, null));
        this.size++;
    }

    @Override
    public void remove(T key, T value) {
        if(this.first == null) {
            return;
        }
        if(this.first.getKey() == key && this.first.getValue() == value) {
            this.first = this.first.getNext();
            return;
        }
        GenericDictionaryNode<T> backup = null;
        GenericDictionaryNode<T> candidate = this.first;
        while(candidate.getNext() != null) {
            if(candidate.getKey() == key && candidate.getValue() == value) {
                backup.setNext(candidate.getNext());
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
        if(candidate.getKey() == key && candidate.getValue() == value) {
            backup.setNext(null);
            this.size--;
        }
    }

    @Override
    public GenericSet<T> getKeys() {
        GenericSet<T> keySet = new GenericSet<>();
        GenericDictionaryNode<T> candidate = this.first;
        while (candidate != null) {
            keySet.add(candidate.getKey());
            candidate = candidate.getNext();
        }
        return keySet;
    }

    @Override
    public T getValue(T key) throws Error {
        GenericDictionaryNode<T> candidate = this.first;
        while(candidate != null) {
            if(candidate.getKey() == key) {
                return candidate.getValue();
            }

            if(candidate.getNext() != null) {
                candidate = candidate.getNext();
            }
        }
        return null; // Error
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private GenericDictionaryNode<T> indexOfKey(T key) {
        if(this.first == null) {
            return null;
        }
        GenericDictionaryNode<T> candidate = this.first;
        while(candidate.getNext() != null) {
            if(candidate.getKey() == key) {
                return candidate;
            }
            candidate = candidate.getNext();
        }
        return null;
    }
}
