package com.epam.logic;

/**
 * Created by Andrei_Lysko on 9/22/2016.
 */
public class Generator {

    private double matrix[][];

    public double[][] getMatrix() {
        return matrix;
    }

    public void generateMatrix(double data[]) {
        double[][] bufferMatrix = new double[data.length][data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                bufferMatrix[i][j] = data[(data.length + j + i) % (data.length)];
            }
        }
        this.matrix = bufferMatrix;
    }


    public void showMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }
}
