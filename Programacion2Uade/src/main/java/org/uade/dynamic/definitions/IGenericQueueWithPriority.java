package org.uade.dynamic.definitions;

public interface IGenericQueueWithPriority<T,P extends Comparable> {
    /**
     * Postcondition: Stacks (adds in the final position) un valor.
     * @param a value to stack.
     */
    void add(T a,P priority);

    /**
     * Precondition: The queue is not empty.
     * Postcondition: erase the first element.
     */
    void remove();

    /**
     * @return <code>true</code> if queue is empty, <code>false</code> in other case.
     */
    boolean isEmpty();

    /**
     * @return retuns the first value.
     */
    T getFirst();
}
