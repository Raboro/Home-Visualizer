package HomeVisualizer;

import java.sql.SQLException;

import HomeVisualizer.Database.InitializeDatabase;
import HomeVisualizer.Gui.LoginGui;
import HomeVisualizer.Gui.VisualizeGui;

public class Main {
    public static void main(String[] args) throws SQLException {
        new InitializeDatabase();
        new LoginGui();
    }

    public static void continueAfterLogin(String username) {
        if (!(username == null)) {
            new VisualizeGui(username);
        }
    }
}