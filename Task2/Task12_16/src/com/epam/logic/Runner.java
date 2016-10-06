package com.epam.logic;

import com.epam.data.Book;
import com.epam.data.ProgrammerBook;

public class Runner {

    public static void main(String[] args) throws CloneNotSupportedException {

        ProgrammerBook book1 = new ProgrammerBook();
        ProgrammerBook book2 = new ProgrammerBook();
        book1.setAuthor("Au1");
        book1.setTitle("Br");
        book1.setPrice(150);
        book1.setLanguage("ENG");
        book1.setLevel(2);
        System.out.println(book1.toString());
        book2.setAuthor("Au1");
        book2.setTitle("Br");
        book2.setPrice(150);
        book2.setLanguage("ENG");
        book2.setLevel(2);
        System.out.println(book2.toString());
        System.out.println(book1.equals(book2));
        System.out.println(book1.hashCode() + " " + book2.hashCode());
        book2.setLanguage("AUS");
        System.out.println(book2.toString());
        System.out.println(book1.equals(book2));
        System.out.println(book1.hashCode() + " " + book2.hashCode());
        Book clone = book1.clone();
        System.out.println(clone.toString());
    }
}
