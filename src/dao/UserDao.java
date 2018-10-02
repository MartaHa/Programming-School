package dao;

import entity.User;

import java.util.Set;

public interface UserDao {


   boolean createUser(String username, String password, String email);
   User getUserByEmail(String email);
   Set <User> getAllUsers();
   boolean updateUserbyEmail(String username, String password, String email);
   boolean deleteUser(String email);


}
