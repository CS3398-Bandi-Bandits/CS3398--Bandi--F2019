package driver;

/**
 * 	@author Devon Tyson
 */

public class Speed extends Skill {

    int level, xp, goalXp;

    public Speed() {
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
        return "Speed";
    }
}
