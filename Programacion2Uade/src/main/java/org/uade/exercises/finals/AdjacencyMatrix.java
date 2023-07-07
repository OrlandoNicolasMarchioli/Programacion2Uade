package org.uade.exercises.finals;

import java.util.Arrays;

public class AdjacencyMatrix {

    private int node;
    private int[][] matrix;
    public AdjacencyMatrix(int node) {
        this.node = node;
        matrix = new int[this.node][this.node];

        for(int i=0; i< node; i++){
            for(int j=0; j< node; j++){
                matrix[i][j] = 0;
            }
        }
    }

    public void add(int i, int j){
        matrix[i][j] += 1;
    }

    public void remove(int i, int j){
        if(matrix[i][j]>0)
            matrix[i][j] -= 1;
    }

    public void print(){
        for(int i=0; i< node; i++){
            for(int j=0; j< node; j++){
                System.out.print( matrix[i][j] + "  " );
            }
            System.out.println();
        }
    }

    public static AdjacencyMatrix generateAndaddValuesToMatrix(){
        AdjacencyMatrix matrix = new AdjacencyMatrix(5);

        matrix.add(0, 0);
        matrix.add(0, 1);
        matrix.add(0, 2);
        matrix.add(0, 3);

        matrix.add(1, 0);
        matrix.add(1, 0);
        matrix.add(1, 4);

        matrix.add(2, 0);
        matrix.add(2, 3);
        matrix.add(2, 4);

        matrix.add(3, 0);
        matrix.add(3, 2);

        matrix.add(4, 1);
        matrix.add(4, 2);
        matrix.add(4, 4);
        matrix.add(4, 4);

        return matrix;
    }

    public static AdjacencyMatrix generateAdjacentMatrixWithRecursiveNodes(){
        AdjacencyMatrix matrix = new AdjacencyMatrix(5);

        matrix.add(0, 0);
        matrix.add(0, 1);
        matrix.add(0, 2);
        matrix.add(0, 3);

        matrix.add(1, 1);
        matrix.add(1, 0);
        matrix.add(1, 0);
        matrix.add(1, 4);

        matrix.add(2, 0);
        matrix.add(2, 2);
        matrix.add(2, 3);
        matrix.add(2, 4);

        matrix.add(3, 0);
        matrix.add(3, 2);
        matrix.add(3, 3);

        matrix.add(4, 1);
        matrix.add(4, 2);
        matrix.add(4, 4);
        matrix.add(4, 4);

        return matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    @Override
    public String toString() {
        return "AdjacencyMatrix{" +
                "node=" + node +
                ", matrix=" + Arrays.toString(matrix) +
                '}';
    }
}

