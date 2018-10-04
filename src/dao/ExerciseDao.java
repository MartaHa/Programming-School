package dao;

import entity.Exercise;
import java.util.Set;

public interface ExerciseDao {

    boolean create(String title, String desciption);
    Exercise getById(int id);
    Set<Exercise> getAll();
    boolean deleteExercise(int id);
}
