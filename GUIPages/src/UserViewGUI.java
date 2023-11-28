import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Backend.Library;
import Backend.User;

import static java.lang.Integer.parseInt;

//This page is only avaliable to Admins
public class UserViewGUI {
    private JList displayList;
    private JButton exitPageButton;
    private JButton addUserButton;
    private JButton removeUserButton;
    Library library = Library.getInstance();
    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField libraryNumText;
    private JButton editUserButton;
    private JScrollPane scrollPane;
    private JPanel panel;
    private JLabel adminStatusLabel;
    private JTextField adminStatusText;

    public UserViewGUI() {
        // Create a new JFrame and add the panel created from the GUI form builder.
        JFrame frame = new JFrame();
        frame.add(panel);

        // Set name and close operation
        frame.setName("Library Manager - Users");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Set minimum dimensions and layout
        frame.setMinimumSize(new Dimension(400,400));

        // Set background colors
        panel.setBackground(new Color(175,175,175));
        displayList.setBackground(new Color(155,155,155));
        usernameText.setBackground(new Color(155,155,155));
        passwordText.setBackground(new Color(155,155,155));
        libraryNumText.setBackground(new Color(155,155,155));
        adminStatusText.setBackground(new Color(155,155,155));

        // Populate the display list
        DefaultListModel defaultListModel = new DefaultListModel();
        displayList.setModel(defaultListModel);
        scrollPane.setViewportView(displayList);
        for (int i = 0; i < library.getUserSize(); i++) {
            defaultListModel.addElement(library.displayUser(i));
        }

        // This listener is fired everytime the user clicks an entry on the list
        // this updates the text fields with the selected entry on the list
        displayList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    User user = (User) defaultListModel.get(e.getLastIndex());
                    usernameText.setText(user.getUserName());
                    passwordText.setText(user.getPassword());
                    libraryNumText.setText(Integer.toString(user.getLibraryNum()));
                    if(user.isAdmin){
                        adminStatusText.setText("1");
                    }else{
                        adminStatusText.setText("0");
                    }
                }
            }
        });

        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Adds a user to the user list
                User newUser = new User(usernameText.getText(),library.generateRandomNumber(),passwordText.getText(), false);
                library.addUser(newUser);
                defaultListModel.addElement(newUser);
                frame.revalidate();
                frame.repaint();
            }
        });

        removeUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //removes user from the list
                library.removeUser(parseInt(libraryNumText.getText()));
                frame.revalidate();
                frame.repaint();
            }
        });

        editUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Allows admins to change user info and set or delete new Admins
                User user = library.getUser(Integer.parseInt(libraryNumText.getText()));
                if(adminStatusText.getText().equals("1")){
                    user.editUser(usernameText.getText(), Integer.parseInt(libraryNumText.getText()), passwordText.getText(), true);
                }
                else if (adminStatusText.getText().equals("0")){
                    user.editUser(usernameText.getText(), Integer.parseInt(libraryNumText.getText()), passwordText.getText(), false);
                }else{
                    JOptionPane.showMessageDialog(null, "Admin status must be 1 or 0");
                }

            }
        });

        exitPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //redirects to main page
                MainScreenGUI mainScreenGUI = new MainScreenGUI();
                frame.dispose();
            }
        });

        // Pack window and center it on screen
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
