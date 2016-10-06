package com.epam.logic;


public class Runner {

    public static void main(String[] args) {

        for (int i = 0; i <= 1; i++) {
            if (!Check.doubleNumber(args[i])) {
                System.out.println("Incorrectly inputted number " + i + 1 + " (must be double like -6.9");
                System.exit(99);                //err code for incorrect input
            }
        }
        if (!Check.doublePositive(args[2])){
            System.out.println("Incorrectly inputed step " + args[2] + " (must be positive double)");
            System.exit(99);
        }
        double[] argument = new double[3];
        for (int i = 0; i < 3; i++){
            argument[i] = Double.valueOf(args[i]);
        }
        System.out.println("Interval : [" + args[0] + "," + args[1] + "] Step : " + args[2]);
        double[] result = Calculator.calculate(argument[0], argument[1], argument[2]);
        double step = argument[2];
        for (int i = 0; i < result.length; i++){
            System.out.println(argument[0] + step*i + "  " + result[i]);
        }
    }
}
