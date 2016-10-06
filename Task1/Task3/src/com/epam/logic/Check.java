package com.epam.logic;

import java.util.regex.Pattern;

/**
 * Created by Andrei_Lysko on 9/20/2016.
 */
public class Check {
    private static final String REG_EXP_DOUBLE = "[+-]?[0-9]+([\\.][0-9]+)?";
    private static final String REG_EXP_DOUBLE_POSITIVE = "[0-9]+([\\.][0-9]+)+";

    public static boolean doubleNumber(String number) {

        return Pattern.matches(REG_EXP_DOUBLE, number);
    }

    public static boolean doublePositive(String number) {

        return Pattern.matches(REG_EXP_DOUBLE_POSITIVE, number);
    }
}
