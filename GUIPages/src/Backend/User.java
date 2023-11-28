package Backend;

import ExceptionsPack.BookNotAvailableException;
import ExceptionsPack.CheckoutExceptions;

import java.util.LinkedList;

public class User {
    public String userName; // Username that is set during user registration
    public int libraryNum; // Library number
    private String password; // Password that is set during user registration
    public LinkedList<Book> borrowedBooks; // List of books borrowed by this user.
    public boolean isAdmin; // Determines whether user receives admin privileges

    // Default User constructor
    public User() {
    }

    /*
    User constructor with name, libraryNum, password, and isAdmin parameter.
    Used for creating users after registration and loading from file.
     */
    public User(String name, int libraryNum, String password, boolean isAdmin) {
        this.userName = name;
        this.libraryNum = libraryNum;
        this.password = password;
        this.borrowedBooks = new LinkedList<Book>();
        this.isAdmin = isAdmin;
    }

    public void editUser(String name, int libraryNum, String password, boolean isAdmin) {
        this.userName = name;
        this.libraryNum = libraryNum;
        this.password = password;
        this.borrowedBooks = new LinkedList<Book>();
        this.isAdmin = isAdmin;
    }

    /*
    Grants admin privileges to this user.
    Should only be granted by another admin in the GUI.
     */
    public void grantAdmin() {
        this.isAdmin = true;
    }

    // Returns this user's username
    public String toString() {
        return this.userName;
    }

    /*
    This method allows users to borrow books from the library.
     */
    public void borrowBook(Book book) {
        try {
            if (book.getStatus() == Book.Status.BORROWED) // Checks if the book is currently being borrowed by someone else
                throw new BookNotAvailableException();
            book.setOwnerNumber(this.libraryNum); // If no one is borrowing the book, it sets the book's owner to this user
            book.setStatus(Book.Status.BORROWED); // Changes status of the book to borrowed
            this.borrowedBooks.add(book);
        } catch(CheckoutExceptions ex) {
            System.out.println(ex);
        }
    }

    /*
    This method allows users to return books they are currently borrowing.
 */
    public boolean returnBook(Book book) {
        if (book.ownerNumber != this.libraryNum) { // Checks if the book's owner is this user
            System.out.println("Not allowed to return other people's books!");
            return false;
        }
        this.borrowedBooks.remove(book);
        book.setOwnerNumber(0); // Sets user owner to 0, meaning no owner
        book.setStatus(Book.Status.AVAILABLE);
        return true;
    }

    // All methods after this are setters and getters

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getLibraryNum() {
        return libraryNum;
    }

    public void setLibraryNum(int libraryNum) {
        this.libraryNum = libraryNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LinkedList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(LinkedList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
