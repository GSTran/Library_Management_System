import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import Backend.Library;
import Backend.Book;

public class BookViewGUI {
    private JButton exitPageButton;
    private JButton addBookButton;
    private JButton removeBookButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton borrowBookButton;
    private JButton returnBookButton;
    private JButton editBookButton;
    private JLabel status;
    private JLabel statusLabel;
    private JList displayList;
    private JScrollPane scroll;
    private JScrollPane scroll2;
    private JPanel panel;
    private JTextField searchTextField;
    private JButton sortButton;
    private JButton viewMyBooksButton;
    private JButton searchButton;
    private JLabel searchLabel;
    private JButton viewAllBooksButton;

    private boolean listUpdating = false;

    public BookViewGUI() {
        // Create a new JFrame and add the panel created from the GUI form builder.
        JFrame frame = new JFrame();
        frame.add(panel);

        Library library = null;
        library = library.getInstance();
        Library finalLibrary = library;


        // Set name and close operation
        frame.setName("Library Manager - Books");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Set minimum dimensions
        frame.setMinimumSize(new Dimension(400,400));

        // Initialize and populate display list
        DefaultListModel defaultListModel = new DefaultListModel<>();
        displayList.setModel(defaultListModel);
        scroll2.setViewportView(displayList);

        for (int i = 0; i < library.getBookSize(); i++) {
            defaultListModel.addElement(library.getBook(i));
        }


        // Handle difference between user and admin view of this page
        if (!Library.getInstance().getUser().isAdmin) {
            addBookButton.setVisible(false);
            removeBookButton.setVisible(false);
            editBookButton.setVisible(false);
            panel.setBackground(new Color(52,220,151));
            textField1.setBackground(new Color(42,210,141));
            textField2.setBackground(new Color(42,210,141));
            textField3.setBackground(new Color(42,210,141));
            searchTextField.setBackground(new Color(42,210,141));
            displayList.setBackground(new Color(42,210,141));
        }
        else {
            panel.setBackground(new Color(175,175,175));
            textField1.setBackground(new Color(155,155,155));
            textField2.setBackground(new Color(155,155,155));
            textField3.setBackground(new Color(155,155,155));
            searchTextField.setBackground(new Color(155,155,155));
            displayList.setBackground(new Color(155,155,155));
        }


        viewMyBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Deletes current list and updates it with books owned by user
               // displayList.clearSelection();
                listUpdating = true;
                displayList.clearSelection();
                defaultListModel.clear();
                for (int i = 0; i < finalLibrary.booksOwnedByUser(finalLibrary.getUser().getLibraryNum()).size(); i++) {
                    defaultListModel.addElement(finalLibrary.booksOwnedByUser(finalLibrary.getUser().getLibraryNum()).get(i));
                }
                listUpdating = false;
            }
        });

        viewAllBooksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listUpdating = true;
                displayList.clearSelection();
                //Deletes current list and updates it with all books currently in library
                defaultListModel.removeAllElements();
                for (int i = 0; i < finalLibrary.getBookSize(); i++) {
                    defaultListModel.addElement(finalLibrary.getBook(i));
                }
                listUpdating = false;
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listUpdating = true;
                displayList.clearSelection();
                defaultListModel.removeAllElements();
                String input = "";
                //Checks for empty fields
                if (searchTextField.getText() != null){
                    input = searchTextField.getText();
                }else{
                    JOptionPane.showMessageDialog(null, "Enter a value before searching");
                }

                //Deletes current list and updates it with books that contain the user input
                defaultListModel.removeAllElements();
                LinkedList<Book> searchedBooks = finalLibrary.searchBookByString(input);
                if (searchedBooks.size() == 0){
                    JOptionPane.showMessageDialog(null, "No books match that input!");
                }
                for (int i = 0; i < searchedBooks.size(); i++) {
                    defaultListModel.addElement(searchedBooks.get(i));
                }

                listUpdating = false;
            }
        });

        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Deletes current list and updates it with books sorted in alphabetical order
                defaultListModel.removeAllElements();
                LinkedList<Book> sortedBooks = finalLibrary.sortBooksByAlphabetical(finalLibrary.getBooks());
                for (int i = 0; i < sortedBooks.size(); i++) {
                    defaultListModel.addElement(sortedBooks.get(i));
                }
            }
        });

        // This listener is fired everytime the user clicks an entry on the list
        // and will update the text fields with information of the selected list item.
        displayList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting() && listUpdating == false) {
                    Book book = (Book) defaultListModel.get(displayList.getSelectedIndex());
                    textField1.setText(book.getAuthor());
                    textField2.setText(book.getTitle());
                    textField3.setText(book.getIsbn());
                    status.setText(book.getStatus().toString());
                }
            }
        });


        editBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayList.getSelectedIndex() == -1) return;
                //Allows user to edit books information, this is saved to the library's list's information
                finalLibrary.getBook(textField3.getText()).change(textField2.getText(),textField1.getText(),textField3.getText(), finalLibrary.getBook(0).getOwnerNumber());
                frame.revalidate();
                frame.repaint();
            }
        });

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Allows user to add a book to the library's list of books
                finalLibrary.addBook(textField2.getText(),textField1.getText(),textField3.getText());
                defaultListModel.addElement(finalLibrary.getBook(finalLibrary.getBookSize()-1));
            }
        });

        removeBookButton.addActionListener(new ActionListener() {
            @Override
            //Allows user to remove books, this change is made in the libraries list
            public void actionPerformed(ActionEvent e) {
                finalLibrary.removeBook(textField3.getText());
            }
        });

        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayList.getSelectedIndex() == -1) return;
                //Allows user to borrow books, works by changing book's status
                if(finalLibrary.getBook(textField3.getText()).getStatus() == Book.Status.BORROWED){
                    JOptionPane.showMessageDialog(null, "That book is borrowed!");
                }else{
                    JOptionPane.showMessageDialog(null, finalLibrary.getUser().getUserName() + " has checked out " + finalLibrary.getBook(textField3.getText()).getTitle());
                }
                //updates books status within library's list
                finalLibrary.getUser().borrowBook(finalLibrary.getBook(textField3.getText()));
            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (displayList.getSelectedIndex() == -1) return;
                //Allows user to return books, this change is made in the libraries list
                if (finalLibrary.getUser().returnBook(finalLibrary.getBook(textField3.getText()))) {
                    JOptionPane.showMessageDialog(null, "Thanks for returning!" + " " +
                            finalLibrary.getBook(textField3.getText()).getTitle());
                } else
                    JOptionPane.showMessageDialog(null, "You can't return a book you don't own!");
            }
        });

        exitPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainScreenGUI mainScreenGUI = new MainScreenGUI();
                frame.dispose();
            }
        });

        // Pack window and center it on screen
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
