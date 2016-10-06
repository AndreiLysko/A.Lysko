package com.epam.logic;

import com.epam.data.Function;

/**
 * Created by Лыско on 27.09.2016.
 */
public class Calculator {

    public static double[] calculate(double a, double b, double step) {
        Function function = new Function();
        double[] result = new double[((int)((b-a)/step)+1)];
        int index = 0;
        for (double i = a; i <= b; i = i + step) {
            result[index] = function.tg(i);
            index++;
        }
        return result;
    }
}
