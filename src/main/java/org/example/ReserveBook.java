package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
    ArrayList<Book> books;
    Scanner scanner;

    BookStore() {
        // Initialize the ArrayList of books with specific titles
        this.books = new ArrayList<>();
        books.add(new Book("Ten brothers"));
        books.add(new Book("Nice day"));
        books.add(new Book("How are you?"));
        books.add(new Book("Where is the pilot?"));
        books.add(new Book("That's not nice"));
        books.add(new Book("Six dogs and a cat"));
        books.add(new Book("Tomorrow is today"));
        books.add(new Book("Almost there"));
        books.add(new Book("Not sure what's next"));
        books.add(new Book("Finally, the end"));
        this.scanner = new Scanner(System.in);
    }

    void run() {
        while (true) {
            // Print the list of books
            printBooks();
            reserveBook();
        }
    }

    void printBooks() {
        System.out.println("Here are the books available:");
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    void reserveBook() {
        while (true) {
            System.out.println("Enter the number of the book you want to reserve or 'Q' to quit:");

            // Read the book number or quit command
            String input = scanner.nextLine();

            if ("Q".equalsIgnoreCase(input)) {
                System.out.println("Exiting the program. Thank you!");
                System.exit(0);
            }

            // Try to parse the book number and reserve the book
            try {
                int bookNumber = Integer.parseInt(input) - 1;

                // Validate the book number
                if (bookNumber < 0 || bookNumber >= books.size()) {
                    System.out.println("Invalid book number. Please try again.");
                    continue;
                }

                Book book = books.get(bookNumber);
                if (book.isReserved) {
                    System.out.println("The book is already reserved. Please try again.");
                } else {
                    book.isReserved = true;
                    System.out.println("You have successfully reserved the book.");
                    System.out.println("Do you want to reserve another book? Enter 'Yes' or 'No':");
                    String response = scanner.nextLine();
                    if ("No".equalsIgnoreCase(response)) {
                        System.out.println("You have chosen not to reserve another book.");
                        System.out.println("Press any key to continue or 'Q' to quit:");
                        String quitKey = scanner.nextLine();
                        if ("Q".equalsIgnoreCase(quitKey)) {
                            System.out.println("Exiting the program. Thank you!");
                            System.exit(0);
                        }
                    }
                    break; // Breaks the loop if a book was reserved successfully
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid book number or 'Q' to quit.");
            }
        }
    }

    void addBook(String title) {
        books.add(new Book(title));
    }
}

