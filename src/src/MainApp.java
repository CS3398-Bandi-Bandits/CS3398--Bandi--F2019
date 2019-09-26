/**
 * 	@author Devon Tyson
 */

import java.io.*;

public class MainApp {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		View.beginningPrompt();
		
		
		//testing
		View.showStats();
		
		int xp = 200000;
		Skill skill = Controller.player.getStrengthSkill();
		Controller.trainingMode(skill, xp);
		
		View.showStats();
	}
}
