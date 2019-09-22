
public class Player implements IFightable {
	
	private Skill strength, hp;
	private int combatLevel;
	
	public Player() {
		this.strength = new Strength();
		this.hp = new Hitpoints();
		this.combatLevel = 1;
	}
	
	private void calculateCombatLevel() {
		int cb = (this.strength.getLevel()/3) + (this.hp.getLevel()/5) - 1;
		if(!(cb < 1)) {
			this.combatLevel = cb;
		}
	}
	
	public int getCombatLevel() {
		calculateCombatLevel();
		return this.combatLevel;
	}
	
	public Skill getStrengthSkill() {
		return this.strength;
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
