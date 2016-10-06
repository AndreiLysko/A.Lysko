package com.epam.logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Andrei_Lysko on 9/22/2016.
 */
public class Input {

    private static final int RANDOM_MULTIPLIER = 100;

    public static double[] randomIntegers(int count){                              //generating numbers
        double[] numbers = new double[count];
        for (int i = 0; i < count; i++){
            double randomDouble = new BigDecimal(Math.random()*RANDOM_MULTIPLIER - RANDOM_MULTIPLIER/2).setScale(3, RoundingMode.UP).doubleValue();
            numbers[i] = randomDouble;
        }
        return numbers;
    }
}
