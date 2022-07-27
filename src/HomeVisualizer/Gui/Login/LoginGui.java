package HomeVisualizer.Gui.Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import HomeVisualizer.Main;
import HomeVisualizer.Gui.Frame;
import HomeVisualizer.Logic.LoginLogic;

public class LoginGui extends Frame {

    private static final String TITLE = "Login";
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;

    private JPanel panel;

    private JLabel usernameLabel, passwordLabel;
    private JTextField username;
    private JPasswordField password;
    private JButton loginButton, signUpButton;
    private JCheckBox showPassword;

    public LoginGui() {
        super(TITLE, WIDTH, HEIGHT);
        panel = new JPanel();
        panel.setLayout(null);

        this.add(panel);
        createLayout();
        addActionListener();
        this.setLocation(730, 650);
        this.setVisible(true);
    }

    private void createLayout() {
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
        panel.add(showPassword);

        loginButton = new JButton();
        loginButton.setBounds(130, 240, 110, 38);
        loginButton.setIcon(new javax.swing.ImageIcon("/home/marius/Documents/Home-Visualizer/Images/loginButton.png"));
        panel.add(loginButton);

        signUpButton = new JButton();
        signUpButton.setBounds(250, 240, 130, 38);
        signUpButton.setIcon(new javax.swing.ImageIcon("/home/marius/Documents/Home-Visualizer/Images/signUpButton.png"));
        panel.add(signUpButton);
    }

    public void addActionListener() {
        showPassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPassword.isSelected()) {
                    // show each char of password
                    password.setEchoChar((char) 0);
                } else {
                    // hide each char of password 
                    char c = '*';
                    password.setEchoChar(c);
                }
            }

        });

        loginButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LoginLogic logic = new LoginLogic(username.getText(), new String(password.getPassword()));
                boolean loginSuccessful = false;

                try {
                    loginSuccessful = logic.login();
                } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException
                        | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException | SQLException
                        | IOException e1) {
                    e1.printStackTrace();
                }

                String usernameToContinue;
                if (!loginSuccessful) {
                    usernameToContinue = null;
                } else{
                    usernameToContinue = username.getText();
                }
                dispose();
                continueAfterLogin(usernameToContinue);
            }

            private void continueAfterLogin(String usernameToContinue) {
                Main.continueAfterLogin(usernameToContinue);
            }

        });

        signUpButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                LoginLogic logic = new LoginLogic(username.getText(), new String(password.getPassword()));

                try {
                    logic.signUp();
                } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                        | InvalidKeySpecException | IllegalBlockSizeException | BadPaddingException | SQLException
                        | IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}