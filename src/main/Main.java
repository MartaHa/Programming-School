package main;


import dao.UserDaoImpl;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {


//creating tables

    public static void createTables(String sql) {

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

        String sql = "CREATE TABLE users (userId int AUTO_INCREMENT,"
                + " username varchar(255),"
                + " email varchar(255),"
                + " password varchar(255),"
                + " PRIMARY KEY(userId))";

        String sql2 = "CREATE TABLE usergroups (userGroupId int AUTO_INCREMENT,"
                + " name varchar(255),"
                + " userId int,"
                + " PRIMARY KEY(userGroupId),"
                + " FOREIGN KEY(userId) REFERENCES users(userId))";


        String sql3 = "CREATE TABLE exercises (exerciseId int AUTO_INCREMENT,"
                + " title varchar(255),"
                + " description varchar(500),"
                + " PRIMARY KEY(exerciseId))";

        String sql4 = "CREATE TABLE solutions (solutionId int AUTO_INCREMENT,"
                + " created date,"
                + " updated date,"
                + " exerciseId int,"
                + " userId int,"
                + " description varchar(255),"
                + " PRIMARY KEY(solutionId),"
                + " FOREIGN KEY(exerciseId) REFERENCES exercises(exerciseId),"
                + " FOREIGN KEY(userId) REFERENCES users(userId))";


        /* in order to create the database you need to create tables as follows */

//        createTables(sql);
//        createTables(sql2);
//        createTables(sql3);
//        createTables(sql4);



//        Scanner scanner = new Scanner(System.in);
//
//        //creating an user
//
//        System.out.println("Enter your username:");
//        String username = scanner.next();
//        System.out.println("Enter your password:");
//        String password = scanner.next();
//        System.out.println("Enter your email:");
//        String email = scanner.next();
//
//        userDaoImpl.createUser(username, email, password);
//
//        userDaoImpl.getAllUsers();
    }
}