import java.util.ArrayList;

public class Library {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Book> books = new ArrayList<Book>();

    void readFile(String file) {

    }
    void writeFile(String file) {

    }

    void addUser(String name, int libraryNum, String password) {
        users.add(new User(name, libraryNum, password));
    }

    void addBook(String title, String author, String isbn, Book.Status status) {
        books.add(new Book(title, author, isbn, status));
    }

    void removeBook(String isbn) {
    }

    void removeUser(User us) {

    }

    User getUser(int userNum) {
        return new User();
    }

    Book getBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (this.books.get(i).isbn == isbn)
                return this.books.get(i);
        }

        return null;
    }
}
