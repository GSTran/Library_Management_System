package Backend;

import ExceptionsPack.LoginException;
import ExceptionsPack.NoMatchingNumberException;
import ExceptionsPack.PasswordNotValidException;

import java.io.*;
import java.util.*;

public class Library {
    public LinkedList<User> users; // List of users registered in the library
    public LinkedList<Book> books; // List of books the library currently has to offer
    private static Library uniqueInstance; // Singleton library instance
    public User currentUser; // User who is currently logged in

    /*
    Singleton library constructor that can only be accessed by the getInstance() method
     */
    private Library() {
        this.users = new LinkedList<User>();
        this.books = new LinkedList<Book>();
        this.currentUser = null;
    }

    // Method that retrieves a singleton instance of library
    public static Library getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Library();
        }
        return uniqueInstance;
    }

    /*
    Method that saves books read from a file to the books attribute in library
     */
    public void initializeBooks(String file) {
        LinkedList<Book> savedBooks = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) { // Continues reading from the file while the line being read is not null
                StringTokenizer tokenizer = new StringTokenizer(line);
                if (tokenizer.countTokens() == 4) { // Counts the next 4 tokens
                    String title = tokenizer.nextToken(); // The next token is the title
                    String author = tokenizer.nextToken(); // The next token is the author
                    String isbn = tokenizer.nextToken(); // The next token is the isbn
                    Integer ownerNumber = Integer.valueOf(tokenizer.nextToken()); // The next token is the owner number
                    savedBooks.add(new Book(title, author, isbn, ownerNumber));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.books = savedBooks; // Saves all books initialized to the books attribute
    }

    /*
    Method that saves users read from a file to the users attribute in library
     */
    public void initializeUsers(String file) {
        LinkedList<User> accounts = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) { // Continues reading from the file while the line being read is not null
                StringTokenizer tokenizer = new StringTokenizer(line);
                if (tokenizer.countTokens() == 4) { // Counts the next 4 tokens
                    String userName = tokenizer.nextToken(); // The next token is the username
                    int libraryNum = Integer.parseInt(tokenizer.nextToken()); // The next token is the library number
                    String password = tokenizer.nextToken(); // The next token is the password
                    boolean isAdmin = Boolean.parseBoolean(tokenizer.nextToken()); // The next token is admin status
                    accounts.add(new User(userName, libraryNum, password, isAdmin));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.users = accounts; // Saves all users initialized to the users attribute
    }

    // Method that saves all users to a file
    public void saveUsers(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (User storedAccount : users)
                writer.write(storedAccount.userName + " " + storedAccount.libraryNum + " " // Saves user by recording each of their
                        + storedAccount.getPassword() + " " + storedAccount.isAdmin + "\n");   // attributes to the same line
        } catch (IOException ex) {                                                             // a new line is created for the next user
            ex.printStackTrace();
        }
    }

    // Method that saves all books to a file
    public void saveBooks(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book storedBooks : books)                                              // Saves book by recording each of their
                writer.write(storedBooks.title + " " + storedBooks.author + " "     // attributes to the same line
                        + storedBooks.isbn + " " + storedBooks.ownerNumber + "\n");     // a new line is created for the next book
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Validates user credentials submitted into the login text fields in the GUI
    public boolean validateLogin(String userName, String password) {
        User account = this.findUser(userName); // Searches the user by username
        if (account == null) {  // If the user doesn't exist, return false
            return false;
        }
        try {   // If the user does exist, check if the password matches
            if (password.equals(account.getPassword()))
                return true;
            throw new PasswordNotValidException();
        } catch (LoginException ex) {
            System.out.println(ex);
            return false;
        }
    }

    // Searches the user by username in the users list
    public User findUser(String userName) {
        try {
            for (User user : users) {
                if (userName.equals(user.userName))
                    return user;
            }
            throw new NoMatchingNumberException();
        } catch (LoginException ex) {
            System.out.println(ex);
            return null;
        }
    }

    // Creates a list of books this user owns
    public LinkedList<Book> booksOwnedByUser(int isbn) {
        LinkedList<Book> ownedBooks = new LinkedList<Book>();
        for (Book book : this.books) {
            if (book.ownerNumber.equals(isbn)) {
                ownedBooks.add(book);
            }
        }
        currentUser.borrowedBooks = ownedBooks;
        return ownedBooks;
    }

    // Method that sorts books by alphabetical order
    public LinkedList<Book> sortBooksByAlphabetical(LinkedList<Book> list) {
        list.sort(Comparator.comparing(Book::getTitle)); // Uses Comparator to sort from A - Z
        return list;
    }

    // Method that searches books by string
    public LinkedList<Book> searchBookByString(String input) {
        LinkedList<Book> results = new LinkedList<Book>();
        for (Book book : this.books) {
            if (book.title.contains(input)) // If the title contains a string of characters matching the input string
                results.add(book);          // add to results list
        }
        return results;
    }

    public LinkedList<Book> getBooks() {
        return books;
    }
        // Method that adds a new user account
    // Used for registration purposes
    public void addUser(String name, String password) {
        users.add(new User(name, this.generateRandomNumber(), password, false));
    }

    // Method that adds an already existing user account
    public void addUser(User user) {
        users.add(user);
    }

    // Method that adds a new book
    public void addBook(String title, String author, String isbn, Integer ownerNumber) {
        books.add(new Book(title, author, isbn, ownerNumber));
    }

    // Method that adds a new book with no owner number attribute
    public void addBook(String title, String author, String isbn) {
        books.add(new Book(title, author, isbn));
    }

    // Method that removes a book by isbn parameter
    public boolean removeBook(String isbn) {
        Book book = this.getBook(isbn); // Finds book by isbn in list
        if (book == null) // Checks if book exists
            return false;
        this.books.remove(book);
        return true;
    }

    // Method that removes user by libraryNum parameter
    public boolean removeUser(int libraryNum) {
        User user = this.getUser(libraryNum); // Finds user by library number
        if (user == null) // Checks if user exists
            return false;
        this.users.remove(user);
        return true;
    }

    // Method that searches for user by library number
    public User getUser(int libraryNum) {
        for (int i = 0; i < users.size(); i++) {
            if (this.users.get(i).libraryNum == libraryNum) {
                return this.users.get(i);
            }
        }
        return null;    // If user is not found, return null
    }

    // Method that displays user by index
    public User displayUser(int index){
        return this.users.get(index);
    }

    // Method that searches user by name and password (depreciated)
    public User getUser(String name, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (this.users.get(i).getUserName().equals(name) && this.users.get(i).getPassword().equals(name)) {
                return this.users.get(i);
            }
        }
        return null;
    }

    // Method that searches books by isbn
    public Book getBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (this.books.get(i).isbn.equals(isbn))
                return this.books.get(i);
        }
        return null;    // If book is not found, return null
    }

    // Method that gets book by index
    public Book getBook(int i) {
        if(books.size()-1 < i){
            return null;
        }
        return books.get(i);
    }

    // Method that generates a random number
    // Used as the isbn for users during registration
    public int generateRandomNumber() {
        Random random = new Random();
        int min = 10000000;
        int max = 99999999;

        int range = max - min + 1;
        return random.nextInt(range) + min; // The eight digit random number
    }

    // All methods after this are basic setters and getters
    public int getBookSize(){
        return books.size();
    }

    public int getUserSize(){
        return users.size();
    }

    public void setUser(User user){
        this.currentUser = user;
    }
    public User getUser(){
        return currentUser;
    }
}
