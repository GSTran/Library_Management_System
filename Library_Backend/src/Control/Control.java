package Control;

import Backend.Library;
import GUIPages.LoginGUI;

public class Control {
    public Control() {
    }

    public static void main(String[] args) {
        LoginGUI login = new LoginGUI();
        login.initializeElements();
        Library library = Library.getInstance();
        library.initializeBooks("books");
        library.initializeUsers("users");
    }

    public void addUser(String var1, String var2) {
        throw new Error("Unresolved compilation problem: \n\tThe method addUser(String, int, String) in the type Library is not applicable for the arguments (String, String)\n");
    }
}