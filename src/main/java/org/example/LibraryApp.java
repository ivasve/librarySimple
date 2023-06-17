package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    private ArrayList<Book> books;
    private ReserveBook reserveBook;
    private ReturnBook returnBook;
    private DonateBook donateBook;
    private ShowMyBooks showReservedBook;
    private Scanner scanner;

    public LibraryApp() {
        books = new ArrayList<>();
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

        reserveBook = new ReserveBook(books);
        returnBook = new ReturnBook(books);
        donateBook = new DonateBook(books);
        showReservedBook = new ShowMyBooks(books);
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Reserve a book");
            System.out.println("2. Return a book");
            System.out.println("3. See my reserved books");
            System.out.println("4. Donate a book");
            System.out.println("Enter 'Q' to quit.");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    reserveBook.run();
                    break;
                case "2":
                    returnBook.run();
                    break;
                case "3":
                    showReservedBook.run();
                    break;
                case "4":
                    donateBook.run();
                    break;
                case "Q":
                case "q":
                    System.out.println("Thank you! Goodbye.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please choose 1, 2, 3 or 4, or enter 'Q' to quit.");
                    break;
            }
        }
    }

//    private void showReservedBooks() {
//        System.out.println("\nHere are your reserved books:");
//        for (Book book : books) {
//            if (book.isReserved) {
//                System.out.println(book.title);
//            }
//        }
//    }
}



