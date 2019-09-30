package WOPackage;

import java.util.ArrayList;


public class Exercise {

    private String name;
    private ArrayList<WorkoutSet> sets;

    public Exercise(String name){
        this.name = name;
        this.sets = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addSet(int reps, double weight) {
        WorkoutSet temp = new WorkoutSet(reps,weight);
        this.sets.add(temp);
    }

    public String getName() {
        return name;
    }

    public WorkoutSet getSet(int i){
        return sets.get(i);
    }

    public int numSets(){
        return sets.size();
    }

    public Double getAverageWeight(){
        Double average = 0.0;

        for (int i = 0; i <sets.size(); i++) {
            average += sets.get(i).getWeight();
        }
        average = average/sets.size();

        return average;
    }

    public Integer getAverageReps(){
        Integer average = 0;

        for (int i = 0; i <sets.size(); i++) {
            average += sets.get(i).getReps();
        }
        average = average/sets.size();

        return average;
    }

    public void printExercise(){

        System.out.println(name);

        for (int i = 0; i < sets.size(); i++) {
            System.out.println(sets.get(i).getReps() + " reps @ " + sets.get(i).getWeight()
                                + "lbs.");
        }
    }

    public ArrayList<WorkoutSet> getSets() {
        return sets;
    }
}
