package dao;

import entity.Exercise;
import entity.Solution;
import jdbc.ConnectionFactory;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ExerciseDaoImpl implements ExerciseDao {

    ConnectionFactory connectionFactory;

    /* creating Exercise */


    @Override
    public boolean create(String title, String description) {
        Connection connection = connectionFactory.getConnection();
        String sql = "INSERT INTO exercises (exerciseId, title, description) VALUES (null,?,?)";


        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1, title);
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


    /* Get Exercise by Id */

    @Override
    public Exercise getById(int exerciseId) {
        Connection connection = connectionFactory.getConnection();
        String sql = "SELECT * FROM exercises WHERE exerciseId =?";

        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);

            if (resultSet.next()) {
                extractExerciseFromResultSet(resultSet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    //getting the Exercise from the Result Set

    private Exercise extractExerciseFromResultSet(ResultSet resultSet) throws SQLException {

        Exercise exercise = new Exercise();
        exercise.setExerciseId(resultSet.getInt("exerciseId"));
        exercise.setTitle(resultSet.getString("title"));
        exercise.setDescription(resultSet.getString("description"));

        return exercise;
    }


    /*get All Exercises */

    @Override
    public Set<Exercise> getAll() {
        Connection connection = connectionFactory.getConnection();

        String sql = "SELECT * FROM exercises";
        try {
            Statement stm = connection.createStatement();

            ResultSet resultSet = stm.executeQuery(sql);
            Set<Exercise> allExercises = new HashSet();


            if (resultSet.next()) {
                Exercise exercise = extractExerciseFromResultSet(resultSet);
                allExercises.add(exercise);
            }
            return allExercises;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /* delete exercise by Id */

    @Override
    public boolean deleteExercise(int exerciseId) {
        Connection connection = connectionFactory.getConnection();

        String sql = "DELETE FROM exercises WHERE exerciseId=";
        try {
            Statement stm = connection.createStatement();
            int i = stm.executeUpdate(sql + exerciseId);

            if (i == 1) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}


