import java.util.*;
public class Combatant {
	private int maxHp;
	private int currentHp;
	private int baseAttack;
	private int addOnAttack;
	private int baseDefense;
	private int addOnDefense;
	private int baseSpeed;
	private String name;
	private int specialSkillCooldown;
	private int currentCooldown;
	private ArrayList<StatusEffect> statusEffect;
	
	public Combatant(int maxHp, int baseAttack, int baseDefense, int baseSpeed, String name, int specialSkillCooldown, int currentCooldown) {
		super();
		this.maxHp = maxHp;
		this.currentHp = maxHp;
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		this.baseSpeed = baseSpeed;
		this.statusEffect = new ArrayList<>();
		this.name = name;
		this.specialSkillCooldown = specialSkillCooldown;
		this.currentCooldown = currentCooldown;
	}

	// might need to remove some getters and setters
	public int getMaxHp() {
		return maxHp;
	}

	public int getCurrentHp() {
		return currentHp;
	}

	public void setCurrentHp(int currentHp) {
		this.currentHp = currentHp;
	}

	public int getBaseAttack() {
		return baseAttack;
	}

	public void setAddOnAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	public int getBaseDefense() {
		return baseDefense;
	}

//	public void setBaseDefense(int baseDefense) {
//		this.baseDefense = baseDefense;
//	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

//	public void setBaseSpeed(int baseSpeed) {
//		this.baseSpeed = baseSpeed;
//	}

	public ArrayList<StatusEffect> getStatusEffect() {
		return statusEffect;
	}
	
	public void takeDamage(int damage) {
		int damagedHp = currentHp - damage;
		// currentHp after taking damage won't go below 0
		currentHp = (damagedHp <= 0) ? 0 : damagedHp;
	}

	public void increaseHP(int healAmount) {
		int healedHp = currentHp + healAmount;
		// heal only up to maxHp and not more
		currentHp = (healedHp >= maxHp) ? maxHp : healedHp;
	}

	public Boolean isAlive() {
		return (currentHp > 0);
	}

	public void addStatusEffect(StatusEffect status) {
		statusEffect.add(status);
	}
	
	public void reduceEffectDurations() {
		int i = 0;
		int size = statusEffect.size();
		// using fixed size as we are not removing/adding to ArrayList
		while(i<size) {
			statusEffect.get(i).tick();
			i++;
		}
	}
	
	public void removeExpiredEffects() {
		int i = 0;
		while(i<statusEffect.size()) {
			if (statusEffect.get(i).isExpired()) {
				statusEffect.remove(i);
			} else {
				i++;
			}
		}
	}
	
	public String getName() {
		return name;
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
	// inside action class
	// keep the logic of the special attack inside action
//	if (user instanceof Warrior):
//	    target.takeDamage(user.attack * 2)
//
//	if (user instanceof Wizard):
//	    target.takeDamage(user.attack)
//	    target.addStatusEffect(new BurnEffect())
}
