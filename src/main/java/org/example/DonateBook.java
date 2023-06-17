package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class DonateBook {
    private ArrayList<Book> books;
    private Scanner scanner;

    public DonateBook(ArrayList<Book> books) {
        this.books = books;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("\nEnter the title of the book you want to donate or 'Q' to quit:");
        String title = scanner.nextLine();
        if (title.equalsIgnoreCase("Q")) {
            return;
        }
        books.add(new Book(title));
        System.out.println("Thank you! You've successfully donated the book: " + title);
    }
}

