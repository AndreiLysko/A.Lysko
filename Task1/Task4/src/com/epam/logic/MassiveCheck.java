package com.epam.logic;

import com.epam.data.Massive;

/**
 * Created by Andrei_Lysko on 9/21/2016.
 */
public class MassiveCheck {

    public static boolean isPrime(int number) {
        if (Math.abs(number)==2){
            return true;
        }
        if (Math.abs(number) % 2 == 0) {
            return false;
        } else {
            for (int i = 3; i <= Math.abs(number) / 2; i = i + 2) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void checkPrimes(Massive massive) {
        int[] indexes = new int[massive.getSizeOfMassive()];
        int k = 0;
        for (int i = 0; i < massive.getSizeOfMassive(); i++) {
            if (isPrime(massive.getMassive()[i])) {
                indexes[k] = i;
                k++;
            }
        }
        int[] primeElements = new int[k];
        for (int i = 0; i < k; i++) {
            primeElements[i] = indexes[i];
        }
        massive.setPrimeIndexes(primeElements);
    }

    public static void typeIndexes(Massive massive) {
        System.out.println();
        for (int i = 0; i < massive.getPrimeIndexes().length; i++) {
            System.out.println(massive.getPrimeIndexes()[i] + 1 + " element is prime : " + massive.getMassive()[massive.getPrimeIndexes()[i]]);
        }
    }

    public static void drawMassive(Massive massive) {
        for (int i = 0; i < massive.getMassive().length; i++) {
            System.out.print(massive.getMassive()[i] + "  ");
        }
    }
}
