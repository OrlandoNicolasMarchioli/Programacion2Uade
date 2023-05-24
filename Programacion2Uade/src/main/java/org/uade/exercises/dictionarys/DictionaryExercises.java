package org.uade.exercises.dictionarys;

import org.uade.Algorithms.SetAlgorithms;
import org.uade.dynamic.GenericDictionary;
import org.uade.dynamic.GenericMultipleDictionary;
import org.uade.dynamic.GenericSet;

import static org.uade.Algorithms.DictionaryAlgorithms.generateGenericMultipleDictionary;
import static org.uade.Algorithms.DictionaryAlgorithms.sumDictionarySetValues;

public class DictionaryExercises {

    public static void main(String[] args) {
        System.out.println("The dictionary's are ");
        GenericMultipleDictionary<Integer> D1 = generateGenericMultipleDictionary(10);
        GenericMultipleDictionary<Integer> D2 = generateGenericMultipleDictionary(10);
        System.out.println(D1);
        System.out.println(D2);
        System.out.println("The jointed dictionary's is: " + joinMultipleDictionary(D1, D2));

        System.out.println();

        System.out.println("The dictionary´s are");
        System.out.println(genericDictionary());
        System.out.println(genericMultipleDictionary());
        System.out.println("The dictionary´s keep relation?: " + keepRelation(genericMultipleDictionary(), genericDictionary()));

    }

    /**
     * Ejercicio 8.1.3: Mezcla de diccionarios
     * ados dos Diccionarios múltiples D1 y D2, generar un Diccionario múltiple que contenga:
     * las claves presentes en D1 y D2, con todos los elementos asociados a cada clave.
     * las claves presentes en D1 y D2, con todos los elementos comunes a las claves coincidentes en
     * ambos.
     */
    /**
     * @param D1
     * @param D2
     * @return dictionary with all values jointed.
     */
    private static GenericMultipleDictionary<Integer> joinMultipleDictionary(GenericMultipleDictionary<Integer> D1, GenericMultipleDictionary<Integer> D2) {
//        List<Integer> commonKeys = findCommonKeys(D1, D2);
        GenericMultipleDictionary<Integer> dictionaryJointed = new GenericMultipleDictionary<>();

        dictionaryJointed = addValuesToDictionary(D1, dictionaryJointed);
        dictionaryJointed = addValuesToDictionary(D2, dictionaryJointed);

        return dictionaryJointed;
    }

    /**
     * 2. Utilizacion de los TDAs
     * A. Desarrolle un metodo estatico que reciba un Diccionario multiple y un
     * Diccionario simple como parametro. Debe retornar true si para cada clave
     * repetida en ambos diccionarios, mantiene la relacion de que la suma de los
     * valores del diccionario multiple dan como resultado el valor del diccionario
     * simple.
     */

    private static boolean keepRelation(GenericMultipleDictionary<Integer> multipleDictionary,
                                        GenericDictionary<Integer> dictionary) {
        boolean keepRelation = true;
        GenericSet<Integer> keys = multipleDictionary.getKeys();
        while (!keys.isEmpty()) {
            int multipleDictionaryKey = keys.choose();
            GenericSet<Integer> dictionaryKeys = dictionary.getKeys();
            int dictionaryKey = dictionaryKeys.choose();
            int dictionaryValue = dictionary.getValue(dictionaryKey);
            GenericSet<Integer> multipleDictionaryKeyValues = multipleDictionary.getValues(multipleDictionaryKey);
            GenericSet setValuesBackUp = SetAlgorithms.copy(multipleDictionaryKeyValues);
            if (dictionaryKey == multipleDictionaryKey) {
                if (dictionaryValue != sumDictionarySetValues(multipleDictionaryKeyValues)) {
                    dictionaryKeys.remove(dictionaryKey);
                    keys.remove(multipleDictionaryKey);
                    keepRelation = false;
                }
                multipleDictionaryKeyValues = setValuesBackUp;
                dictionaryKeys.remove(dictionaryKey);
                keys.remove(multipleDictionaryKey);
            }
        }
        return keepRelation;
    }

    private static GenericDictionary<Integer> genericDictionary() {
        GenericDictionary<Integer> dictionary = new GenericDictionary<>();
        dictionary.add(1, 2);
        dictionary.add(2, 3);
        dictionary.add(3, 4);
        dictionary.add(4, 5);
        return dictionary;
    }

    private static GenericMultipleDictionary<Integer> genericMultipleDictionary() {
        GenericMultipleDictionary<Integer> multipleDictionary = new GenericMultipleDictionary<>();
        multipleDictionary.add(1, 2);
        multipleDictionary.add(1, 0);
        multipleDictionary.add(2, 1);
        multipleDictionary.add(2, 2);
        multipleDictionary.add(3, 1);
        multipleDictionary.add(3, 3);
        multipleDictionary.add(4, 2);
        multipleDictionary.add(4, 3);
        return multipleDictionary;
    }

    private static GenericMultipleDictionary<Integer> addValuesToDictionary(GenericMultipleDictionary<Integer> dictionary
            , GenericMultipleDictionary<Integer> dictionaryJointed) {
        GenericSet<Integer> keys = dictionary.getKeys();
        while (!keys.isEmpty()) {
            GenericSet<Integer> dictionaryKeys = dictionary.getKeys();
            int key = dictionaryKeys.choose();
            GenericSet<Integer> values = dictionary.getValues(key);
            while (!values.isEmpty()) {
                int value = values.choose();
                dictionaryJointed.add(key, value);
                values.remove(value);
            }
            keys.remove(key);
            dictionaryKeys.remove(key);
        }
        return dictionaryJointed;
    }

}
