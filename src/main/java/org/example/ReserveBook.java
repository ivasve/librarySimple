package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class ReserveBook {
    private ArrayList<Book> books;
    private Scanner scanner;

    public ReserveBook(ArrayList<Book> books) {
        this.books = books;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            showBooks();
            System.out.println("Enter the number of the book you want to reserve, 'M' to go back to the main menu, or 'Q' to quit:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("Q")) {
                System.out.println("Thank you! Goodbye.");
                System.exit(0);
            } else if (input.equalsIgnoreCase("M")) {
                break; // break the loop and go back to the main menu
            } else {
                try {
                    int bookNumber = Integer.parseInt(input);
                    if (bookNumber < 1 || bookNumber > books.size()) {
                        System.out.println("Invalid number. Please try again.");
                    } else if (books.get(bookNumber - 1).isReserved) {
                        System.out.println("The book is already reserved.");
                    } else {
                        books.get(bookNumber - 1).isReserved = true;
                        System.out.println("You've successfully reserved the book: " + books.get(bookNumber - 1).title);
                        System.out.println("Do you want to reserve another book? 'Yes' or 'No'.");
                        String inputAnotherBook = scanner.nextLine();
                        if(inputAnotherBook.equalsIgnoreCase("Yes")){
                            System.out.println("Reserve another book.");
                        }else if(inputAnotherBook.equalsIgnoreCase("No")){
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number, 'M' to go back to the main menu, or 'Q' to quit.");
                }
            }
        }
    }

    private void showBooks() {
        System.out.println("\nHere are the books available:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println((i + 1) + ". " + book.title + " (Reserved: " + book.isReserved + ")");
        }
    }
}


