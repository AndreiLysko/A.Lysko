package com.epam.logic;

/**
 * Created by Andrei_Lysko on 9/22/2016.
 */
public class Sorter {

    public double[] sort(double[] data){
        double buffer;
        for (int i = 0; i < data.length - 1; i++){
            if (data[i] > data[i+1]){
                buffer = data[i+1];
                data[i+1] = data[i];
                data[i] = buffer;
                sort(data);
            }
        }
        return data;
    }

    public void showResult(double[] data){
        for (int i = 0; i < data.length; i ++){
            System.out.print(data[i] + " ");
        }
    }
}
