package HomeVisualizer.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDatabase extends Database {

    public void add(int username, String password) throws SQLException {
        if (userNotInDatabase(username)) {
            PreparedStatement addToDatabase = connection.prepareStatement(
                    "INSERT INTO UserDatabase (USERNAME, PASSWORD) VALUES ('" + username + "', '" + password + "')");
            addToDatabase.executeUpdate();
        }
    }

    private boolean userNotInDatabase(int username) throws SQLException {
        PreparedStatement userExistsCheck = connection.prepareStatement("SELECT * FROM UserDatabase");
        ResultSet result = userExistsCheck.executeQuery();

        while (result.next()) {
            if (result.getInt("USERNAME") == username) {
                return false;
            }
        }
        return true;
    }

    public String get(int username) throws SQLException {
        PreparedStatement userExistsCheck = connection.prepareStatement("SELECT * FROM UserDatabase");
        ResultSet result = userExistsCheck.executeQuery();
        
        while (result.next()) {
            if (result.getInt("USERNAME") == username) {
                return result.getString("PASSWORD");
            }
        }
        return null;
    }
}