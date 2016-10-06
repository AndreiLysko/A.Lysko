package com.epam.logic;

import java.util.regex.Pattern;

/**
 * Created by Andrei_Lysko on 9/22/2016.
 */
public class Check {

    private final static String REG_EXP_POSITIVE_INTEGER = "([1-9]\\d*)";

    public static boolean integerPositive(String number) {
        return Pattern.matches(REG_EXP_POSITIVE_INTEGER, number);
    }
}
