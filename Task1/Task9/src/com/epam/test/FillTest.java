package com.epam.test;

import com.epam.data.Ball;
import com.epam.data.Basket;
import com.epam.data.Color;
import com.epam.logic.Fill;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.*;

/**
 * Created by Лыско on 25.09.2016.
 */
public class FillTest {
    ArrayList<Ball> balls = new ArrayList<>();
    @BeforeMethod
    public void setUp() throws Exception {

        balls.add(new Ball(1.5, Color.BLUE));
        balls.add(new Ball(1.9, Color.RED));
        balls.add(new Ball(0.2, Color.YELLOW));
        balls.add(new Ball(2.6, Color.BLUE));
        balls.add(new Ball(1.5, Color.GREEN));
        balls.add(new Ball(0.4, Color.BLUE));

    }

    @DataProvider(name = "ballsWeight")
    public static Object[][] ballsWeight() {
        return new Object[][]{
                {16.2}
        };
    }

    @DataProvider(name = "ballsCount")
    public static Object[][] ballsCount() {
        return new Object[][]{
                {3}
        };
    }

    @Test(dataProvider = "ballsWeight")
    public void testTotalWeight(double expected) throws Exception {
        Basket basket = new Basket();
        Fill.basketIn(basket,balls);
        Assert.assertEquals(Fill.totalWeight(basket),expected);
    }

    @Test(dataProvider = "ballsCount")
    public void testTotalBlues(int expected) throws Exception {
        Basket basket = new Basket();
        Fill.basketIn(basket,balls);
        Assert.assertEquals(Fill.totalBlues(basket),expected);
    }

}