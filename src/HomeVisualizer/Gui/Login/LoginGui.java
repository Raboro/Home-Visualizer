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

    public static JTextField username;
    public static JPasswordField password;
    public static JButton loginButton, signUpButton;
    public static JCheckBox showPassword;

    private JPanel panel;
    private JLabel usernameLabel, passwordLabel;
    
    public LoginGui() {
        super("Login", 500, 500);
        panel = new JPanel();
        panel.setLayout(null);

        this.add(panel);
        createLayout();
        this.setLocation(730, 650);
        this.setVisible(true);
    }

    private void createLayout() {
        initializeLabels();
        initializeInputFields();
        initializeInteractions(new LoginActionListener());
    }

    private void initializeLabels() {
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");

        usernameLabel.setBounds(130, 78, 70, 20);
        passwordLabel.setBounds(130, 135, 70, 20);

        panel.add(usernameLabel);
        panel.add(passwordLabel);
    }

    private void initializeInputFields() {
        username = new JTextField();
        password = new JPasswordField();

        username.setBounds(130, 97, 250, 28);
        password.setBounds(130, 155, 250, 28);

        panel.add(username);
        panel.add(password);   
    }

    private void initializeInteractions(ActionListener actionListener) {
        showPassword = new JCheckBox("Show Password");
        loginButton = new JButton();
        signUpButton = new JButton();

        showPassword.setBounds(130, 200, 200, 20);
        loginButton.setBounds(130, 240, 110, 38);
        signUpButton.setBounds(250, 240, 130, 38);

        loginButton.setIcon(new javax.swing.ImageIcon("/home/marius/Documents/Home-Visualizer/Images/loginButton.png"));
        signUpButton.setIcon(new javax.swing.ImageIcon("/home/marius/Documents/Home-Visualizer/Images/signUpButton.png"));

        showPassword.addActionListener(actionListener);
        loginButton.addActionListener(actionListener);
        signUpButton.addActionListener(actionListener);

        panel.add(showPassword);
        panel.add(loginButton);
        panel.add(signUpButton);
    }
}