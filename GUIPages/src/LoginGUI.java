import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import Backend.Library;
import Backend.User;

public class LoginGUI extends JFrame {
    final JTextField usernameText = new JTextField();
    final JPasswordField passwordText = new JPasswordField();
    private JButton registerButton;
    private JButton loginButton;
    private JLabel usernameLabel;
    private JLabel passWordLabel;
    private JLabel icon;
    public LoginGUI() {
        // Set name and close operation
        setName("Library Manager - Login");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Set minimum dimensions and layout
        setMinimumSize(new Dimension(400,300));

        // Add buttons and other elements
        initializeElements();

        // Center and make visible
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void initializeElements() {

        // Set the layout of this page to a 3x3 grid layout
        setLayout(new GridLayout(3,3));

        // Add empty space grid
        JPanel space = new JPanel();
        add(space);

        // Load and add icon image
        ImageIcon imgIcon = new ImageIcon("GUIPages/books.png");
        Image scaledImage = imgIcon.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT);

        icon = new JLabel(new ImageIcon(scaledImage));
        add(icon);

        // Add empty space grid
        JPanel space2 = new JPanel();
        add(space2);

        // Add username label and set its alignment then add it to the frame
        usernameLabel = new JLabel("Username: ");
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        usernameLabel.setVerticalAlignment(SwingConstants.TOP);
        add(usernameLabel);

        // Add the username text field to a JPanel to resize it and then add the panel to the frame.
        JPanel usernameTextPanel = new JPanel();
        usernameText.setPreferredSize(new Dimension(100,30));
        usernameTextPanel.add(usernameText);
        add(usernameTextPanel);

        // Add register button to a JPanel to resize it and then add the panel to the frame.
        registerButton = CreateRegisterButton();
        JPanel registerPanel = new JPanel();
        registerPanel.add(registerButton);
        add(registerPanel);

        // Add password label and set its alignment then add it to the frame
        passWordLabel = new JLabel("Password: ");
        passWordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passWordLabel.setVerticalAlignment(SwingConstants.TOP);
        add(passWordLabel);

        // Add password text field to a JPanel to resize it and then add the panel to the frame.
        JPanel passwordTextPanel = new JPanel();
        passwordText.setPreferredSize(new Dimension(100,30));
        passwordTextPanel.add(passwordText);
        add(passwordTextPanel);

        // Add the login button to a JPanel to resize it and then add the panel to the frame.
        loginButton = CreateLoginButton();
        JPanel loginPanel = new JPanel();
        loginPanel.add(loginButton);
        add(loginPanel);
    }

    // Implementation of the login button listener
    public JButton CreateLoginButton() {
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Access Library Singleton
                Library library = null;
                library = library.getInstance();
                //Checks files for matching inputs
                if(library.validateLogin(usernameText.getText(), passwordText.getText())){
                    //Sets current user to match info, opens main screen, disposes current login screen
                    library.setUser(library.findUser(usernameText.getText()));
                    MainScreenGUI mainScreenGUI = new MainScreenGUI();
                    dispose();
                }else{
                    //Lets user know that they have incorrect info
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }
        });
        return login;
    }

    // Implementation of the register button listener
    public JButton CreateRegisterButton() {
        JButton register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Checks for empty fields
                if(usernameText.getText().isEmpty() || passwordText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please fill all values");
                } else {
                    //Accesses library singleton, creates a new user and then adds user to library
                    Library library = null;
                    library = library.getInstance();
                    User user = new User(usernameText.getText(), generateRandomNumber(), passwordText.getText(), false);
                    if (library.findUser(usernameText.getText()) != null) {
                        JOptionPane.showMessageDialog(null, "Username already taken!");
                        return;
                    }
                    library.addUser(user);
                    JOptionPane.showMessageDialog(null, "Successful registration. You can now log in, your new ID is: " + user.getLibraryNum());
                }
            }
        });
        return  register;
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
