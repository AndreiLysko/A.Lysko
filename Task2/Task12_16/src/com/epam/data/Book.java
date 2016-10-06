package com.epam.data;

/**
 * Created by Andrei_Lysko on 9/23/2016.
 */
public class Book implements Cloneable,Comparable<Book>{

    private String title;
    private String author;
    private int price;
    private static int edition;
    private int isbn;

    public Book() {
    }

    public Book(int isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public static void setEdition(int edition) {
        Book.edition = edition;
    }

    public static int getEdition() {
        return edition;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book book = (Book) obj;
        if (this.title == null) {
            if (book.title != null) {
                return false;
            }
        }
        if (!this.title.equals(book.title)) {
            return false;
        }
        if (this.author == null) {
            if (book.author != null) {
                return false;
            }
        }
        if (!this.author.equals(book.author)) {
            return false;
        }
        return edition == edition;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getEdition();
        result = prime * result + getPrice();
        result = prime * result + getAuthor().hashCode();
        result = prime * result + getTitle().hashCode();
        return result;

    }

    @Override
    public String toString() {
        return getClass().getName() +
                " @ Title: " + getTitle() +
                " Author: " + getAuthor() +
                " Price: " + String.valueOf(getPrice()) +
                " Edition: " + String.valueOf(getEdition());
    }

    @Override
    public Book clone() throws CloneNotSupportedException {
        Book obj = (Book)super.clone();
        return obj;
    }

    @Override
    public int compareTo(Book anotherBook){
        int anotherISBN = anotherBook.getIsbn();
        return this.isbn - anotherISBN;
        }

}

