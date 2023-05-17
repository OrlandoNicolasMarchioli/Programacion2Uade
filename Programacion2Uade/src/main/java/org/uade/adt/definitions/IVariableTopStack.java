package org.uade.adt.definitions;

/**
 * Precondicion: para usar cualquier de estos metodos la estructura debe estar inicializada.
 */
public interface IVariableTopStack {

    void add(int a);

    void remove();
    
    boolean isEmpty();
    IStack getTop();

}
