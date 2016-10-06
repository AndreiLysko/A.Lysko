package com.epam.logic;

import com.epam.data.Basket;

public class Runner {

    public static void main(String[] args) {
        if (!Check.integerPositive(args[0])) {
            System.out.println("Incorrect argument for length (must be positive integer)");
            System.exit(99);                                                                //err code for incorrect input
        }
        Basket trash = new Basket();
        Fill.basketIn(trash, Fill.dropBalls(Integer.parseInt(args[0])));
        System.out.println(Fill.totalWeight(trash) + " total weight");
        System.out.println(Fill.totalBlues(trash) + " blue balls");
    }
}
