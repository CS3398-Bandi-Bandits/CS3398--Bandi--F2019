import java.io.Serializable;

/**
 * 	@author Devon Tyson
 */

public abstract class Skill implements ITrainable, Serializable {
	
	private static final int MAX_LEVEL = 99;
	protected int level;
	protected int xp;
	protected int goalXp;

	// constructor for new players
	public Skill() {
		this.level = 1;
		this.xp = 0;
		this.goalXp = 2000;
	}
	
	// constructor for existing players
	public Skill(int level, int xp) {
		this.level = level;
		this.xp = xp;
		calculateGoalXp();
	}
	
	public int getLevel() {
		return this.level;
	}

	public int getXp() {
		return this.xp;
	}
	
	public int getGoalXp() {
		return this.goalXp;
	}
	
	private void levelUp() {
		if(this.level <= MAX_LEVEL) {
			this.level++;
			calculateGoalXp();
		}
	}
	
	protected void checkXp() {
		int totalXp = this.xp;
		while(totalXp > this.goalXp) {
			levelUp();
			totalXp -= goalXp;
		}
	}
	
	private void calculateGoalXp() {
		int addedXp = this.level*200 + 2000;
		this.goalXp = addedXp;
	}
	
	@Override
	public void train(int addedXp) {
		this.xp += addedXp;
		checkXp();
		
	}	

}
