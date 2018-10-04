package dao;

import entity.Exercise;
import entity.Solution;

import java.sql.Date;
import java.util.Set;

public interface ExerciseDao {

    boolean create(String title, String desciption);
    Exercise getById(int id);
    Set<Exercise> getAll();
    boolean deleteExercise(int id);
}
