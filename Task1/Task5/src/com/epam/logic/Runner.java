package com.epam.logic;

import com.epam.data.IntegerTable;

public class Runner {

    public static void main(String[] args) {
        IntegerTable massive = new IntegerTable();
        SequenceCounter counter = new SequenceCounter();
        if (!(args.length == 0) && Check.integerPositive(args[0])) {
            massive.setData(Input.randomIntegers(Integer.parseInt(args[0])));
            for (int i = 0; i < massive.getData().length; i++) {
                System.out.print(massive.getData()[i] + "  ");
            }
            System.out.println();
            System.out.println("max " + counter.calculateMaxLength(massive.getData()));
            System.out.println("min items to delete : " + (massive.getData().length - counter.getMaxSubsequenceLength()));
        } else {
            System.out.println("Incorrect integer length of massive");
        }
    }
}
