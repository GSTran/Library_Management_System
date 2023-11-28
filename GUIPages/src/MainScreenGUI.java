import Backend.Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenGUI {
    private JButton bookCollectionButton;
    private JPanel panel1;
    private JButton logoutButton;
    private JButton userCollectionButton;
    private JLabel iconLabel;

    public MainScreenGUI() {
        // Create a new JFrame and add the panel created from the GUI form builder.
        JFrame frame = new JFrame();
        frame.add(panel1);

        // Set name and close operation
        frame.setName("Library Manager - Main");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Set minimum dimensions
        frame.setMinimumSize(new Dimension(400,400));

        // Load and set icon
        ImageIcon imgIcon = new ImageIcon("GUIPages/books.png");
        Image scaledImage = imgIcon.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT);
        iconLabel.setIcon(new ImageIcon(scaledImage));

        // Handle difference between user and admin view of this page
        if (!Library.getInstance().getUser().isAdmin) {
            userCollectionButton.setVisible(false);
            panel1.setBackground(new Color(52,220,151));
        }
        else {
            panel1.setBackground(new Color(175,175,175));
        }

        //The next few methods are to handle page navigation
        //View collection of books
        bookCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookViewGUI bookViewGUI = new BookViewGUI();
                frame.dispose();
            }
        });

        //View collection of users
        userCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserViewGUI userViewGUI = new UserViewGUI();
                frame.dispose();
            }
        });

        //return to login page
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginGUI loginGUI = new LoginGUI();
                frame.dispose();
            }
        });

        // Pack window and center it on screen
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
