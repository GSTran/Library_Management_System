public class User {
    String name;
    int libraryNum;
    String password;

    User() {
    }

    User(String name, int libraryNum, String password) {
        this.name = name;
        this.libraryNum = libraryNum;
        this.password = password;
    }

    void borrowBook(Book book) {

    }

    Book returnBook(int what) {
        return new Book();
    }
}
