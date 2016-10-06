package com.epam.logic;

/**
 * Created by Andrei_Lysko on 9/22/2016.
 */
public class Sorter {

    public static void placeSearch(double[] sequenceA, double[] sequenceB){
        for (int i = 0; i < sequenceA.length; i++){
            for (int j = 0; j < sequenceB.length; j++){
                if (sequenceB[j] < sequenceA[i]){
                    if (i == 0){
                        System.out.println(sequenceB[j] + " before " + sequenceA[i]);
                    }
                    else{
                        System.out.println(sequenceB[j] + " between " + sequenceA[i-1] + " and " + sequenceA[i]);
                    }
                }
                else{
                    if (i == sequenceA.length - 1){
                        System.out.println(sequenceB[j] + " after " + sequenceA[i]);
                    }
                }
            }
        }
    }

    public static double[] sort(double[] data){
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
}
