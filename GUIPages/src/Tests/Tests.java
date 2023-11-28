package Tests;

import Backend.Book;
import Backend.Library;
import Backend.User;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void singletonLibrary() {
        Library library = Library.getInstance();
        Library library2 = library;

        assertEquals(library, library2);

        library2 = Library.getInstance();

        assertEquals(library, library2);
    }

    @Test
    public void addUsers() {
        Library lib = Library.getInstance();
        lib.addUser("John", "P@ssword1");
        lib.addUser("Bon", "P4ssword!");
        assertEquals("John", lib.users.get(0).getUserName());
        assertEquals("Bon", lib.users.get(1).getUserName());
        lib.users.clear();
    }

    @Test
    public void loginTest() {
        Library library = Library.getInstance();
        library.addUser("John", "P@ssword1");
        library.addUser("Bon", "P4ssword!");

        assertEquals(true, library.validateLogin(library.users.get(0).getUserName(), "P@ssword1"));
        library.users.clear();
    }

    @Test
    public void checkSortByAlphabet() {
        Library library = Library.getInstance();

        library.addBook("B", "Author", "8120223180");
        library.addBook("C", "Author", "8124508180");
        library.addBook("A", "Author", "8129008180");

        LinkedList<Book> sortedList;
        sortedList = library.sortBooksByAlphabetical(library.books);

        assertEquals("A", sortedList.get(0).title);
        assertEquals("B", sortedList.get(1).title);
        assertEquals("C", sortedList.get(2).title);

        library.books.clear();
    }

    @Test
    public void checkSearchByString() {
        Library library = Library.getInstance();

        library.addBook("BAM", "Author", "8120223180");
        library.addBook("C", "Author", "8124508180");
        library.addBook("AM", "Author", "8129008180");

        LinkedList<Book> results;
        results = library.searchBookByString("AM");

        assertEquals("BAM", results.get(0).title);
        assertEquals("AM", results.get(1).title);

        library.books.clear();
    }

    @Test
    public void booksOwnedByUserTest() {
        Library library = Library.getInstance();

        library.addBook("BAM", "Author", "8120223180");
        library.addBook("C", "Author", "8124508180");
        library.addBook("AM", "Author", "8129008180");

        User newUser = new User("Dan", 37463197, "TheMan", false);
        library.addUser(newUser);

        newUser.borrowBook(library.getBook("8120223180"));
        newUser.borrowBook(library.getBook("8124508180"));
        newUser.borrowBook(library.getBook("8129008180"));

        library.currentUser = newUser;
        library.booksOwnedByUser(37463197);

        assertEquals("BAM", newUser.borrowedBooks.get(0).title);
        assertEquals("C", newUser.borrowedBooks.get(1).title);
        assertEquals("AM", newUser.borrowedBooks.get(2).title);

        library.users.clear();
        library.books.clear();
    }
}
