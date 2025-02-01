package JA11ExamPreparation.E16_25_Jun_2022.E03Workout;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Workout {

    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getExerciseCount() {
        return exerciseCount;
    }

    public void setExerciseCount(int exerciseCount) {
        this.exerciseCount = exerciseCount;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    public void addExercise(Exercise exercise) {
        if (exerciseCount > exercises.size()) {
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle) {
        return exercises.removeIf(exercise -> exercise.getName().equals(name)
                && exercise.getMuscle().equals(muscle));


    }

    public Exercise getExercise(String name, String muscle) {
        return exercises.stream()
                .filter(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle))
                .findFirst()
                .orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise() {
        return exercises.stream().max(Comparator.comparing(Exercise::getBurnedCalories))
                .orElse(null);
    }

    public int getExercisesCount() {
        return exercises.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append("Workout type: ").append(type).append("\n");
        exercises.forEach(exercise -> statistics.append("Exercise: ").append(exercise.toString()).append("\n"));
        return statistics.toString();
    }
}