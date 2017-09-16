/*
MIT Open Courseware 6.092 Assignment 4
https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/assignments/MIT6_092IAP10_assn04.pdf

This file represents a book that exists in a library catalog. Library.java
may be found in the same package. Each book's title and checked status is stored
as fields.
*/

public class Book {

    String title;
    boolean borrowed;

    // Creates a new Book
    public Book(String bookTitle) {
        title = bookTitle;
        borrowed = false;
    }

    // Marks the book as rented
    public void borrowed() {
        borrowed = true;
    }

    // Marks the book as not rented
    public void returned() {
        borrowed = false;
    }

    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        return borrowed;
    }

    // Returns the title of the book
    public String getTitle() {
        return title;
    }

    public static void main(String ... arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());

    }
}
