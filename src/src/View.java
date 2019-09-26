/**
 * 	@author Devon Tyson
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class View {
	

	public static void showStats() throws IOException {
		HashMap<String, Integer> stats = Controller.playerStats();
		
		for (Entry<String, Integer> entry : stats.entrySet())  
            System.out.println(entry.getKey() + 
                             ": " + entry.getValue());
		System.out.println();
		mainScreen();
	}

	public static String getNewUsername() {
		System.out.print("Enter new username: ");
		
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		
		System.out.println();
		System.out.println("New player, " + name + ", created.");
		
		return name;
	}
	
	public static void beginningPrompt() throws IOException, ClassNotFoundException {
		System.out.println("1. Create User");
		System.out.println("2. Existing User");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter selection: ");
		System.out.println();
		int num = scan.nextInt();
		
		switch(num) {
		case 1:
			String name = getNewUsername();
			Controller.createPlayer(name);
			Controller.getData();
		
		case 2:
			Controller.getData();
		}
		mainScreen();
	}
	
	public static void mainScreen() throws IOException {
		System.out.println("1. View Stats");
		System.out.println("2. Train Skill");
		System.out.println("3. Exit");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter selection: ");
		System.out.println();
		int num = scan.nextInt();
		
		switch(num) {
		case 1:
			showStats();
		
		case 2:
			trainSkill();
			
		case 3:
			Controller.saveData();
			System.exit(0);
		}
	}
	
	public static void trainSkill() throws IOException {
		
		Skill skill;
		int xp;
		
		System.out.println("1. Train strength");
		System.out.println("2. Train defence");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter selection: ");
		System.out.println();
		int num = scan.nextInt();
		
		System.out.println("Enter xp amount: ");
		xp = scan.nextInt();
		
		switch(num) {
		case 1:
			skill = Controller.player.getStrengthSkill();
		
		case 2:
			skill = Controller.player.getDefenceSkill();
			
		default:
			skill = Controller.player.getStrengthSkill();
		}
		
		Controller.trainingMode(skill, xp);
		mainScreen();
	}
}
