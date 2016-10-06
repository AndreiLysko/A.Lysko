package com.epam.test;

import com.epam.logic.Generator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Лыско on 26.09.2016.
 */
public class GeneratorTest {

    @DataProvider(name = "data")
    public static Object[][] data() {
        return  new Object[][]{
                {new double[] {1,2,3}, new double[][]{{1,2,3},{2,3,1},{3,1,2}}}
        };

    }

    @Test(dataProvider = "data")
    public void testGenerateMatrix(double[] data, double[][] expected) throws Exception {
        Generator generator = new Generator();
        generator.generateMatrix(data);
        Assert.assertEquals(generator.getMatrix(),expected);
    }

}