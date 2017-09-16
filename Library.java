/*
MIT Open Courseware 6.092 Assignment 4
https://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-092-introduction-to-programming-in-java-january-iap-2010/assignments/MIT6_092IAP10_assn04.pdf

This file represents a library catalog. All libraries are open between the hours
of 9 and 5, but they contain different addresses and book collections. Books may
be added to the catalog, borrowed, and returned. A method returning a list of
all available books is also included.
*/


import java.util.ArrayList;


public class Library {

    String libraryAddress;
    ArrayList<Book> books;

    //creates a new instance of a Library taking the address as the parameter
    public Library(String library_location){

      libraryAddress = library_location;
      books = new ArrayList<Book>(); //instatiates a catalog in which to store books

    }

    //add a book to the catalog
    public void addBook(Book newbook){

      books.add(newbook);

    }

    public static void printOpeningHours(){

      System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public void printAddress(){

      System.out.println(libraryAddress);
    }

/* method for borrowing a book. We iterate through the books catalog to check
for a book with the same title as the book we are trying to borrow. If the
titles are identical, we check if the book is borrowed. If it's not borrowed, we
borrow the book. If it is borrowed, we alert the user. If the book doesn't
exist in the catalog, we alert the user. We return a null to exit the method
each time we arrive at one of these 3 outcomes.
*/
    public String borrowBook(String bookBorrowed){

      for (int i = 0; i<books.size(); i++){

        if(books.get(i).getTitle().equals(bookBorrowed)){

          if(!books.get(i).isBorrowed()){
            books.get(i).borrowed();
            System.out.println("You successfully borrowed " +
            bookBorrowed);
            return null;
          }
          else {
            System.out.println("Sorry, this book is already borrowed.");
            return null;
          }
        }
      }

      System.out.println("Sorry, this book is not in our catalong.");
      return null;

    }

/* To return a book, we iterate through the books catalog in search of a book
with an identical title to the book we are trying to return. If the book is
borrowed, we call the returned() method from the Book class to indicate the book
as available in the catalog. If the book was not checked out, we alert the user
and the book remains available. If the book isn't in the catalog, we alert the
user. As in the borrowBook method we return a null at each conclusion
terminating the process.
*/
    public String returnBook(String bookReturned){

      for (int i = 0; i < books.size(); i++){

        if (books.get(i).getTitle().equals(bookReturned)){

          if (books.get(i).isBorrowed()){

            books.get(i).returned();
            System.out.println("You successfully returned " + bookReturned);
            return null;

          }
          else {
            System.out.println("Book was not checked out.");
            return null;
          }
        }
      }

      System.out.println("Book not found in catalog.");
      return null;

    }

/* Method for printing a list of all the non-borrowed books in the catalog. If
the library is empty, we alert the user. If not, each book is iterated through,
the borrowed status is checked, and the title is printed if the book is
available.
*/
    public void printAvailableBooks(){

      if (!(books.size() == 0)){

        for (int i = 0; i<books.size(); i++){

          if (!(books.get(i).isBorrowed())){
            System.out.println(books.get(i).getTitle());
          }
        }
      }
      else{
        System.out.println("Library is empty.");
      }
    }


    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
