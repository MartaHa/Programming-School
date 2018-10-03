package entity;

public class Exercise {

    private int exerciseId;
    private String title;
    private String description;

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Exercise() {
    }

    public Exercise(int exerciseId, String title, String description) {
        this.exerciseId = exerciseId;
        this.title = title;
        this.description = description;
    }
}
