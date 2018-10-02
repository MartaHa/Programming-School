package jdbc;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static Connection connection;

    private static final String url = "jdbc:mysql://localhost:3306/progschool?useSSL=false&serverTimezone=UTC";
    private static final String password = "coderslab";
    private static final String username = "root";

    /**
     * Get a connection to database
     *
     * @return Connection object
     */

    public static Connection getConnection() {

        try {

            return  DriverManager.getConnection(url, username, password);

        } catch (SQLException ex) {

            throw new RuntimeException("Error connecting to the database", ex);

        }

    }
}