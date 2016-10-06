package com.epam.logic;

import com.epam.data.Book;

import java.util.Comparator;

/**
 * Created by Andrei_Lysko on 9/25/2016.
 */
public class BookComparator {

    public static Comparator<Book> getComparatorTitle() {
        return comparatorTitle;
    }

    public static Comparator<Book> getComparatorTitleAuthor() {
        return comparatorTitleAuthor;
    }

    public static Comparator<Book> getComparatorAuthorTitle() {
        return comparatorAuthorTitle;
    }

    public static Comparator<Book> getComparatorAuthorTitlePrice() {
        return comparatorAuthorTitlePrice;
    }

    private static final Comparator<Book> comparatorTitle = new Comparator<Book>() {

        @Override
        public int compare(Book book1, Book book2) {
            return book1.getTitle().compareTo(book2.getTitle());
        }

    };

    private static final Comparator<Book> comparatorTitleAuthor = new Comparator<Book>() {

        @Override
        public int compare(Book book1, Book book2) {
            int result = book1.getTitle().compareTo(book2.getTitle());
            if(result != 0){
                return result;
            }
            result = book1.getAuthor().compareTo(book2.getAuthor());
            return result;
        }
    };

    private static final Comparator<Book> comparatorAuthorTitle = new Comparator<Book>() {

        @Override
        public int compare(Book book1, Book book2) {
            int result = book1.getAuthor().compareTo(book2.getAuthor());
            if(result != 0){
                return result;
            }
            result = book1.getTitle().compareTo(book2.getTitle());
            return result;
        }
    };

    private static final Comparator<Book> comparatorAuthorTitlePrice = new Comparator<Book>() {
        @Override
        public int compare(Book book1, Book book2) {
            int result = book1.getAuthor().compareTo(book2.getAuthor());
            if(result != 0){
                return result;
            }
            result = book1.getTitle().compareTo(book2.getTitle());
            if(result != 0){
                return result;
            }
            if (book1.getPrice() == book2.getPrice()){
                return 0;
            }
            if (book1.getPrice() < book2.getPrice()){
                return -1;
            }
            else {
                return 1;
            }
        }
    };

}
