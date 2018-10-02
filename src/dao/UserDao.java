package dao;

import entity.User;

public interface UserDao {


   User createUser();
   User getUserById(int id);


}
