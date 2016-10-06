package com.epam.logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Andrei_Lysko on 9/20/2016.
 */
public class Input {

    public static double enterKeys() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean check = false;
        System.out.println("Input double:");
        while (!check) {
            try {
                String inputString = br.readLine();
                if (!Check.doubleNumber(inputString)) {
                    System.out.println("Incorrect double number");
                } else {
                    return Double.valueOf(inputString);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return 0.0;
    }
}
