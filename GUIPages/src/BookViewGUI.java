import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TestBookClass {
    String name;
    int id;

    public TestBookClass(String n, int i) {
        name = n;
        id = i;
    }

    @Override
    public String toString() {
        return name + id;
    }
}

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

    public BookViewGUI() {
        JFrame frame = new JFrame();
        frame.add(panel);

        // Set name and close operation
        frame.setName("Library Manager - Books");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Set minimum dimensions
        frame.setMinimumSize(new Dimension(400,400));

        // Initialize and populate display list
        DefaultListModel defaultListModel = new DefaultListModel<>();
        displayList.setModel(defaultListModel);
        scroll2.setViewportView(displayList);

        /**
         * TODO: Populate the listModel with actual Book objects from the backend instead of TestBookClass.
         */
        for (int i = 0; i < 10; i++) {
            defaultListModel.addElement(new TestBookClass("TestBook", i));
        }


        /**
         * TODO: Implement listeners for all the buttons
         */

        // This listener is fired everytime the user clicks an entry on the list
        // we can use this to update the text fields based on the selected list item.
        displayList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {

                }
            }
        });


        editBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        addBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        removeBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        borrowBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
