package org.example;

import java.util.ArrayList;

public class ShowMyBooks {
    private ArrayList<Book> books;
    public ShowMyBooks(ArrayList<Book> books) {
        this.books = books;
    }
    public void run(){
        boolean foundReservedBook = false;
        for (Book book : books) {
            if (book.isReserved) {
                System.out.println(book.title);
                foundReservedBook = true;
            }
        }

        if (!foundReservedBook) {
            System.out.println("You haven't reserved any books.");
        }
    }
}
