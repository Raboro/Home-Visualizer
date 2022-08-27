package HomeVisualizer.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DatabaseInformation.databseConnectionHomeVisualizer;

public abstract class Database {

    protected Connection connection = null;

    public Database() {
        connect();
    }

    public void connect() {
        try {
            connection = DriverManager.getConnection(databseConnectionHomeVisualizer.URL,
                    databseConnectionHomeVisualizer.USER, databseConnectionHomeVisualizer.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void add() {
    }

    public <T> T[] get() {
        return null;
    }

    public void remove() {
    }
}