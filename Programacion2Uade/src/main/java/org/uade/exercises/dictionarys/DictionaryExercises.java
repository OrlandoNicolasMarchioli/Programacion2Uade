package org.uade.exercises.dictionarys;

import org.uade.Algorithms.DictionaryAlgorithms;
import org.uade.Algorithms.SetAlgorithms;
import org.uade.dynamic.GenericMultipleDictionary;
import org.uade.dynamic.GenericSet;
import org.uade.dynamic.Set;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.uade.Algorithms.DictionaryAlgorithms.saveMultipleDictionaryInstance;

public class DictionaryExercises {

    public static void main(String[] args) {
        System.out.println("The dictionary's are ");
        GenericMultipleDictionary<Integer> D1 = generateGenericMultipleDictionary(10);
        GenericMultipleDictionary<Integer> D2 = generateGenericMultipleDictionary(10);
        System.out.println(D1);
        System.out.println(D2);
        System.out.println("The jointed dictionary's is: " + joinMultipleDictionary(D1, D2));

    }

    /**
     * Ejercicio 8.1.3: Mezcla de diccionarios
     * ados dos Diccionarios múltiples D1 y D2, generar un Diccionario múltiple que contenga:
     * las claves presentes en D1 y D2, con todos los elementos asociados a cada clave.
     * las claves presentes en D1 y D2, con todos los elementos comunes a las claves coincidentes en
     * ambos.
     * las claves comunes de D1 y D2, con todos los elementos asociados a cada clave.
     * las claves comunes de D1 y D2, con todos los elementos comunes a las claves coincidentes en
     * ambos.
     */


    /**
     * @param D1
     * @param D2
     * @return dictionary with all values jointed.
     */
    private static GenericMultipleDictionary<Integer> joinMultipleDictionary(GenericMultipleDictionary<Integer> D1, GenericMultipleDictionary<Integer> D2) {
        List<Integer> commonKeys = findCommonKeys(D1, D2);
        GenericMultipleDictionary<Integer> D1Backup = saveMultipleDictionaryInstance(D1);
        GenericMultipleDictionary<Integer> D2Backup = saveMultipleDictionaryInstance(D2);
        GenericMultipleDictionary<Integer> dictionaryJointed = new GenericMultipleDictionary<>();
        //First add to the dictionary the common keys and his sets
        if (commonKeys.size() > 0) {
            dictionaryJointed = addCommonValuesToDictionary(commonKeys, dictionaryJointed, D1, D2);
        }
        //Now adds the not common keys and sets that are left
        dictionaryJointed = addNotCommonValuesToDictionary(D1, dictionaryJointed);
        dictionaryJointed = addNotCommonValuesToDictionary(D2, dictionaryJointed);

        return dictionaryJointed;
    }

    private static GenericMultipleDictionary<Integer> addCommonValuesToDictionary(List<Integer> commonKeys
            , GenericMultipleDictionary<Integer> dictionaryJointed, GenericMultipleDictionary<Integer> D1, GenericMultipleDictionary<Integer> D2) {
        for (int i = 0; i < commonKeys.size(); i++) {
            int commonKey = commonKeys.get(i);
            GenericSet<Integer> d1Set = D1.getValues(commonKey);
            GenericSet<Integer> d2Set = D2.getValues(commonKey);
            while (!d1Set.isEmpty()) {
                int value = d1Set.choose();
                dictionaryJointed.add(commonKey, value);
                D1.remove(commonKey, value);
            }
            while (!d2Set.isEmpty()) {
                int value = d2Set.choose();
                dictionaryJointed.add(commonKey, value);
                D2.remove(commonKey, value);
            }
        }

        return dictionaryJointed;
    }

    private static GenericMultipleDictionary<Integer> addNotCommonValuesToDictionary(GenericMultipleDictionary<Integer> dictionary
            , GenericMultipleDictionary<Integer> dictionaryJointed) {

        while (!dictionary.isEmpty()) {
            GenericSet<Integer> dictionaryKeys = dictionary.getKeys();
            int dictionaryKey = dictionaryKeys.choose();
            GenericSet<Integer> dictionarySetValues = dictionary.getValues(dictionaryKey);
            while (!dictionarySetValues.isEmpty()) {
                int value = dictionarySetValues.choose();
                dictionaryJointed.add(dictionaryKey, value);
                dictionary.remove(dictionaryKey,value);
            }
            dictionaryKeys.remove(dictionaryKey);
        }
        return dictionaryJointed;
    }

    private static List<Integer> findCommonKeys(GenericMultipleDictionary<Integer> D1, GenericMultipleDictionary<Integer> D2) {
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

    private static GenericMultipleDictionary<Integer> generateGenericMultipleDictionary(int range) {
        GenericMultipleDictionary<Integer> dictionary = new GenericMultipleDictionary<>();
        for (int i = 0; i < range; i++) {
            int randomKey = new Random().nextInt(20);
            for (int j = 0; j < range; j++) {
                dictionary.add(randomKey, new Random().nextInt(100));
            }
        }
        return dictionary;
    }


}
