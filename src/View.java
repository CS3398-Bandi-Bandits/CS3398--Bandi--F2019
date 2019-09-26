/**
 * 	@author Devon Tyson
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.ResourceBundle.Control;
import java.util.Scanner;

public class View {

	public static void beginningPrompt() throws IOException, ClassNotFoundException {
		
		boolean exist = Controller.doesDatabaseExist();
		
		// if account exists, go straight to the main page
		if(exist == true) {
			Controller.getData();
			System.out.println("Welcome back, " + Controller.player.getUsername() + "!");
			System.out.println();
			
		// otherwise, create a new user
		} else {
			System.out.println("Please create an account!");
			System.out.println();
			String name = getNewUsername();
			Controller.createPlayer(name);
		}
		
		mainScreen();
	}
	
	public static String getNewUsername() {
		
		System.out.print("Enter new username: ");
		
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		System.out.println();
		
		return name;
	}
	
	// alternate function for error handling
	public static String getNewUsername(String error) {
		
		System.out.println(error);
		System.out.print("Enter new username: ");
		
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		System.out.println();
		
		return name;
	}
	
	public static void mainScreen() throws IOException {
		
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
				showStats();
				break;
		
			case 2:
				trainingScreen();
				break;
			
			case 3:
				Controller.saveData();
				System.exit(0);
		}
	}
	
	public static void showStats() throws IOException {
		
		HashMap<String, Integer> stats = Controller.playerStats();
		
		for (Entry<String, Integer> entry : stats.entrySet())  
            System.out.println(entry.getKey() + 
                             ": " + entry.getValue());
		System.out.println();
		mainScreen();
	}
	
	public static void trainingScreen() throws IOException {
		
		Skill skill;
		int xp;
		
		System.out.println("1. Train strength");
		System.out.println("2. Train defence");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter selection: ");
		int num = scan.nextInt();
		System.out.println();
		
		
		//// this is where Jose's workout data will come in and replace this
		System.out.print("Enter xp amount: ");
		xp = scan.nextInt();
		System.out.println();
		
		switch(num) {
			case 1:
				skill = Controller.player.getStrengthSkill();
				Controller.trainingMode(skill, xp);
				break;
		
			case 2:
				skill = Controller.player.getDefenceSkill();
				Controller.trainingMode(skill, xp);
				break;
		}
		
		mainScreen();
	}
}
