package HomeVisualizer;

import java.sql.SQLException;
import java.util.Objects;

import HomeVisualizer.ActionListener.AddActionListenerLogin;
import HomeVisualizer.ActionListener.AddActionListenerStartVisualize;
import HomeVisualizer.ActionListener.LoginActionListener;
import HomeVisualizer.ActionListener.StartVisualizerActionListener;
import HomeVisualizer.Database.InitializeDatabase;

import HomeVisualizer.Gui.Login.LoginGui;
import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;

public class Main {

    private static LoginGui login;

    public static void main(String[] args) throws SQLException {
        new InitializeDatabase();
        login = new LoginGui();
        AddActionListenerLogin loginActionListener = new AddActionListenerLogin();
        loginActionListener.add(new LoginActionListener());
    }

    public static void continueAfterLogin(String username) {
        login.dispose();
        if (!(Objects.equals(username, ""))) {
            new StartVisualizeGui(username);
            AddActionListenerStartVisualize startVisualizeActionListener = new AddActionListenerStartVisualize();
            startVisualizeActionListener.add(new StartVisualizerActionListener());
        }
    }
}