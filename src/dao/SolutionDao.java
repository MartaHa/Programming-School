package dao;


import entity.Solution;
import java.sql.Date;
import java.util.Set;

public interface SolutionDao<R> {

    boolean create(Date created, String desciption);
    Solution getById(int id);
    Set<Solution> getAll();
    boolean deleteSolution(int id);
}
