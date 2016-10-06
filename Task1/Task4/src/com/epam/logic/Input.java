package com.epam.logic;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Andrei_Lysko on 9/21/2016.
 */
public class Input {

    private static final int RANDOM_RANGE = 200;

    public static int[] integer(int count) {
        System.out.println("Input elements");
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[count];
        for (int i = 0; i <= count; i++) {
            if (sc.hasNextInt()) {
                numbers[i] = sc.nextInt();
            } else {
                i--;
                System.out.println("Incorrect integer");
            }
        }
        return numbers;
    }

    public static int[] randomIntegers(int count) {
        System.out.println("Random massive");
        Random randomizer = new Random();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = randomizer.nextInt(RANDOM_RANGE + 1) - RANDOM_RANGE / 2;
        }
        return numbers;
    }

    public static int countOfNumbers() {
        System.out.println("Input size of massive (correct integer > 0)");
        Scanner sc = new Scanner(System.in);
        int number = 0;
        int count;
        boolean check = false;
        while (!check) {
            if (sc.hasNextInt()) {
                count = sc.nextInt();
                if (count > 0) {
                    number = count;
                    break;
                }
            }
        }
        return number;
    }
}
