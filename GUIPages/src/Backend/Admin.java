package Backend;

public class Admin extends User{
    public void addUser(Library li, String name, String password) {
        li.addUser(name, password);
    }

    public void addBook(Library li, String title, String author, String isbn, Integer ownerNumber) {
        li.addBook(title, author, isbn, ownerNumber);
    }

    public void removeBookbyISBN(Library li, String isbn) {
        li.removeBook(isbn);
    }
}
