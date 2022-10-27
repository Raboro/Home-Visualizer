package HomeVisualizer.Gui.Login;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import HomeVisualizer.Gui.Frame;
import HomeVisualizer.Gui.VisualizeMain.StepsGui.StepGui;

public class LoginGui extends Frame implements StepGui {

    public static JTextField username;
    public static JPasswordField password;
    public static JButton loginButton, signUpButton;
    public static JCheckBox showPassword;

    private final JPanel panel;

    public LoginGui() {
        super("Login", 500, 500);
        panel = new JPanel();
        panel.setLayout(null);

        this.add(panel);
        initializeGuiElements();
        this.setLocation(730, 650);
        this.setVisible(true);
    }

    private void initializeGuiElements() {
        initializeLabels();
        initializeTextFields();
        initializeButtons();
    }

    private void initializeLabels() {
        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");

        usernameLabel.setBounds(130, 78, 70, 20);
        passwordLabel.setBounds(130, 135, 70, 20);

        panel.add(usernameLabel);
        panel.add(passwordLabel);
    }

    private void initializeTextFields() {
        username = new JTextField();
        password = new JPasswordField();

        username.setBounds(130, 97, 250, 28);
        password.setBounds(130, 155, 250, 28);

        panel.add(username);
        panel.add(password);   
    }

    private void initializeButtons() {
        showPassword = new JCheckBox("Show Password");
        loginButton = new JButton();
        signUpButton = new JButton();

        showPassword.setBounds(130, 200, 200, 20);
        loginButton.setBounds(130, 240, 110, 38);
        signUpButton.setBounds(250, 240, 130, 38);

        loginButton.setIcon(new javax.swing.ImageIcon("/home/marius/Documents/Home-Visualizer/Images/loginButton.png"));
        signUpButton.setIcon(new javax.swing.ImageIcon("/home/marius/Documents/Home-Visualizer/Images/signUpButton.png"));

        panel.add(showPassword);
        panel.add(loginButton);
        panel.add(signUpButton);
    }
}