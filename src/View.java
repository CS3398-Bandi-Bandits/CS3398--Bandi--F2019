/**
 * 	@author Devon Tyson
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class View {
	

	public static void showStats() {
		HashMap<String, Integer> stats = Controller.playerStats();
		
		for (Entry<String, Integer> entry : stats.entrySet())  
            System.out.println(entry.getKey() + 
                             ": " + entry.getValue());
		System.out.println();
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
	}
}
