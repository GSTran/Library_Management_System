import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField usernameText;
    private JPasswordField passwordText;
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

        // Pack window and center it on screen
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void initializeElements() {

        setLayout(new GridLayout(3,3));

        JPanel space = new JPanel();
        add(space);

        ImageIcon imgIcon = new ImageIcon("GUIPages/books.png");
        Image scaledImage = imgIcon.getImage().getScaledInstance(140,140,Image.SCALE_DEFAULT);

        icon = new JLabel(new ImageIcon(scaledImage));
        add(icon);

        JPanel space2 = new JPanel();
        add(space2);

        usernameLabel = new JLabel("Username: ");
        usernameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        usernameLabel.setVerticalAlignment(SwingConstants.TOP);
        add(usernameLabel);

        usernameText = new JTextField();
        JPanel usernameTextPanel = new JPanel();
        usernameText.setPreferredSize(new Dimension(100,30));
        usernameTextPanel.add(usernameText);
        add(usernameTextPanel);

        registerButton = CreateRegisterButton();
        JPanel registerPanel = new JPanel();
        registerPanel.add(registerButton);
        add(registerPanel);

        passWordLabel = new JLabel("Password: ");
        passWordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        passWordLabel.setVerticalAlignment(SwingConstants.TOP);
        add(passWordLabel);

        passwordText = new JPasswordField();
        JPanel passwordTextPanel = new JPanel();
        passwordText.setPreferredSize(new Dimension(100,30));
        passwordTextPanel.add(passwordText);
        add(passwordTextPanel);

        loginButton = CreateLoginButton();
        JPanel loginPanel = new JPanel();
        loginPanel.add(loginButton);
        add(loginPanel);
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
