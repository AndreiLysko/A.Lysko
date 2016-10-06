package com.epam.logic;

import com.epam.data.Expression;

public class Runner {

    public static void main(String[] args) {

        if (!Check.doubleNumber(args[0])) {
            System.out.println("Incorrect x(must be double positive or negative)");
            System.out.println("You've inputted " + args[0]);
            System.exit(99);                                                             //err code for incorrect input
        }

        if (!Check.doubleNumber(args[1])) {
            System.out.println("Incorrect y(must be double positive or negative)");
            System.out.println("You've inputted " + args[1]);
            System.exit(99);                                                             //err code for incorrect input
        }
        System.out.println("Result is: " + Expression.count(Double.valueOf(args[0]), Double.valueOf(args[1])));
    }
}
