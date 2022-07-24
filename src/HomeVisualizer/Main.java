package HomeVisualizer;

import java.sql.SQLException;

import HomeVisualizer.Database.InitializeDatabase;
import HomeVisualizer.Gui.LoginGui;

public class Main {
    public static void main(String[] args) throws SQLException {
        new InitializeDatabase();
        new LoginGui();
    }

    public static void continueAfterLogin(String username) {
        if (!(username == null)) {
            System.out.println(username);
        }
    }
}