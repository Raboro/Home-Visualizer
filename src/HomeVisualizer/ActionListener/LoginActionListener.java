package HomeVisualizer.ActionListener;

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

import HomeVisualizer.Main;

import HomeVisualizer.Gui.Login.LoginGui;

import HomeVisualizer.Logic.LoginLogic;

public class LoginActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        // show real chars of password || only * 
        if (event.getSource() == LoginGui.showPassword) {
            if (LoginGui.showPassword.isSelected()) {
                LoginGui.password.setEchoChar((char) 0);
            } else {
                LoginGui.password.setEchoChar('*');
            }
        }

        // login
        if (event.getSource() == LoginGui.loginButton) {
            LoginLogic logic = new LoginLogic(LoginGui.username.getText(), new String(LoginGui.password.getPassword()));
            boolean isLoginSuccessful = false;
            String usernameToContinue = null;
            
            try {
                isLoginSuccessful = logic.login();
            } catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException
                    | IllegalBlockSizeException | BadPaddingException | SQLException | IOException e) {
                e.printStackTrace();
            }

            if (isLoginSuccessful) {
                usernameToContinue = LoginGui.username.getText();
            }
            Main.continueAfterLogin(usernameToContinue);
        }

        // sign up
        if (event.getSource() == LoginGui.signUpButton) {
            LoginLogic logic = new LoginLogic(LoginGui.username.getText(), new String(LoginGui.password.getPassword()));
            
            try {
                logic.signUp();
            } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeySpecException
                    | IllegalBlockSizeException | BadPaddingException | SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}