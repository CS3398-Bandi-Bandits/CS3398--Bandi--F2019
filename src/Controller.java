/**
 * 	@author Devon Tyson
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

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
		
		FileOutputStream file = new FileOutputStream("database.dat");
		ObjectOutputStream out = new ObjectOutputStream(file);
		
		out.writeObject(player);
		
		out.close();
		file.close();
	}
	
	public static void getData() throws IOException, ClassNotFoundException {
		
		try {
			FileInputStream fileStream = new FileInputStream("database.dat");
			ObjectInputStream in = new ObjectInputStream(fileStream);
			
			player = (Player) in.readObject();
			
			in.close();
			fileStream.close();
			
		} catch(ClassNotFoundException e) {
			
			String name = View.getNewUsername();
			createPlayer(name);
		}
		
	}
	
}
