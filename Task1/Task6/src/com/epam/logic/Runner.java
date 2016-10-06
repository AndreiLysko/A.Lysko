package com.epam.logic;

import com.epam.data.Massive;

public class Runner {

    public static void main(String[] args) {
        Massive mas = new Massive();
        if (Check.integerPositive(args[0])) {
            mas.setData(Input.randomIntegers(Integer.parseInt(args[0])));
        } else {
            System.out.println("Incorrect argument for length (must be positive integer)");
            System.exit(99);                                                                //err code for incorrect input
        }
        Generator gen = new Generator();
        gen.generateMatrix(mas.getData());
        gen.showMatrix();
    }
}
