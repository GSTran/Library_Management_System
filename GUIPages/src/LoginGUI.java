import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameText;
    private JTextField passwordText;
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
        setMinimumSize(new Dimension(400,400));

        // Add buttons and other elements
        initializeElements();

        // Pack window and center it on screen
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void initializeElements() {
        ImageIcon imgIcon = new ImageIcon("GUIPages/books.png");
        Image scaledImage = imgIcon.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);

        icon = new JLabel(new ImageIcon(scaledImage));
        icon.setBounds(120,0,150,150);
        add(icon);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50,150,100,40);
        add(usernameLabel);

        passWordLabel = new JLabel("Password:");
        passWordLabel.setBounds(50,180,100,40);
        add(passWordLabel);

        usernameText = new JTextField();
        usernameText.setBounds(140,160,100,20);
        add(usernameText);

        passwordText = new JTextField();
        passwordText.setBounds(140,190,100,20);
        add(passwordText);

        registerButton = CreateRegisterButton();
        JPanel registerPanel = new JPanel();
        registerPanel.add(registerButton);
        registerPanel.setBounds(140,220,90,35);
        add(registerPanel);

        loginButton = CreateLoginButton();
        JPanel loginPanel = new JPanel();
        loginPanel.add(loginButton);
        loginPanel.setBounds(140,270,90,35);
        add(loginPanel);

        JPanel space = new JPanel();
        add(space);
    }

    /**
     * TODO: Implement Login check logic here.
     */
    public JButton CreateLoginButton() {
        JButton login = new JButton("Login");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add login check logic here

                // If login successful do code below
                MainScreenGUI mainScreenGUI = new MainScreenGUI();
                dispose();
            }
        });

        return login;
    }

    /**
     * TODO: Implement register button listener here.
     */
    public JButton CreateRegisterButton() {
        JButton register = new JButton("Register");
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        return  register;
    }
}
