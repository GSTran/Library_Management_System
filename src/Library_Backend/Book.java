package Library_Backend;
public class Book {
    String title;
    String author;
    String isbn;
    Status status;
    private Integer ownerNumber;
    public enum Status {
        BORROWED,
        ON_HOLD,
        AVAILABLE;
    }

    public Book() {
    }

    public Book(String title, String author, String isbn, Integer ownerNumber) {
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

    public String toString() {
        return this.title;
    }

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
