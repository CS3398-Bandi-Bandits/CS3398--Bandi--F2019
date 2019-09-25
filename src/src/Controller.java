/**
 * 	@author Devon Tyson
 */

import java.util.*;

public class Controller {
	
	Player player;
	
	public Controller(Player player) {
		this.player = player;
	}

	public HashMap<String,Integer> playerStats() {
		
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
	
	public void trainingMode(Skill skill, int addedXp) {

		Skill hp = player.getHitPointsSkill();
		player.trainSkill(skill, addedXp);
		player.trainSkill(hp, addedXp);
	}
	
	public void battleMode(Player other) {
		
		// implemented later
		
	}
	
}
