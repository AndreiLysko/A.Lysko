package com.epam.test;

import com.epam.data.Massive;
import com.epam.logic.MassiveCheck;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



/**
 * Created by Лыско on 25.09.2016.
 */
public class MassiveCheckTest {

    @DataProvider(name = "numbers")
    public static Object[][] numbers() {
        return new Object[][]{
                {3,true},
                {7,true},
                {10,false},
                {15,false},
                {37,true}
        };
    }

    @Test(dataProvider = "numbers")
    public void testIsPrime(int number, boolean expected) throws Exception {
        Assert.assertEquals(MassiveCheck.isPrime(number),expected);
    }

    @DataProvider(name = "massiveData")
    public static Object[][] Name() {
        return  new Object[][]{
                {new int[]  {3,5,8,9,11},new int[]{0,1,4}},
                {new int[]  {4,6,8,9,12},new int[]{}},
                {new int[]  {2,44,55,100,101}, new int[]{0,4}}
        };
    }

    @Test(dataProvider = "massiveData")
    public void testCheckPrimes(int[] massive, int[] expectedIndexes) throws Exception {
        Massive mas = new Massive();
        mas.setSizeOfMassive(massive.length);
        mas.setMassive(massive);
        MassiveCheck.checkPrimes(mas);
        int[] actual = mas.getPrimeIndexes();
        Assert.assertEquals(actual,expectedIndexes);
    }

}