package org.uade.exercises.testExercises;

import org.uade.adt.BinaryTree;
import org.uade.dynamic.GenericBinaryTree;

import java.util.Random;

public class TestExercises {
    public static void main(String[] args) {

    }

    /**
     * 1.    Definicíon,  implementacíon  y  costos  de  los TDAs
     * A.  Cree el TDA MaximumRestrictedStackque representa
     * una pila con com-portamiento id ́entico excepto en el m ́etodo de agregar un elemento. Si elelemento es mayor al tope,
     * se agregar ́a al fondo de la pila, mientras que sies menor se comportar ́a como una pila normal
     * .B.  Desarrolle una implementacion estatica de esta estructura
     * .C.  Desarrolle una implementaci ́on din ́amica de esta estructura.
     */

    /**
     * 2
     * A.  Desarrolle una funcíon que recibe una pila y una cola y devuelvetruesilos elementos de ambas estructuras son los mismos (sin importar orden nirepetici ́on).
     * B.  Desarrolle  una  funci ́on  que  recibe  un  conjunto  y  unn >5  (de  lo  con-trario mostrar un error), que devuelve un subconjunto con los n menores ńumeros.
     *  En caso de quensea mayor al cardinal del conjunto ingresado,debera devolverse una copia del conjunto recibido.
     *  No se puede modificar el conjunto recibido como parametro.
     */

    /**
     * 1. Ejercicio 1
     * Desarrollar una funcion que reciba un AB y devuelva la suma de sus nodos
     * internos (todo nodo que no es hoja). Al resultado multiplicarlo por el menor
     * valor que se puede encontrar en una de las hojas del arbol.
     */
//    public static int sumOfBinaryTreeNodes(GenericBinaryTree<Integer> binaryTree) {
//
//    }

    public static GenericBinaryTree<Integer> generateBinaryTree(int range) {
        GenericBinaryTree<Integer> binaryTree = new GenericBinaryTree<>();
        binaryTree.create(1);
        for (int i = 0; i < range; i++) {
            int value = new Random().nextInt(100);
            if (value % 2 != 0){
                binaryTree.addLeft(value);
            }
            binaryTree.addRight(value);
        }
        return binaryTree;
    }

    /**
     * 2. Ejercicio 2
     * Desarrollar una funcion que reciba un AB, y devuelva el sub arbol de mayor
     * altura posible que sea posible usar como un ABB. No importa que el ABB sea
     * desbalanceado.
     */
}
