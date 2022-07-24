package HomeVisualizer.Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InitializeDatabase extends Database {

    public InitializeDatabase() throws SQLException {
        PreparedStatement createUserDatabase = connection
                .prepareStatement("CREATE TABLE IF NOT EXISTS UserDatabase(USERNAME int, PASSWORD VARCHAR(1000))");
        createUserDatabase.executeUpdate();
    }
}