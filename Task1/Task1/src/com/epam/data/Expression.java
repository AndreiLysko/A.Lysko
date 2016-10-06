package com.epam.data;

/**
 * Created by Andrei_Lysko on 9/20/2016.
 */
public class Expression {

    private static double result;

    public static double count(double x, double y) {
        result = ((1 + Math.pow(Math.sin(x + y), 2)) / (2 + Math.abs(x - 2 * x / (1 + Math.pow(x * y, 2)))) + x);
        return result;
    }
}
