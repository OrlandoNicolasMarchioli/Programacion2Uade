package org.uade.adt.definitions;

import org.uade.adt.Stack;

public interface ISpecialRow {

    //JavaDoc
    /**
     * Precondicion: Solo se puede agregar un elemento si la pila esta inicializada.
     * Postcondicion: el elemento se coloraca como tope
     * @param a un numero arbitrario
     */

    void add(Stack a); // apilar

    void remove(); //desapilar

    /**
     * Precodincion: La pila debe estar inicializada
     * Postcondicion: Se va a indicar si la pila esta vacia
     * @return true si la pila esta vacia
     */

    boolean isEmpty(); // es vacia

    Stack getTop(); // obtener el tope
}
