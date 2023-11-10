public class Admin extends User{
    public void addUser(Library li, String name, int libraryNum, String password) {
        li.addUser(name, libraryNum, password);
    }

    public void addBook(Library li, String title, String author, String isbn, Book.Status status) {
        li.addBook(title, author, isbn, status);
    }

    public void removeBookbyISBN(Library li, String isbn) {
        li.removeBook(isbn);
    }
}
