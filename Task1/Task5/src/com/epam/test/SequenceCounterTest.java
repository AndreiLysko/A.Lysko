package com.epam.test;

import com.epam.logic.SequenceCounter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


/**
 * Created by Лыско on 25.09.2016.
 */
public class SequenceCounterTest {
    @DataProvider(name = "dataForSubseq")
    public static Object[][] dataForSubseq() {
        return new Object[][]{
                {new int[]{3,7,2,85,56,12,24}, 3},
                {new int[]{55,6,9,11,12,24}, 1},
                {new int[]{13,24,5,14,24}, 2}
        };
    }

    @Test(dataProvider = "daraForSubseq")
    public void testGetMaxSubsequenceLength(int[] sequence, int expected) throws Exception {
        SequenceCounter counter = new SequenceCounter();
        counter.maxSubsequenceSearch(sequence);
        Assert.assertEquals(counter.getMaxSubsequenceLength(),expected);
    }

    @DataProvider(name = "dataForCalc")
    public static Object[][] dataForCalc() {
        return new Object[][]{
                {new int[]{3,7,2,85,56,12,24}, 5},
                {new int[]{55,6,9,11,12,24}, 5},
                {new int[]{13,24,5,14,24}, 3}
        };
    }

    @Test
    public void testCalculateMaxLength(int[] sequence, int expected) throws Exception {
        SequenceCounter counter = new SequenceCounter();
        Assert.assertEquals(counter.calculateMaxLength(sequence),expected);
    }

}