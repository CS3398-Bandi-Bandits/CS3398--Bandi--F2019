
/*
* Author: Jose Herrera
*
* Sample usage of the workout classes.  when testing please use only 0 for input.
*
*
*
* */

package WOPackage;

import java.util.Scanner;
import java.io.*;

public class ConsoleApp {

    public static void main(String[] args){

        String[] options = {"Bench Press","Dead-Lift","Squat"};

        Scanner input = new Scanner(System.in);

        WorkoutLog wLog = new WorkoutLog(options);

        Integer exerciseSelection,
                setSelection,
                sampleReps = 10;

        Double sampleWeight = 175.0;

        System.out.println("What kind of workout would you like to log?");
        System.out.println("Press 0 for Bench Press, 1 for Dead-Lift, or 2 for Squat.");

        exerciseSelection = input.nextInt();

        //Creates a new instance of Exercise class and assigns it to current in Log.
        wLog.createExercise(options[exerciseSelection]);

        //Appends the Exercise to an ArrayList serving as a backlog.
        //The WorkoutLog class holds an integer for experience.  If the user logs an
        //Exercise with the same title as one that already exists in the backlog then
        //the logExercise() method will call calcImprovementExp() and store the result in the exp variable.
        //If there was improvement then exp will be set to a positive integer, otherwise, it will be
        //set to 0. exp can be retrieved via getImprovementExp().
        wLog.logExercise();

        System.out.println("For your current Exercise would you like to add a set?");
        System.out.println("0 for yes 1 for no");

        setSelection = input.nextInt();

        if (setSelection.equals(0))
            wLog.getCurrent().addSet(sampleReps,sampleWeight);

        wLog.getCurrent().printExercise();


    }

}
