/**
 * 	@author Devon Tyson
 */

import java.io.*;

public class MainApp {

	public static void main(String[] args) {
		
		// Create all database connections
		// Create main UI instance
		Player mainPlayer = new Player("Username");
		Controller manager = new Controller(mainPlayer);
		View viewer = new View(manager);
		
		//testing
		viewer.showStats();
		
		Skill skill = mainPlayer.getStrengthSkill();
		int xp = 200000;
		manager.trainingMode(skill, xp);
		
		viewer.showStats();
	}
	
	public static void saveData() throws FileNotFoundException {
		
	}
	
	public static void getData() throws FileNotFoundException {
		
	}

}
