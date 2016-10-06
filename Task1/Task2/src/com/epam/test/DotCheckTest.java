package com.epam.test;

import com.epam.data.Graph;
import com.epam.logic.DotCheck;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Лыско on 25.09.2016.
 */
public class DotCheckTest {
    Graph graph;

    @DataProvider(name = "dot")
    public static Object[][] dot() {
        return new Object[][]{
                {4.0, 2.5, true},
                {-5.0, 5.0, true},
                {7.0, -3.0, true},
                {6.0, 5.0, false},
                {-5.5, -5.5, false}
        };
    }

    @BeforeMethod
    public void setUp() throws Exception {
        graph = new Graph(5.0, -5.0, 10.0, 14.0);    //y(-5, 5) xTop(-5,5) xBottom(-7,7)
    }

    @Test(dataProvider = "dot")
    public void testDotBelongsToGraph(double x, double y, boolean expected) throws Exception {

        Assert.assertEquals(DotCheck.dotBelongsToGraph(graph, x, y),expected);
    }

}