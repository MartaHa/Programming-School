package dao;

import entity.User;
import jdbc.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//public class UserDaoImpl implements  UserDao{
//
//    ConnectionFactory connectionFactory;
//
//
//
//    //create user
//
//    @Override
//    public User createUser() {
//        return null;
//    }



    //get user by Id
//
//    @Override
//    public User getUserById(int id) {
//
//        Connection connection = connectionFactory.getConnection();
//        String sql = "SELECT * FROM users WHERE user_id =?";
//
//        try {
//            Statement stm = connection.createStatement();
//            ResultSet resultSet = stm.executeQuery(sql);
//
//            if(resultSet.next()){
//                User user = new User();
//                user.setUsername(resultSet.getString("user_username"));
//                user.setPassword(resultSet.getString("user_password"));
//                user.setEmail(resultSet.getString("user_email"));
//
//                return user;
//            }
//
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
