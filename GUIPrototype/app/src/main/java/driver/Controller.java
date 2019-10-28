package driver;

import java.io.*;
import java.util.*;
import WOPackage.*;

/**
 * 	@author Devon Tyson
 */

public class Controller {
	
	private static Player player;
	private static final String DATABASE_FILE = "database.dat";
	

	public static HashMap<String,String> playerStats() {
		
		Skill strength = player.getStrengthSkill();
		Skill defence = player.getDefenceSkill();
		Skill hp = player.getHitPointsSkill();
		
		String combatLevel = String.valueOf(player.getCombatLevel());
		String strengthLevel = String.valueOf(strength.getLevel());
		String defenceLevel = String.valueOf(defence.getLevel());
		String hpLevel = String.valueOf(hp.getLevel());
		
		HashMap<String, String> stats = new HashMap<String, String>();
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
	
	public static Player getPlayer() {
		
		return player;
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
