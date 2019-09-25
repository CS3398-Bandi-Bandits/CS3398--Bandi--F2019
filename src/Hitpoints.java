/**
 * 	@author Devon Tyson
 */


public class Hitpoints extends Skill {
	
	int level, xp, goalXp;

	public Hitpoints() {
		super.level = 10;
		this.xp = super.xp;
		this.goalXp = super.goalXp;	
	}
	
	
	@Override
	public void train(int addedXp) {
		super.xp += (addedXp/5); // hp levels slower than other skills
		checkXp();
	}
}
