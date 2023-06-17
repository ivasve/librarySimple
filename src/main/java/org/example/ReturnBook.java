package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnBook {
    private ArrayList<Book> books;
    private Scanner scanner;

    public ReturnBook(ArrayList<Book> books) {
        this.books = books;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nEnter the number of the book you want to return or 'Q' to quit:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                break;
            }
            try {
                int bookNumber = Integer.parseInt(input);
                if (bookNumber < 1 || bookNumber > books.size()) {
                    System.out.println("Invalid number. Please try again.");
                } else if (!books.get(bookNumber - 1).isReserved) {
                    System.out.println("The book is not reserved.");
                    break;
                } else {
                    books.get(bookNumber - 1).isReserved = false;
                    System.out.println("You've successfully returned the book: " + books.get(bookNumber - 1).title);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}

