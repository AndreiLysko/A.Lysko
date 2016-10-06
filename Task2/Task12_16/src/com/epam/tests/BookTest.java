package com.epam.tests;

import com.epam.data.Book;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Andrei_Lysko on 9/25/2016.
 */
public class BookTest {

    @DataProvider(name = "dpBooks")
    public static Object[][] dpBooks() {
        return new Object[][]{
                {new Book(1),new Book(2),-1},
                {new Book(7),new Book(-2), 1},
                {new Book(3),new Book(3), 0}
        };
    }

    @Test
    public void testCompareTo(Book book1,Book book2, int expected) throws Exception {
        int actual = -100;
        if (book1.compareTo(book2) == 0){
            actual = 0;
        }
        if (book1.compareTo(book2) > 0){
            actual = 1;
        }
        if (book1.compareTo(book2) < 0){
            actual = -1;
        }
        Assert.assertEquals(actual,expected);
    }

}