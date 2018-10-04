package dao;

import entity.User;

import java.util.Set;

public interface UserDao {


   boolean createUser(String username, String password, String email);
   User getUserByEmail(int userId);
   Set <User> getAllUsers();
   boolean updateUserbyEmail(String username, String password, String email);
   boolean deleteUser(int userId);
   Set <User> loadAllByGroupId(int groupId);

}
