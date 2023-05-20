package org.uade.dynamic.definitions;

import org.uade.adt.definitions.ISet;
import org.uade.dynamic.GenericSet;

public interface IGenericDictionary<T> {

    /**
     * Agrega un valor a una key, y de existir la reemplaza.
     * @param key -
     * @param value -
     */
    void add(T key, T value);

    /**
     * Para diccionarios simples se puede obviar el value.
     * Si una key que no existe, o un value que no existe esta asociado
     * a una key que si existe, entonces no se hace nada.
     * @param key -
     * @param value -
     */
    void remove(T key, T value);

    /**
     * @return conjunto con todas las claves del diccionario
     */
    GenericSet<T> getKeys();

    /**
     * Devuelve el valor asociado a una key.
     * Precondición: No se puede obtener un valor de una key que no existe.
     * @param key -
     * @return value asociado al key
     */
    T getValue(T key);

    /**
     * @return <code>true</code> si el diccionario esta vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();
}
