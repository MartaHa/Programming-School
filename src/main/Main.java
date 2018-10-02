package main;


import dao.UserDaoImpl;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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





         final UserDaoImpl userDaoImpl = new UserDaoImpl();


        Scanner scanner = new Scanner(System.in);

        //creating an user

        System.out.println("Enter your username:");
        String username = scanner.next();
        System.out.println("Enter your password:");
        String password = scanner.next();
        System.out.println("Enter your email:");
        String email = scanner.next();

        userDaoImpl.createUser(username, email, password);

        userDaoImpl.getAllUsers();
    }
}