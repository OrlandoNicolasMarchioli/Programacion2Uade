package org.uade.dynamic.definitions;

import org.uade.adt.definitions.ISet;
import org.uade.dynamic.GenericSet;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IGenericMultipleDictionary<T> {

    /**
     * Agrega un valor a una key, y de existir no hace nada.
     *
     * @param key   -
     * @param value -
     */
    void add(T key, T value);

    /**
     * Si una key que no existe, o un value que no existe esta asociado
     * a una key que si existe, entonces no se hace nada.
     * En el caso de que la key conserve valores asociados, seguira presente.
     * Si la key se queda sin valores asociados, entonces se elimina.
     *
     * @param key   -
     * @param value -
     */
    void remove(T key, T value);

    /**
     * @return conjunto con todas las claves del diccionario
     */
    GenericSet<T> getKeys();

    /**
     * Devuelve los valores asociados a una key.
     * Precondición: No se puede obtener un valor de una key que no existe.
     *
     * @param key -
     * @return values asociados al key
     */
    GenericSet<T> getValues(T key);

    /**
     * @return <code>true</code> si el diccionario esta vacio, <code>false</code> en otro caso.
     */
    boolean isEmpty();
}
