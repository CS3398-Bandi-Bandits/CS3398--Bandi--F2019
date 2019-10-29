/**
 * 	@author Devon Tyson
 */

package driver;

public class Hitpoints extends Skill {
	
	private int level, xp, goalXp;

	public Hitpoints() {
		super.level = 10;
		this.xp = super.xp;
		this.goalXp = super.goalXp;
	}
	
	@Override
	public void train(int addedXp) {
		addedXp /= 4; // hp levels slower than other skills
		super.train(addedXp);
	}
	
	@Override
	public String toString() {
		return "Hitpoints";
	}
}
