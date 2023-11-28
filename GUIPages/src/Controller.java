import Backend.Library;

public class Controller {
    public static void main(String[] args) {
        //Starts the application login page
        LoginGUI login = new LoginGUI();
        //Accesses the library Singelton
        Library library = null;
        library = library.getInstance();

        //initializes the lists of users and books from the stored files
        library.initializeUsers("Users");
        library.initializeBooks("Books");

        //final instance of the library
        Library finalLibrary = library;

        //saves all lists of users and books into files upon application shut down
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                finalLibrary.saveUsers("Users");
                finalLibrary.saveBooks("Books");
            }
        });
    }
}
