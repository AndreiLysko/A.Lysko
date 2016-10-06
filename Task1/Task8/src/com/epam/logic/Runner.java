package com.epam.logic;

import com.epam.data.Sequence;

public class Runner {

    public static void main(String[] args) {
        Sequence A = new Sequence();
        Sequence B = new Sequence();
        for (int i = 0; i < 2; i ++){
            if (!Check.integerPositive(args[i])) {
                System.out.println("Incorrect argument for length (must be positive integer)");
                System.exit(99);                                                                //err code for incorrect input
            }
        }
        A.setData(Input.randomIntegers(Integer.parseInt(args[0])));
        B.setData(Input.randomIntegers(Integer.parseInt(args[1])));
        Input.showSequence(Sorter.sort(A.getData()));
        Input.showSequence(Sorter.sort(B.getData()));
        Sorter.placeSearch(Sorter.sort(A.getData()),Sorter.sort(B.getData()));

    }
}
