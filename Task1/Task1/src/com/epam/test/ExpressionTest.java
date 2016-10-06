package com.epam.test;

import com.epam.data.Expression;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Лыско on 25.09.2016.
 */
public class ExpressionTest {

    @DataProvider(name = "dataXoY")
    public static Object[][] dataXoY() {
        return new Object[][]{
                {0.0, 0.0, 0.5},
                {1.0, -1.0, 1.5}
        };
    }

    @Test(dataProvider = "dataXoY")
    public void testCount(double x, double y, double expected) {
        System.out.println(Expression.count(x, y) + " actual " + expected + " expected");
        Assert.assertEquals(Expression.count(x, y), expected);
    }

}