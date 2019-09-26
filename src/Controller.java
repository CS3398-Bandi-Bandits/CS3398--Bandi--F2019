import java.io.*;
import java.util.*;

/**
 * 	@author Devon Tyson
 */

public class Controller {
	
	public static Player player;
	public static final String DATABASE_FILE = "database.dat";

	public static HashMap<String,Integer> playerStats() {
		
		Skill strength = player.getStrengthSkill();
		Skill defence = player.getDefenceSkill();
		Skill hp = player.getHitPointsSkill();
		
		int combatLevel = player.getCombatLevel();
		int strengthLevel = strength.getLevel();
		int defenceLevel = defence.getLevel();
		int hpLevel = hp.getLevel();
		
		HashMap<String, Integer> stats = new HashMap<String, Integer>();
		stats.put(player.getCombatString(), combatLevel);
		stats.put(strength.toString(), strengthLevel);
		stats.put(defence.toString(), defenceLevel);
		stats.put(hp.toString(), hpLevel);
		
		return stats;
	}
	
	public static void trainingMode(Skill skill, int addedXp) throws IOException {
		
		Skill hp = player.getHitPointsSkill();
		player.trainSkill(skill, addedXp);
		player.trainSkill(hp, addedXp);
		saveData();
	}
	
	public static void battleMode(Player other) {
		
		// implemented later
		
	}
	
	public static void createPlayer(String name) throws IOException {
		
		player = new Player(name);
		saveData();
	}
	
	public static void saveData() throws IOException {
		
		File file = new File(DATABASE_FILE);
		
		FileOutputStream fileStream = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileStream);
		
		out.writeObject(player);
		
		out.close();
		fileStream.close();
	}
	
	public static void getData() throws IOException, ClassNotFoundException {
		
		File file = new File(DATABASE_FILE);
			
		FileInputStream fileStream = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fileStream);
		player = (Player) in.readObject();
			
		in.close();
		fileStream.close();
	}
	
	public static boolean doesDatabaseExist() {
		
		File file = new File(DATABASE_FILE);
		if(file.exists()) {
			return true;
		} else {
			return false;
		}
	}
}
