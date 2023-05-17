package org.uade.dynamic.definitions;

public interface IGenericStack<T> {

    //JavaDoc
    /**
     * Precondicion: Solo se puede agregar un elemento si la pila esta inicializada.
     * Postcondicion: el elemento se coloca como tope
     * @param a un numero arbitrario
     */

    void add(T a); // apilar

    void remove(); //desapilar

    /**
     * Precodincion: La pila debe estar inicializada
     * Postcondicion: Se va a indicar si la pila esta vacia
     * @return true si la pila esta vacia
     */

    boolean isEmpty(); // es vacia

    T getTop(); // obtener el tope
}
