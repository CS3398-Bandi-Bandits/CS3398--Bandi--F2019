package WOPackage;
import java.io.Serializable;
public class WorkoutSet implements Serializable{

    private int reps;
    private double weight;

    public WorkoutSet(int reps, double weight) {

        this.reps = reps;
        this.weight = weight;

    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getReps() {
        return reps;
    }

    public double getWeight() {
        return weight;
    }

}
