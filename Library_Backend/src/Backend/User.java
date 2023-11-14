package Backend;

import ExceptionsPack.BookNotAvailableException;
import ExceptionsPack.CheckoutExceptions;
import ExceptionsPack.OverdueBooksCheckoutException;

import java.util.LinkedList;

public class User {
    String userName;
    int libraryNum;
    private String password;
    LinkedList<Book> borrowedBooks;
    private boolean hasOverdueBooks;

    public User() {
    }

    public User(String name, int libraryNum, String password) {
        this.userName = name;
        this.libraryNum = libraryNum;
        this.password = password;
        this.borrowedBooks = new LinkedList<Book>();
        this.hasOverdueBooks = false;
    }

    public String toString() {
        return this.userName;
    }

    private void borrowBook(Book book) {
        try {
            if (book.getStatus() == Book.Status.BORROWED)
                throw new BookNotAvailableException();
            if (this.hasOverdueBooks)
                throw new OverdueBooksCheckoutException();
            book.setOwnerNumber(this.libraryNum);
            book.setStatus(Book.Status.BORROWED);
            this.borrowedBooks.add(book);
        } catch(CheckoutExceptions ex) {
            System.out.println(ex);
        }
    }

    private void returnBook(Book book) {
        this.borrowedBooks.remove(book);
        book.setOwnerNumber(null);
        book.setStatus(Book.Status.AVAILABLE);
    }

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

    public boolean isHasOverdueBooks() {
        return hasOverdueBooks;
    }

    public void setHasOverdueBooks(boolean hasOverdueBooks) {
        this.hasOverdueBooks = hasOverdueBooks;
    }
}
