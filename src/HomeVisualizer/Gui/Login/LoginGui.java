package HomeVisualizer.Gui.Login;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import HomeVisualizer.ActionListener.LoginActionListener;

import HomeVisualizer.Gui.Frame;

public class LoginGui extends Frame {
    
    private JPanel panel;
    private JLabel usernameLabel, passwordLabel;
    
    private static final String TITLE = "Login";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    public static JTextField username;
    public static JPasswordField password;
    public static JButton loginButton, signUpButton;
    public static JCheckBox showPassword;

    public LoginGui() {
        super(TITLE, WIDTH, HEIGHT);
        panel = new JPanel();
        panel.setLayout(null);

        this.add(panel);
        createLayout();
        this.setLocation(730, 650);
        this.setVisible(true);
    }

    private void createLayout() {
        ActionListener actionListener = new LoginActionListener();

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(130, 78, 70, 20);
        panel.add(usernameLabel);

        username = new JTextField();
        username.setBounds(130, 97, 250, 28);
        panel.add(username);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(130, 135, 70, 20);
        panel.add(passwordLabel);

        password = new JPasswordField();
        password.setBounds(130, 155, 250, 28);
        panel.add(password);

        showPassword = new JCheckBox("Show Password");
        showPassword.setBounds(130, 200, 200, 20);
        showPassword.addActionListener(actionListener);
        panel.add(showPassword);

        loginButton = new JButton();
        loginButton.setBounds(130, 240, 110, 38);
        loginButton.setIcon(new javax.swing.ImageIcon("/home/marius/Documents/Home-Visualizer/Images/loginButton.png"));
        loginButton.addActionListener(actionListener);
        panel.add(loginButton);

        signUpButton = new JButton();
        signUpButton.setBounds(250, 240, 130, 38);
        signUpButton.setIcon(new javax.swing.ImageIcon("/home/marius/Documents/Home-Visualizer/Images/signUpButton.png"));
        signUpButton.addActionListener(actionListener);
        panel.add(signUpButton);
    }
}