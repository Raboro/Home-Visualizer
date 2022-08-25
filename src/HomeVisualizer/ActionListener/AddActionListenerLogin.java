package HomeVisualizer.ActionListener;

import java.awt.event.ActionListener;

import HomeVisualizer.Gui.Login.LoginGui;

public class AddActionListenerLogin implements AddActionListener{

    @Override
    public void add(ActionListener l) {
        LoginGui.showPassword.addActionListener(l);
        LoginGui.loginButton.addActionListener(l);
        LoginGui.signUpButton.addActionListener(l);
    }
}