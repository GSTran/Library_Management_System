import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenGUI {
    private JButton bookCollectionButton;
    private JPanel panel1;
    private JButton logoutButton;
    private JButton userCollectionButton;
    private JLabel imageLabel;

    public MainScreenGUI() {
        JFrame frame = new JFrame();
        frame.add(panel1);

        // Set name and close operation
        frame.setName("Library Manager - Main");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Set minimum dimensions
        frame.setMinimumSize(new Dimension(400,400));

        ImageIcon imgIcon = new ImageIcon("GUIPages/books.png");
        Image scaledImage = imgIcon.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT);
        imageLabel.setIcon(new ImageIcon(scaledImage));

        bookCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookViewGUI bookViewGUI = new BookViewGUI();
                frame.dispose();
            }
        });

        userCollectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserViewGUI userViewGUI = new UserViewGUI();
                frame.dispose();
            }
        });

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
