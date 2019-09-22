
public abstract class Skill implements ITrainable {
	
	private static final int MAX_LEVEL = 99;
	protected int level;
	protected int xp;
	protected int goalXp;
	
	public Skill() {
		this.level = 1;
		this.xp = 0;
		this.goalXp = 5000;
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
	
	public void checkXp() {
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
