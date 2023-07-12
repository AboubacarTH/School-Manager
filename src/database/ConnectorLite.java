package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorLite {

    private Connection connection;

    public ConnectorLite() {
        try {
            // db parameters
//            String url = "jdbc:sqlite:" + getPATH() + "database/data.db";
            String url = "jdbc:sqlite:" + System.getProperty("user.dir") + "\\database\\data.db";

            // create a connection to the database
            connection = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
}
