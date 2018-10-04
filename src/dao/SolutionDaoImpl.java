package dao;

import entity.Solution;
import entity.User;
import jdbc.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class SolutionDaoImpl implements SolutionDao {

    ConnectionFactory connectionFactory;

    /* creating Solution */


    @Override
    public boolean create(Date created, String description) {
        Connection connection = connectionFactory.getConnection();
        String sql = "INSERT INTO solutions (userId, username, email, password) VALUES (null,?,?)";


        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setDate(1, created);
            pstm.setString(2, description);
            int i = pstm.executeUpdate();

            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    /* Get Solution by Id */

    @Override
    public Solution getById(int id) {
        Connection connection = connectionFactory.getConnection();
        String sql = "SELECT * FROM solutions WHERE solutionId =?";

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

    //getting the Solution from the Result Set

    private Solution extractSolutionFromResultSet(ResultSet resultSet) throws SQLException {
        Solution solution = new Solution();
        solution.setSolutionId(resultSet.getInt("solutionId"));
        solution.setCreated(resultSet.getDate("created"));
        solution.setDescription(resultSet.getString("description"));

        return solution;
    }


    /*get All Solutions */

    @Override
    public Set<Solution> getAll() {
        Connection connection = connectionFactory.getConnection();

        String sql = "SELECT * FROM solutions";
        try {
            Statement stm = connection.createStatement();

            ResultSet resultSet = stm.executeQuery(sql);
            Set<Solution> allSolutions = new HashSet();


            if (resultSet.next()) {
                Solution solution = extractSolutionFromResultSet(resultSet);
                allSolutions.add(solution);
            }
            return allSolutions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /* delet solution by Id */

    @Override
    public boolean deleteSolution(int solutionId) {
        Connection connection = connectionFactory.getConnection();
        String sql = "DELETE FROM solutions WHERE solutionId=";
        try {
            Statement stm = connection.createStatement();
            int i = stm.executeUpdate(sql + solutionId);

            if (i == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
