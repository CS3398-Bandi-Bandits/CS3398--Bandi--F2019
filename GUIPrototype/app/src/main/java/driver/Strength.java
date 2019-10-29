package driver;
/**
 * 	@author Devon Tyson
 */

public class Strength extends Skill {
	
	private int level, xp, goalXp;
	private String type;

	public Strength() {
		this.level = super.level;
		this.xp = super.xp;
		this.goalXp = super.goalXp;
	}

	@Override
	public void train(int addedXp) {
		super.train(addedXp);	
	}
	
	@Override
	public String toString() {
		return "Strength";
	}
}
