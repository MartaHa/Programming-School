package dao;

import entity.UserGroup;

import java.util.Set;

public interface UserGroupDao {

    boolean create(String name);
    UserGroup getById(int id);
    Set<UserGroup> getAll();
    boolean deleteUserGroup(int id);
}

