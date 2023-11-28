package Backend;

public class Book {
    public String title;    // Title of the book
    public String author;   // The author of the book
    public String isbn;     // The international standard book number
    public Status status;   // The status of the book
    public Integer ownerNumber; // The library number of the owner of the book
    public enum Status {
        BORROWED,   // This means someone is borrowing the book
        ON_HOLD,    // This means someone has the book on hold (Not implemented)
        AVAILABLE;  // This means no one is borrowing this book
    }

    // Default constructor for a book
    public Book() {
    }

    // Constructor for a book with title, author, isbn, and ownerNumber parameters
    // Used for initializing books from file
    public Book(String title, String author, String isbn, Integer ownerNumber) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.ownerNumber = ownerNumber;
        if (ownerNumber == 0) {     // Means that nobody is borrowing the book
            this.status = Status.AVAILABLE;
        }
        if (ownerNumber != 0) {     // Means that somebody is borrowing the book
            this.status = Status.BORROWED;
        }
    }

    // Constructor for a book with title, author, and isbn parameters
    // Used for new books
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.ownerNumber = 0;   // Since book is new, nobody owns it
        this.status = Status.AVAILABLE; // Set status to available
    }

    // Method that is used for editing a book
    public void change(String title, String author, String isbn, Integer ownerNumber) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.ownerNumber = ownerNumber;
        if (ownerNumber == null) {
            this.status = Status.AVAILABLE;
        }
        if (ownerNumber != null) {
            this.status = Status.BORROWED;
        }
    }

    // Method that returns the title of this book
    public String toString() {
        return this.title;
    }

    // All methods after are basic setters and getters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getOwnerNumber() {
        return ownerNumber;
    }

    public void setOwnerNumber(Integer ownerNumber) {
        this.ownerNumber = ownerNumber;
    }

}
