package HomeVisualizer.Database;

import DatabaseInforamtion.databseConnectionHomeVisualizer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginDatabase {

    public LoginDatabase() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(databseConnectionHomeVisualizer.URL, databseConnectionHomeVisualizer.USER, databseConnectionHomeVisualizer.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);
    }
}
