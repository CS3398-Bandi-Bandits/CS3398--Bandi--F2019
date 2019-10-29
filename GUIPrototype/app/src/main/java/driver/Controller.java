package driver;

import android.app.Activity;

import java.io.*;
import java.util.*;
import WOPackage.*;

/**
 * 	@author Devon Tyson
 */

public class Controller {
	
	public static Player player;
	private static final String DATABASE_FILE = "database.dat";
	public static WorkoutLog log;
	

	public static HashMap<String, String> playerStats() {

        Skill strength = player.getStrengthSkill();
        Skill defence = player.getDefenceSkill();
        Skill hp = player.getHitPointsSkill();
        Skill speed = player.getSpeedSkill();

        String combatLevel = String.valueOf(player.getCombatLevel());
        String strengthLevel = String.valueOf(strength.getLevel());
        String defenceLevel = String.valueOf(defence.getLevel());
        String hpLevel = String.valueOf(hp.getLevel());
        String speedLevel = String.valueOf(speed.getLevel());

        HashMap<String, String> stats = new HashMap<String, String>();
        stats.put(player.getCombatString(), combatLevel);
        stats.put(strength.toString(), strengthLevel);
        stats.put(defence.toString(), defenceLevel);
        stats.put(speed.toString(), speedLevel);
        stats.put(hp.toString(), hpLevel);

        return stats;
	}
	
	public static void trainingMode(Skill skill, int addedXp) throws IOException {
		
		Skill hp = player.getHitPointsSkill();
		player.trainSkill(skill, addedXp);
		player.trainSkill(hp, addedXp);
		//saveData();
	}
	
	public static void battleMode(Player other) {
		
		// implemented later
		
	}
	
	public static Player createPlayer(String name) throws ClassNotFoundException, IOException{
		
		player = new Player(name);
		return player;
	}
	
	public static Player getPlayer() throws ClassNotFoundException, IOException{

		getData();
		return player;
	}

	public static void setPlayer(Player p) {
		player = p;
	}
	
	public static void saveData() throws IOException {
		
		File file = new File(DATABASE_FILE);

		FileOutputStream fileStream = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileStream);

		out.writeObject(player);

		out.close();
		fileStream.close();


	}

	public static void saveWOData(String username) throws IOException {

		File file = new File(username +"WO.dat");

		FileOutputStream fileStream = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(fileStream);

		out.writeObject(log);

		out.close();
		fileStream.close();


	}

	public static void getLog() {

		log = new WorkoutLog();
	}

	public static void setLog(WorkoutLog l){
		log = l;
	}

	public static WorkoutLog returnLog(){
		return log;
	}

	public static void getData() throws IOException, ClassNotFoundException {
		
		File file = new File(DATABASE_FILE);
			
		FileInputStream fileStream = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(fileStream);
		
		player = (Player) in.readObject();
			
		in.close();
		fileStream.close();
	}



	
	public static boolean doesDatabaseExist(String[] files) throws IOException, ClassNotFoundException{

		for(String file : files) {
			if (file.equals(DATABASE_FILE)) {
				return true;
			}
		}
		return false;
	}
}
