package dao;

import entity.User;

import java.util.Set;

public interface UserDao {


   boolean createUser(String username, String password, String email);
   User getUserByUserId(int userId);
   Set <User> getAllUsers();
   boolean updateUserbyId(String username, String password, String email, int userId);
   boolean deleteUser(int userId);
   Set <User> loadAllByGroupId(int groupId);

}
