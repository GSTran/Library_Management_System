package Control;
import GUIPages.LoginGUI;
import GUIPages.BookViewGUI;
import GUIPages.MainScreenGUI;
import GUIPages.UserViewGUI;
import Library_Backend.Library;
import Library_Backend.Book;
import Library_Backend.User;
import Library_Backend.Admin;


public class Control {
	public Control(){
		
	}
	
	public static void main(String[] args) {
		LoginGUI login = new LoginGUI();
		login.initializeElements();
		Library library;
		library = Library.getInstance();
		library.initializeBooks("books");
		library.initializeUsers("users");		
	}
	
	public void addUser(String name, String password) {
		Library library;
		library = Library.getInstance();
		library.addUser(name, password);
	}
}