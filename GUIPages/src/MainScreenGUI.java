import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreenGUI {
    private JButton bookCollectionButton;
    private JPanel panel1;
    private JButton logoutButton;
    private JButton userCollectionButton;
    public MainScreenGUI() {
        JFrame frame = new JFrame();
        frame.add(panel1);

        // Set name and close operation
        frame.setName("Library Manager - Main");
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Set minimum dimensions
        frame.setMinimumSize(new Dimension(400,400));

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
