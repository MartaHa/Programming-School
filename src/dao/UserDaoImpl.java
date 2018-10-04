package dao;

import entity.User;
import jdbc.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserDaoImpl implements UserDao {

    ConnectionFactory connectionFactory;


    //create user

    @Override
    public boolean createUser(String username, String password, String email) {
        Connection connection = connectionFactory.getConnection();
        String sql = "INSERT INTO users (userId, username, email, password) VALUES (null,?,?,?)";


        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, username);
            pstm.setString(2, email);
            pstm.setString(3, password);
            int i = pstm.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    // get user by Id
    @Override
    public User getUserByEmail(int userId) {

        Connection connection = connectionFactory.getConnection();
        String sql = "SELECT * FROM users WHERE userId =?";

        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);

            if (resultSet.next()) {
                extractUserFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //update user by id

    @Override
    public boolean updateUserbyEmail(String username, String password, String email) {

        Connection connection = connectionFactory.getConnection();
        String sql = "(UPDATE user SET username=?, password=?, WHERE userId=?);";

        try {
            PreparedStatement prstm = connection.prepareStatement(sql);
            prstm.setString(1, username);
            prstm.setString(2, password);
            int i = prstm.executeUpdate();


            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return false;
    }


    //getAllUSers

    @Override
    public Set<User> getAllUsers() {
        Connection connection = connectionFactory.getConnection();
        String sql = "SELECT * FROM users";
        try {
            Statement stm = connection.createStatement();

            ResultSet resultSet = stm.executeQuery(sql);
            Set<User> allUsers = new HashSet();


            if (resultSet.next()) {
                User user = extractUserFromResultSet(resultSet);
                allUsers.add(user);
            }
            return allUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //getting the user from the Result Set

    private User extractUserFromResultSet(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserId(resultSet.getInt("userId"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        System.out.println("Your user account has been created");
        return user;
    }


    //deleteUser

    public boolean deleteUser(int userId) {

        Connection connection = connectionFactory.getConnection();
        String sql = "DELETE FROM users WHERE userId=";
        try {
            Statement stm = connection.createStatement();
            int i = stm.executeUpdate(sql + userId);

            if (i == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    /* get Users by UserGroup */

    @Override
    public Set<User> loadAllByGroupId(int groupId) {

        Connection connection = connectionFactory.getConnection();
        String sql = "SELECT * FROM users WHERE userGroupId=";
        try {
            Statement stm = connection.createStatement();

            ResultSet resultSet = stm.executeQuery(sql + groupId);
            Set<User> allUsers = new HashSet();


            if (resultSet.next()) {
                User user = extractUserFromResultSet(resultSet);
                allUsers.add(user);
            }
            return allUsers;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
