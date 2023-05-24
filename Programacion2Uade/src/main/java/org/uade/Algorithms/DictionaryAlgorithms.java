package org.uade.Algorithms;

import org.uade.dynamic.GenericMultipleDictionary;
import org.uade.dynamic.GenericQueue;
import org.uade.dynamic.GenericSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DictionaryAlgorithms {


    private static List<Integer> findCommonKeysBetweenMultipleDictionary(GenericMultipleDictionary<Integer> D1, GenericMultipleDictionary<Integer> D2) {
        List<Integer> commonKeys = new ArrayList<>();
        GenericSet<Integer> d1keys = D1.getKeys();
        GenericSet<Integer> d2keys = D2.getKeys();
        GenericSet<Integer> d1KeysBackup = SetAlgorithms.copy(d1keys);
        GenericSet<Integer> d2KeysBackup = SetAlgorithms.copy(d2keys);
        List<Integer> d1KeysList = SetAlgorithms.setToArray(d1keys);
        List<Integer> d2KeysList = SetAlgorithms.setToArray(d2keys);

        int counter = 0;
        while (counter < d1KeysList.size()) {
            int value = d1KeysList.get(counter);
            if (d2KeysList.contains(value)) {
                commonKeys.add(value);
                counter++;
            }
            counter++;
        }
        d1keys = d1KeysBackup;
        d2keys = d2KeysBackup;
        return commonKeys;
    }

    public static GenericMultipleDictionary<Integer> generateGenericMultipleDictionary(int range) {
        GenericMultipleDictionary<Integer> dictionary = new GenericMultipleDictionary<>();
        for (int i = 0; i < range; i++) {
            int randomKey = new Random().nextInt(20);
            for (int j = 0; j < range; j++) {
                dictionary.add(randomKey, new Random().nextInt(100));
            }
        }
        return dictionary;
    }

    public static int sumDictionarySetValues(GenericSet<Integer> values) {
        int sum = 0;
        while (!values.isEmpty()) {
            int value = values.choose();
            sum = sum + value;
            values.remove(value);
        }
        return sum;
    }
}
