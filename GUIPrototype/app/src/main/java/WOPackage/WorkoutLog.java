package WOPackage;

import java.util.ArrayList;
import java.io.*;

public class WorkoutLog implements Serializable{
    private ArrayList<String> options;
    private ArrayList<Exercise> backLog;
    public Exercise current;
    public Integer improvementExp,
                    baseExp;

    public WorkoutLog(){
        this.options = new ArrayList<>();
        this.options.add("Bench Press");
        this.options.add("Squat");
        this.options.add("Dead-Lift");
        this.improvementExp = 0;
        this.baseExp = 0;
        this.backLog = new ArrayList<>();
    }

    public void createExercise (String name){
        this.current = new Exercise(name);
    }

    public void logExercise() {

        if (!backLog.isEmpty())

            for (int i = 0; i < backLog.size(); i++) {

                if (backLog.get(i).getName().equals(current.getName())) {
                    improvementExp = calcImprovementExp(backLog.get(i), current);
                    
                    
                    //testing
                    //System.out.println(backLog.get(i).getName());
                    backLog.add(current);
                }
                else
                    backLog.add(current);
            }
        else
            backLog.add(current);

        baseExp = calcBaseExp(current);
    }

    public int calcImprovementExp(Exercise old, Exercise current){

        int exp = 0;

        double weightImprovement = current.getAverageWeight()- old.getAverageWeight();

        Integer repImprovement = current.getAverageReps() - old.getAverageReps();

        Integer improvement = repImprovement + (int)weightImprovement;

        if (improvement > 0)
            exp = improvement * 1000;
        else
            exp = 0;

        return exp;

    }

    public int calcBaseExp(Exercise e){

        int exp = 0;

        for (int i = 0; i < e.getSets().size() ; i++) {
            exp = (int) (e.getSet(i).getReps() * e.getSet(i).getWeight());
        }

        return exp;
    }

    public Exercise getMatch(String name){

        Exercise e = new Exercise(name);
        for (int i = 0; i < backLog.size() ; i++) {
            if (backLog.get(i).getName().equals(name))
            {e = backLog.get(i);}
        }

        return e;

    }

    public void setCurrent(Exercise current) {
        this.current = current;
    }

    public Integer getImprovementExp() {
        return improvementExp;
    }

    public Integer getBaseExp() {
        return baseExp;
    }

    public Exercise getCurrent() {
        return current;
    }

    public void setBackLog(ArrayList<Exercise> backLog) {
        this.backLog = backLog;
    }

    public ArrayList<Exercise> getBackLog() {
        return backLog;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public int getTotalExp(){

        int i = baseExp + improvementExp;
        return i;
    }
}
