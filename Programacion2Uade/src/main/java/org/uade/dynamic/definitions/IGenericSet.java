package org.uade.dynamic.definitions;

public interface IGenericSet<T> {

    /**
     * Postcondition: Adds a value to the set.
     * @param a value to add.
     */
    void add(T a);

    /**
     * Postcondicion: Erase the indicated element if exists, in other case doesn't do anything.
     * @param a value to erase.
     */
    void remove(T a);

    /**
     * @return <code>true</code> If set is empty, <code>false</code> in other case.
     */
    boolean isEmpty();

    /**
     * @return returns the element from set.
     */
    T choose();

}
