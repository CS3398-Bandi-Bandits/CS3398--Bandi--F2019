/**
 * 	@author Devon Tyson
 */

public class Defence extends Skill {
	
	int level, xp, goalXp;

	public Defence() {
		this.level = super.level;
		this.xp = super.xp;
		this.goalXp = super.goalXp;	
	}

	@Override
	public void train(int addedXp) {
		super.train(addedXp);
		
	}	

}
