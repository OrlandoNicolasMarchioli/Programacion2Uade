package org.uade.Algorithms;

import org.uade.dynamic.GenericMultipleDictionary;
import org.uade.dynamic.GenericQueue;
import org.uade.dynamic.GenericSet;

public class DictionaryAlgorithms {

    public static GenericMultipleDictionary<Integer> saveMultipleDictionaryInstance(GenericMultipleDictionary<Integer> multipleDictionary) {
        GenericMultipleDictionary<Integer> copy = new GenericMultipleDictionary<>();
        GenericMultipleDictionary<Integer> aux = new GenericMultipleDictionary<>();
        while (!multipleDictionary.isEmpty()) {
            GenericSet<Integer> keys = multipleDictionary.getKeys();
            while (!keys.isEmpty()) {
                int key = keys.choose();
                GenericSet<Integer> values = multipleDictionary.getValues(key);
                while (!values.isEmpty()) {
                    int value = values.choose();
                    aux.add(key, value);
                    multipleDictionary.remove(key,value);
                }
                keys.remove(key);
            }
        }
        while (!aux.isEmpty()) {
            GenericSet<Integer> keys = aux.getKeys();
            while (!keys.isEmpty()) {
                int key = keys.choose();
                GenericSet<Integer> values = aux.getValues(key);
                while (!values.isEmpty()) {
                    int value = values.choose();
                    copy.add(key, value);
                    multipleDictionary.add(key, value);
                    values.remove(value);
                }
                keys.remove(key);
            }
        }
        return copy;
    }
}
