import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserViewGUI {
    private JList displayList;
    private JButton exitPageButton;
    private JButton addUserButton;
    private JButton removeUserButton;
    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField libraryNumText;
    private JButton editUserButton;
    private JScrollPane scrollPane;
    private JPanel panel;


    public UserViewGUI() {
        JFrame frame = new JFrame();
        frame.add(panel);
        // Set name and close operation
        frame.setName("Library Manager - Users");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Set minimum dimensions and layout
        frame.setMinimumSize(new Dimension(400,400));

        DefaultListModel defaultListModel = new DefaultListModel();
        displayList.setModel(defaultListModel);
        scrollPane.setViewportView(displayList);

        /**
         * TODO: Populate list model with instances of the Users class similarly to how the Book list is
         *  added in the BookViewGUI.
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

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        removeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        editUserButton.addActionListener(new ActionListener() {
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
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
