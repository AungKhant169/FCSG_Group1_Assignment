
public class Player extends Combatant {
	private int specialSkillCooldown;
	private int currentCooldown;
	public Player(int maxHp, int baseAttack, int baseDefense, int baseSpeed, int specialSkillCooldown) {
		super(maxHp, baseAttack, baseDefense, baseSpeed);
		this.specialSkillCooldown = specialSkillCooldown;
		this.currentCooldown = 0;
	}
	
	public int getSpecialSkillCooldown() {
		return specialSkillCooldown;
	}
	
	public int getCurrentCooldown() {
		return currentCooldown;
	}
	
	public void setCurrentCooldown() {
		currentCooldown = specialSkillCooldown;
	}
	
	public void reduceCurrentCooldown() {
		currentCooldown -= 1;
	}

}
