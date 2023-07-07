package org.uade.dynamic.node;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GenericDictionaryNode<T> {

    private T key;
    private T value;
    private GenericDictionaryNode next;

    @Override
    public String toString() {
        return "GenericDictionaryNode{" +
                "key=" + key +
                ", value=" + value +
                ", next=" + next +
                '}';
    }
}
