import java.io.*;
import java.util.*;

/**
 * 	@author Devon Tyson
 */

public class Controller {
	
	public static Player player;

	public static HashMap<String,Integer> playerStats() {
		
		Skill strength = player.getStrengthSkill();
		Skill defence = player.getDefenceSkill();
		Skill hp = player.getHitPointsSkill();
		
		int combatLevel = player.getCombatLevel();
		int strengthLevel = strength.getLevel();
		int defenceLevel = defence.getLevel();
		int hpLevel = hp.getLevel();
		
		HashMap<String, Integer> stats = new HashMap<String, Integer>();
		stats.put("Combat", combatLevel);
		stats.put("Strength", strengthLevel);
		stats.put("Defence", defenceLevel);
		stats.put("HitPoints", hpLevel);
		
		return stats;
	}
	
	public static void trainingMode(Skill skill, int addedXp) {
		
		Skill hp = player.getHitPointsSkill();
		player.trainSkill(skill, addedXp);
		player.trainSkill(hp, addedXp);
	}
	
	public static void battleMode(Player other) {
		
		// implemented later
		
	}
	
	public static void createPlayer(String name) throws IOException {
		
		player = new Player(name);
		saveData();
	}
	
	public static void saveData() throws IOException {
		
		File file = new File("database.dat");
		
		FileOutputStream fileStream = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileStream);
		
		out.writeObject(player);
		
		out.close();
		fileStream.close();
	}
	
	public static void getData() throws IOException, ClassNotFoundException {
		
		try {
			File file = new File("database.dat");
			
			// if file doesn't exist, user must create a new player
			if(!file.exists()) {
				String name = View.getNewUsername("Error, user not found.");
				createPlayer(name);
			}
			
			FileInputStream fileStream = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fileStream);
			player = (Player) in.readObject();
			
			in.close();
			fileStream.close();
			
		} catch(ClassNotFoundException e) {
			
			// exception handled above
		}
	}
	
	public static boolean doesDatabaseExist() {
		
		File file = new File("database.dat");
		if(file.exists()) {
			return true;
		} else {
			return false;
		}
	}
}
