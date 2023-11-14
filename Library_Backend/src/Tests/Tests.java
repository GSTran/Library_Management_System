package Tests;

import Backend.Library;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    public void loginTest() {
        Library library = Library.getInstance();
        library.addUser("John", "P@ssword1");
        library.addUser("Bon", "P4ssword!");

        assertEquals(true, library.validateLogin(library.users.get(0).getLibraryNum(), "P@ssword1"));
        library = null;
    }
}
