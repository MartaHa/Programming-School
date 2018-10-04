package dao;


import entity.Solution;
import entity.User;
import entity.UserGroup;
import jdbc.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class UserGroupDaoImpl implements  UserGroupDao{

    ConnectionFactory connectionFactory;

    /* creating Solution */


    @Override
    public boolean create(String name) {
        Connection connection = connectionFactory.getConnection();

        String sql = "INSERT INTO usergroups (userGroupId, name) VALUES (null,?)";


        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, name);
            int i = pstm.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    /* Get UserGroup by Id */

    @Override
    public UserGroup getById(int id) {
        Connection connection = connectionFactory.getConnection();
        String sql = "SELECT * FROM usergroups WHERE userGroupId =?";

        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);

            if (resultSet.next()) {
                extractSolutionFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    //getting the user groups from the Result Set

    private UserGroup extractSolutionFromResultSet(ResultSet resultSet) throws SQLException {
        UserGroup userGroup = new UserGroup();
        userGroup.setId(resultSet.getInt("userGroupId"));
        userGroup.setName(resultSet.getString("name"));


        return userGroup;
    }


    /*get All user groups */

    @Override
    public Set<UserGroup> getAll() {
        Connection connection = connectionFactory.getConnection();

        String sql = "SELECT * FROM usergroups";
        try {
            Statement stm = connection.createStatement();

            ResultSet resultSet = stm.executeQuery(sql);
            Set<UserGroup> allUserGroups = new HashSet();


            if (resultSet.next()) {
                UserGroup userGroup = extractSolutionFromResultSet(resultSet);
                allUserGroups.add(userGroup);
            }
            return allUserGroups;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /* delet solution by Id */

    @Override
    public boolean deleteUserGroup(int userGroupId) {
        Connection connection = connectionFactory.getConnection();
        String sql = "DELETE FROM usergroups WHERE userGroupId=";
        try {
            Statement stm = connection.createStatement();
            int i = stm.executeUpdate(sql + userGroupId);

            if (i == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


