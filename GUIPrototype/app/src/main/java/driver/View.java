package driver;
/**
 * 	@author Devon Tyson
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

import WOPackage.*;


public class View {

	public static void beginningPrompt() throws IOException, ClassNotFoundException {
		
	/*	boolean exists = Controller.doesDatabaseExist();
		
		// if account exists, go straight to the main page
		if(exists == true) {
			Controller.getData();
			System.out.println("Welcome back, " + Controller.getPlayer().getUsername() + "!");
			System.out.println();
			
		// otherwise, create a new user
		} else {
			System.out.println("Please create an account.");
			System.out.println();
			String name = getNewUsername();
			Controller.createPlayer(name);
		}
		
		mainScreen();*/
	}
	
	private static String getNewUsername() {
		
		System.out.print("Enter new username: ");
		
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		System.out.println();
		
		return name;
	}
	
	public static void mainScreen() throws IOException, ClassNotFoundException {
		
		System.out.println("1. View Stats");
		System.out.println("2. Train Skill");
		System.out.println("3. Exit");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter selection: ");
		int num = scan.nextInt();
		System.out.println();
		
		switch(num) {
			case 1:
				//showStats();
				break;
		
			case 2:
				trainingScreen();
				break;
			
			case 3:
				Controller.saveData();
				System.exit(0);
		}
	}
	
	/*public static void showStats() throws IOException {
		
		HashMap<String, Integer> stats = Controller.playerStats();
		
		for (Entry<String, Integer> entry : stats.entrySet())  
            System.out.println(entry.getKey() + 
                             ": " + entry.getValue());
		System.out.println();
		mainScreen();
	}*/
	
	public static void trainingScreen() throws IOException, ClassNotFoundException {
		
		Skill skill;
		WorkoutLog log = new WorkoutLog();
		
		ArrayList<String> options = log.getOptions();
		
		System.out.println("Select a workout:");
		for(int i = 0; i < options.size(); i++) {
			System.out.println(i+1 + ": " + options.get(i));
		}
		
		System.out.println();
		System.out.print("Enter selection: ");
		
		Scanner scan = new Scanner(System.in);
		int selected = scan.nextInt();
		String name;
		
		if(selected == 1) {
			name = "bench press";
		} else if(selected == 2) {
			name = "squat";
		} else {
			name = "dead-lift";
		}
		
		log.createExercise(name);
		System.out.println();
		
		System.out.print("Add reps: ");
		int reps = scan.nextInt();
		System.out.println();
		
		System.out.print("Add weight: ");
		double weight = scan.nextDouble();
		System.out.println();
		
		log.getCurrent().addSet(reps, weight);
		
		log.logExercise();
		int xpTotal = log.getTotalExp();
		
		if(log.getCurrent().getName().toLowerCase().equals("squat")) {
			skill = Controller.getPlayer().getDefenceSkill();
		} else {
			skill = Controller.getPlayer().getStrengthSkill();
		}
		
		
		Controller.trainingMode(skill, xpTotal);
		System.out.println();
		System.out.println("You gained " + xpTotal + " experience!");
		System.out.println();
		
		/*
		 * System.out.println("1. Train strength");
		 * System.out.println("2. Train defence"); System.out.println(); Scanner scan =
		 * new Scanner(System.in);
		 * 
		 * System.out.print("Enter selection: "); int num = scan.nextInt();
		 * System.out.println();
		 * 
		 * 
		 * //// this is where Jose's workout data will come in and replace this
		 * System.out.print("Enter xp amount: "); xp = scan.nextInt();
		 * System.out.println();
		 * 
		 * switch(num) { case 1: skill = Controller.getPlayer().getStrengthSkill();
		 * Controller.trainingMode(skill, xp); break;
		 * 
		 * case 2: skill = Controller.getPlayer().getDefenceSkill();
		 * Controller.trainingMode(skill, xp); break; }
		 */
		mainScreen();
	}
}
