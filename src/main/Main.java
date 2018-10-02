package main;


import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {





    //creating tables users

    public static void createUsersTable() {


        String sql = "CREATE TABLE users (userId int AUTO_INCREMENT,"
                + " username varchar(255),"
                + " email varchar(255),"
                + " password varchar(255),"
                + " PRIMARY KEY(userId))";

        {
            try {
                ConnectionFactory connectionFactory = new ConnectionFactory();
                Connection connection = connectionFactory.getConnection();
                Statement stm = connection.createStatement();
                stm.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        createUsersTable();
    }
}