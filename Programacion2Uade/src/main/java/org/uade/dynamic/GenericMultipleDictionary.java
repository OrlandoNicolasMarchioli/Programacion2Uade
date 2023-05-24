package org.uade.dynamic;

import lombok.ToString;
import org.uade.adt.definitions.ISet;
import org.uade.adt.node.MultipleDictionaryNode;
import org.uade.dynamic.definitions.IGenericMultipleDictionary;
import org.uade.dynamic.node.GenericMultipleDictionaryNode;
@ToString
public class GenericMultipleDictionary<T> implements IGenericMultipleDictionary<T> {
    private GenericMultipleDictionaryNode<T> first;
    @Override
    public void add(T key, T value) {
        GenericSet<T> set = new GenericSet<>();
        set.add(value);
        if (this.first == null) {
            this.first = new GenericMultipleDictionaryNode(key, set, null);
            return;
        }
        GenericMultipleDictionaryNode<T> candidate = this.first;
        while (candidate.getNext() != null) {
            if (candidate.getKey() == key) {
                candidate.getValue().add(value);
                return;
            }
            candidate = candidate.getNext();
        }
        if (candidate.getKey() == key) {
            candidate.getValue().add(value);
            return;
        }
        candidate.setNext(new GenericMultipleDictionaryNode(key, set, null));
    }

    @Override
    public void remove(T key, T value) {
        GenericMultipleDictionaryNode<T> backup = null;
        GenericMultipleDictionaryNode<T> candidate = this.first;
        while (candidate != null) {
            if (candidate.getKey() == key) {
                candidate.getValue().remove(value);
                if (candidate.getValue().isEmpty()) {
                    if (backup == null) {
                        if (candidate.getNext() == null) {
                            this.first = null;
                            return;
                        }
                        this.first = this.first.getNext();
                        return;
                    }
                    if (candidate.getNext() == null) {
                        backup.setNext(null);
                        return;
                    }
                    candidate.setNext(candidate.getNext().getNext());
                }
                return;
            }
            backup = candidate;
            candidate = candidate.getNext();
        }
    }

    @Override
    public GenericSet<T> getKeys() { // N^2
        GenericSet<T> keySet = new GenericSet<>(); // C
        GenericMultipleDictionaryNode<T> candidate = this.first; // C
        while (candidate != null) { // N * (N * C) = N^2 C = N^2
            keySet.add(candidate.getKey()); // N*C
            candidate = candidate.getNext();
        }
        return keySet; // C
    }

    @Override
    public GenericSet<T> getValues(T key) {
        GenericMultipleDictionaryNode<T> candidate = this.first;
        while (candidate != null) {
            if (candidate.getKey() == key) {
                return candidate.getValue();
            }
            candidate = candidate.getNext();
        }
        return null; // Error
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

}
