package org.example;

public class Book {
    String title;
    boolean isReserved;

    Book(String title) {
        this.title = title;
        this.isReserved = false;
    }

    @Override
    public String toString() {
        return title + " (Reserved: " + isReserved + ")";
    }
}

