package driver;
/**
 * 	@author Devon Tyson
 */

public class Strength extends Skill {
	
	int level, xp, goalXp;

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
