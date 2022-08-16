package HomeVisualizer;

import java.sql.SQLException;

import HomeVisualizer.Database.InitializeDatabase;

import HomeVisualizer.Gui.Login.LoginGui;
import HomeVisualizer.Gui.VisualizeMain.StartVisualizeGui;

public class Main {

    private static LoginGui login;

    public static void main(String[] args) throws SQLException {
        new InitializeDatabase();
        login = new LoginGui();
    }

    public static void continueAfterLogin(String username) {
        login.dispose();
        if (!(username == null)) {
            new StartVisualizeGui(username);
        }
    }
}