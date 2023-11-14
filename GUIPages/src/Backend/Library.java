package Backend;

import ExceptionsPack.LoginException;
import ExceptionsPack.NoMatchingNumberException;
import ExceptionsPack.PasswordNotValidException;

import java.io.*;
import java.util.LinkedList;
import java.util.Random;
import java.util.StringTokenizer;

public class Library {
    public LinkedList<User> users; //List of users
    public LinkedList<Book> books;
    private static Library uniqueInstance;

    private Library() {
        this.users = new LinkedList<User>();
        this.books = new LinkedList<Book>();
    }

    public static Library getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Library();
        }
        return uniqueInstance;
    }

    public void initializeBooks(String file) {
        LinkedList<Book> savedBooks = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                if (tokenizer.countTokens() == 5) {
                    String title = tokenizer.nextToken();
                    String author = tokenizer.nextToken();
                    String isbn = tokenizer.nextToken();
                    Integer ownerNumber = Integer.valueOf(tokenizer.nextToken());
                    savedBooks.add(new Book(title, author, isbn, ownerNumber));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.books = savedBooks;
    }

    public void initializeUsers(String file) {
        LinkedList<User> accounts = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                if (tokenizer.countTokens() == 5) {
                    String firstName = tokenizer.nextToken();
                    int libraryNum = Integer.parseInt(tokenizer.nextToken());
                    String password = tokenizer.nextToken();
                    accounts.add(new User(firstName, libraryNum, password));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.users = accounts;
    }

    public void saveUsers(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (User storedAccount : users)
                writer.write(storedAccount.userName + " " + storedAccount.libraryNum + " "
                        + storedAccount.getPassword() + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void saveBooks(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book storedBooks : books)
                writer.write(storedBooks.title + " " + storedBooks.author + " "
                        + storedBooks.isbn + " " + storedBooks.status + "\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public boolean validateLogin(String userName, String password) {
        User account = this.findUser(userName);
        if (account == null) {
            return false;
        }
        try {
            if (account.getPassword() == password)
                return true;
            throw new PasswordNotValidException();
        } catch (LoginException ex) {
            System.out.println(ex);
            return false;
        }
    }

    private User findUser(String userName) {
        try {
            for (int i = 0; i < users.size(); i++) {
                if (userName == this.users.get(i).userName)
                    return this.users.get(i);
            }
            throw new NoMatchingNumberException();
        } catch (LoginException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public void addUser(String name, String password) {
        users.add(new User(name, this.generateRandomNumber(), password));
    }

    public void addBook(String title, String author, String isbn, Integer ownerNumber) {
        books.add(new Book(title, author, isbn, ownerNumber));
    }

    public boolean removeBook(String isbn) {
        Book book = this.getBook(isbn);
        if (book == null)
            return false;
        this.books.remove(book);
        return true;
    }

    public boolean removeUser(int libraryNum) {
        User user = this.getUser(libraryNum);
        if (user == null)
            return false;
        this.users.remove(user);
        return true;
    }

    public User getUser(int libraryNum) {
        for (int i = 0; i < users.size(); i++) {
            if (this.users.get(i).libraryNum == libraryNum)
                return this.users.get(i);
        }
        return null;
    }

    public Book getBook(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (this.books.get(i).isbn == isbn)
                return this.books.get(i);
        }
        return null;
    }


    public int generateRandomNumber() {
        Random random = new Random();
        // Generate a random int within the range of 100,000,00 to 999,999,99
        int min = 10000000;
        int max = 99999999;

        // Calculate the range and add the minimum value to the result
        int range = max - min + 1;
        return random.nextInt(range) + min;
    }
}
