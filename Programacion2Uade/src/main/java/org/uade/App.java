package org.uade;


import org.uade.adt.PriorityQueue;
import org.uade.adt.SpecialQueue;
import org.uade.adt.Stack;
import org.uade.arrays.Filter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {


    public static void main(String[] args) {
        //clase 3
        // tiempo

        long init = System.currentTimeMillis();

        long end = System.currentTimeMillis();

//        System.out.println("El calculo de la traza es: " + calculateTrace(initiateMatrix()));
//        System.out.println(initiateMatrix());
        System.out.println("La traspuesta de la matriz es: " + generateTransposed(initiateQuequeMatrix()));

    }

    public static double getRandom() {
        // [0...n) = math.random() * n;
        // [a, a + n) = (Math.random * n) + a
        Math.random(); // [0,1)

        // [80, 89) = (Math.random * 9) + 80

        return (Math.random() * 9) + 80;
    }

    public static double getRandom3() {
        Random random = new Random();
        return random.nextDouble(80, 89);
    }


    public static double getRandom2() {
        //A diferencia de Math, el rango es cualquier double disponible, entonces debo generar el random
        double candidate = new Random().nextDouble();

        if (candidate < 0) {
            candidate = -candidate;
        }
        candidate = candidate / Double.MAX_VALUE;
        return (candidate * 9) + 80;

    }

    public static void revert(Stack stack) {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        while (!stack.isEmpty()) {
            int top = stack.getTop();
            stack1.add(top);
            stack.remove();
        }

        while (!stack1.isEmpty()) {
            int top = stack1.getTop();
            stack2.add(top);
            stack1.remove();
        }

        while (!stack2.isEmpty()) {
            int top = stack2.getTop();
            stack.add(top);
            stack2.remove();
        }
    }


    /**
     * Ejercicio1
     * Desarrollar funciones que permitan:
     * Elimitar de pila de numeros, un numero n dado por parametro.
     */

    // TODO:
    //  hacer dos pilas auxiliares y apilar la pila principal en ambas, luego desapilar las pilas, si quedan ambas en cero, era par
    //  20/03/2023
    public static String esPar() {
        Stack stack = new Stack();
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        int count = 0;
        stack.add(1);
        stack.add(1);
        stack.add(1);
        stack.add(1);
        stack.add(1);
        stack.add(1);

        while (!stack.isEmpty()) {
            if (stack.getCount() % 2 == 0) {
                stack1.add(stack.getTop());
                stack.remove();
            } else if (stack.getCount() != 0) {
                stack2.add(stack.getTop());
                stack.remove();
            }
            count++;
        }

        if ((stack1.getCount() - stack2.getCount()) != 0) {
            return "false";
        }
        return "true";
    }

    /**
     * Ejercicio2
     * Desarrollar funciones que permitan:
     * Elimitar de pila de numeros, un numero n dado por parametro.
     */

    public static void deleteNumberFromStack(int number, Stack stack) {
        boolean hasTheNumber = false;
        while (!stack.isEmpty()) {
            if (stack.getArray()[stack.getCount()] == number) {
                stack.getArray()[stack.getCount()] = 0;
                hasTheNumber = true;
                stack.remove();
            }
            stack.remove();
        }
        if (hasTheNumber) {
            System.out.println("The number " + number + " has been deleted");
        } else if (!hasTheNumber) {
            System.out.println("The number " + number + " doesn't exists in stack");
        }
    }

    /**
     * Ejercicio 1.2.4: Filtro
     * Cree una función que reciba un array de caracteres, y se quede solo con los que estan en mayúscula.
     * † Cree una función que reciba un array de cadenas de caracteres, y se quede solo con las que estan
     * escritas en mayúscula.
     */

    public static ArrayList<Character> arrayFilter(Filter filter) {
        filter.add('a');
        filter.add('C');
        filter.add('T');
        filter.add('b');
        filter.add('R');
        filter.add('a');
        filter.add('Y');
        filter.add('a');

        ArrayList<Character> uppercaseFilterList = new ArrayList<>();

        for (int i = 0; i < filter.getArray().size(); i++) {
            if (filter.getArray().get(i) == Character.toUpperCase(filter.getArray().get(i))) {
                uppercaseFilterList.add(filter.getArray().get(i));
            }
        }

        return uppercaseFilterList;
    }

    /**
     * Ejercicio matriz de pilas:
     * Generar una matriz de pilas  dentro de una cola y calcular su traza
     */

    private static SpecialQueue initiateMatrix() {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        SpecialQueue row = new SpecialQueue();

        stack1.add(1);
        stack1.add(1);
        stack1.add(1);

        stack2.add(2);
        stack2.add(2);
        stack2.add(2);

        stack3.add(3);
        stack3.add(3);
        stack3.add(3);

        row.add(stack1);
        row.add(stack2);
        row.add(stack3);


        return row;
    }

    private static SpecialQueue initiateQuequeMatrix() {
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        Stack stack3 = new Stack();
        SpecialQueue matrix = new SpecialQueue();

        stack1.add(1);
        stack1.add(1);
        stack1.add(1);

        stack2.add(2);
        stack2.add(2);
        stack2.add(2);

        stack3.add(3);
        stack3.add(3);
        stack3.add(3);

        matrix.add(stack1);
        matrix.add(stack2);
        matrix.add(stack3);

        System.out.println(matrix);

        return matrix;
    }

    private static int calculateTrace(SpecialQueue specialQueue) {
        int traceValue = 0;
        for (int i = 0; i < specialQueue.getCount(); i++) {
            for (int j = 0; j < specialQueue.getCount(); j++) {
                if (i == j) {
                    traceValue = traceValue + specialQueue.getArray()[i].getArray()[j];
                }
            }
        }

        return traceValue;
    }

    /**
     * Ejercicio matriz de pilas:
     * Generar una matriz de pilas  dentro de una cola y generar su traspuerta
     */

    private static List<Stack> generateListOfStacksFromSpecialQueque(SpecialQueue specialQueque) {
        List<Stack> stacks = new ArrayList<>();
        for (int i = 0; i < specialQueque.getCount(); i++) {
            Stack stack = new Stack();
            stacks.add(stack);
        }
        return stacks;
    }

    private static SpecialQueue generateTransposed(SpecialQueue specialQueque) {
        Stack[] specialQuequeStack = specialQueque.getArray();

        List<Stack> stacksTransposed = generateListOfStacksFromSpecialQueque(specialQueque);
        for (int i = 0; i < specialQueque.getCount(); i++) {
            int counter = 0;

            while (stacksTransposed.get(i) != null && counter < stacksTransposed.size()) {
                int basePosition = 0;
                stacksTransposed.get(basePosition + counter).add(specialQuequeStack[i].getTop());
                counter++;
            }

        }

        for (int j = 0; j < specialQueque.getCount(); j++) {
            System.out.println(specialQueque.getArray()[j]);
            specialQueque.getArray()[j] = stacksTransposed.get(j);
        }


        return specialQueque;
    }

    /**
     * TDA Cola con prioridad
     * <p>
     * Ejercicio 5.3.2 Merge
     * Defina un metodo que permita combinas dos colas con prioridades CPI y CP2, generando uan nueva cola con prioridades.
     * Considerar que a igual prioridad, los elementos de la CP1 son mas prioritarios que la CP2
     */

    private static PriorityQueue mergeQueques(PriorityQueue CP1, PriorityQueue CP2) {
        PriorityQueue queque = new PriorityQueue();
        //Estos contadores toman los valores iniciales, ya que cuando descolamos el contador disminuye y se necesitan recorrer todos los valores de la cola.
        int CP1IninitalCount = CP1.getCount();
        int CP2InitialCount = CP2.getCount();
        if (CP1.getPriority() > CP2.getPriority() || CP1.getPriority() == CP2.getPriority()) {
            for (int i = 0; i < CP1IninitalCount; i++) {
                queque.add(CP1.getFirst(), CP1.getPriority());
                CP1.remove();
            }
            for (int i = 0; i < CP2InitialCount; i++) {
                queque.add(CP2.getFirst(), CP2.getPriority());
                CP2.remove();
            }
        }
        for (int i = 0; i < CP2InitialCount; i++) {
            queque.add(CP2.getFirst(), CP2.getFirst());
            CP2.remove();
        }
        for (int i = 0; i < CP1IninitalCount; i++) {
            queque.add(CP1.getFirst(), CP1.getPriority());
            CP1.remove();
        }

        return queque;
    }

    /**
     * TDA Cola con prioridad
     * <p>
     * Ejercicio 5.3.3 Merge
     * Determinar si dos colas con prioridad son identicas     *
     */
    private static boolean areEquals(PriorityQueue queue1, PriorityQueue queue2) {
        boolean equals = false;
        if (queue1.getCount() == queue2.getCount()) {
            for (int i = 0; i < queue1.getCount(); i++) {
                if (queue1.getArray()[i] == queue2.getArray()[i]) {
                    equals = true;
                } else {
                    equals = false;
                }
                return equals;
            }
        }
        return equals;
    }

    /**
     * @param range must be bigger than 0
     * @return RowWithPriority complete
     */
    private static PriorityQueue generateCompleteQueue(int range, int priority) {
        PriorityQueue priorityQueue = new PriorityQueue();

        for (int i = 0; i <= range; i++) {
            priorityQueue.add(new Random().nextInt(100 - 2 + 1) + 2, priority);
        }

        return priorityQueue;
    }


}
