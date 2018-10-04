package main;


import dao.UserDaoImpl;
import entity.User;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

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

        /*printig all users */



        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(" Witaj w panelu użytkownika. Wybierz jedną z opcji:\n" +
                    "    add – dodanie użytkownika,\n" +
                    "    print – wyświetl listę użytkowników,\n" +
                    "    edit – edycja użytkownika,\n" +
                    "    delete – usunięcie użytkownika,\n" +
                    "    quit – zakończenie programu.\"\n");

            String answer = scanner.next();
            switch (answer) {

                case "add": {

                    //creating an user

                    System.out.println("Enter your username:");
                    String username = scanner.next();
                    System.out.println("Enter your password:");
                    String password = scanner.next();
                    System.out.println("Enter your email:");
                    String email = scanner.next();

                    userDaoImpl.createUser(username, email, password);
                    break;
                }
                case "print": {

                    userDaoImpl.printUsers();
                    break;
                }

                case "edit": {

                    /* user edition */

                    System.out.println("Enter your user id:");
                    int userId = scanner.nextInt();
                    System.out.println("Enter your username:");
                    String username = scanner.next();
                    System.out.println("Enter your password:");
                    String password = scanner.next();
                    System.out.println("Enter your email:");
                    String email = scanner.next();

                    userDaoImpl.updateUserbyId(username, password, email, userId);
                    break;
                }

                /* user delete*/

                case "delete": {
                    System.out.println("Enter your user id:");
                    int userId = scanner.nextInt();
                    userDaoImpl.deleteUser(userId);
                    break;
                }

                /* quit */


                case "quit": {
                    System.out.println("Goodbye");
                    break;
                }

                default: {
                    System.out.println("Command unnkown");
                    scanner.next();
                }
            }
        }
    }
}


