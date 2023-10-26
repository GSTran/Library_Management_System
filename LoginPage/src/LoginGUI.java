import javax.swing.*;
import java.awt.*;

public class LoginGUI{
    private JFrame frame;
    private GridBagLayout grid;
    private GridBagConstraints constraints;
    private JTextField usernameText;
    private JTextField passwordText;
    private JButton registerButton;
    private JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passWordLabel;

    private JLabel icon;
    public LoginGUI() {
        // Initialize frame and layout manager
        frame = new JFrame("Library Login");
        grid = new GridBagLayout();
        constraints = new GridBagConstraints();

        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Set minimum dimensions and layout
        frame.setMinimumSize(new Dimension(400,400));
        frame.setLayout(grid);


        // Add buttons and labels
        initializeElements();

        // Pack window and center it on screen
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void initializeElements() {

        ImageIcon imgIcon = new ImageIcon("books.png");
        Image scaledImage = imgIcon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        constraints.gridx = 10;
        constraints.gridy = -10;
        icon = new JLabel(new ImageIcon(scaledImage));
        frame.add(icon,constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        usernameLabel = new JLabel("Username");
        frame.add(usernameLabel, constraints);

        constraints.gridx = 10;
        constraints.gridy = 10;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        usernameText = new JTextField();
        frame.add(usernameText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 30;
        passWordLabel = new JLabel("Password");
        frame.add(passWordLabel, constraints);

        constraints.gridx = 10;
        constraints.gridy = 30;
        passwordText = new JTextField();
        frame.add(passwordText, constraints);


        constraints.gridx = 10;
        constraints.gridy = 50;
        registerButton = new JButton("Register");
        frame.add(registerButton, constraints);


        constraints.gridx = 10;
        constraints.gridy = 60;
        loginButton = new JButton("Login");
        frame.add(loginButton, constraints);
    }





    public static void main(String[] args) {
        LoginGUI loginPage = new LoginGUI();
    }
}
