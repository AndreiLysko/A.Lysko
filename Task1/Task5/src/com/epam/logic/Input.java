package com.epam.logic;

import java.util.Random;

/**
 * Created by Andrei_Lysko on 9/21/2016.
 */
public class Input {

    private static final int RANDOM_RANGE = 200;

    public static int[] randomIntegers(int count) {                              //generating numbers
        Random randomizer = new Random();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = randomizer.nextInt(RANDOM_RANGE) + 1;
        }
        return numbers;
    }


}
