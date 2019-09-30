package WOPackage;

import java.util.ArrayList;
import java.io.*;

public class WorkoutLog implements Serializable{
    private String[] options;
    private ArrayList<Exercise> backLog;
    private Exercise current;
    private Integer improvementExp,
                    baseExp;

    public WorkoutLog(String[] options){
        this.options = options;
        this.improvementExp = 0;
        this.baseExp = 0;
        this.backLog = new ArrayList<>();
    }

    public void createExercise (String name){
        this.current = new Exercise(name);
    }

    public void logExercise() {

        if (backLog.isEmpty())
            backLog.add(current);

        else{
            for (int i = 0; i < backLog.size(); i++) {

                if (backLog.get(i).getName().equals(current.getName())) {
                    improvementExp = calcImprovementExp(backLog.get(i), current);
                    backLog.remove(i);
                    backLog.add(i,current);
                }
                else
                    backLog.add(current);

            }
        }

        baseExp = calcBaseExp(current);
    }

    public int calcImprovementExp(Exercise old, Exercise current){

        int exp = 0;

        double weightImprovement = current.getAverageWeight()- old.getAverageWeight();

        Integer repImprovement = current.getAverageReps() - old.getAverageReps();

        Integer improvement = repImprovement + (int)weightImprovement;

        if (improvement > 0)
            exp = improvement * 10000;
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

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int getTotalExp(){

        int i = baseExp + improvementExp;
        return i;
    }
}
