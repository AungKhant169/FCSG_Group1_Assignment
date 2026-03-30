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
	private ArrayList<StatusEffect> statusEffects;
	private ArrayList<Item> items;

	public Combatant(int maxHp, int baseAttack, int baseDefense, int baseSpeed, String name, int specialSkillCooldown,
			int currentCooldown) {
		super();
		this.maxHp = maxHp;
		this.currentHp = maxHp;
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		this.baseSpeed = baseSpeed;
		this.name = name;
		this.specialSkillCooldown = specialSkillCooldown;
		this.currentCooldown = currentCooldown;
		this.statusEffects = new ArrayList<>();
		this.items = new ArrayList<>();
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

	public int getBaseDefense() {
		return baseDefense;
	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public ArrayList<StatusEffect> getStatusEffects() {
		return statusEffects;
	}

	public void takeDamage(int damage) {
		int damagedHp = currentHp - damage;
		// currentHp after taking damage won't go below 0
		// dont take damage if combatant has smokeBombInvulnerability
		currentHp = (damagedHp <= 0) ? 0 : damagedHp;
	}

	public void increaseHP(int healAmount) {
		int healedHp = currentHp + healAmount;
		// heal only up to maxHp and not more
		currentHp = (healedHp >= maxHp) ? maxHp : healedHp;
	}

	public boolean isAlive() {
		return (currentHp > 0);
	}

	public void addStatusEffect(StatusEffect status) {
		statusEffects.add(status);
	}

	public void reduceEffectDurations() {
		int i = 0;
		int size = statusEffects.size();
		// using fixed size as we are not removing/adding to ArrayList
		while (i < size) {
			statusEffects.get(i).tick();
			i++;
		}
	}

	public void removeExpiredEffects() {
		int i = 0;
		while (i < statusEffects.size()) {
			if (statusEffects.get(i).isExpired()) {
				statusEffects.remove(i);
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

	public int getAddOnDefense() {
		return addOnDefense;
	}
	
	public void setAddOnDefense(int value) {
		this.addOnDefense = value;
	}

	public int getAddOnAttack() {
		return addOnAttack;
	}

	public void setAddOnAttack(int value) {
		this.addOnAttack = value;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public boolean isSkillReady() {
		return (currentCooldown == 0);
	}
	
	public boolean hasItems() {
		return (items.size() > 0);
	}
}
