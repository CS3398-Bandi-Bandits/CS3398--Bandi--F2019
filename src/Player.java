import java.io.Serializable;

/**
 * 	@author Devon Tyson
 */

public class Player implements IFightable, Serializable {
	
	private Skill strength, defence, hp;
	private int combatLevel;
	private String username;
	
	// constructor for new players
	public Player(String name) {
		this.username = name;
		this.strength = new Strength();
		this.defence = new Defence();
		this.hp = new Hitpoints();
		this.combatLevel = 1;
	}
	
	// constructor for existing players
	public Player(String name, Skill str, Skill def, Skill hp) {
		this.username = name;
		this.strength = str;
		this.defence = def;
		this.hp = hp;
		calculateCombatLevel();
	}
	
	private void calculateCombatLevel() {
		int cb = (this.strength.getLevel()/3) + (this.hp.getLevel()/5) - 1;
		if(!(cb < 1)) {
			this.combatLevel = cb;
		}
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public int getCombatLevel() {
		calculateCombatLevel();
		return this.combatLevel;
	}
	
	public Skill getStrengthSkill() {
		return this.strength;
	}
	
	public Skill getDefenceSkill() {
		return this.defence;
	}
	
	public Skill getHitPointsSkill() {
		return this.hp;
	}
	
	public void trainSkill(Skill skill, int addedXp) {
		skill.train(addedXp);
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
	}
}
