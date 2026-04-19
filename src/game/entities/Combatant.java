package game.entities;
import java.util.*;

import game.core.BattleContext;
import game.effects.StatusEffect;
import game.items.Item;

public abstract class Combatant {
	private int maxHp;
	private int currentHp;
	private int baseAttack;
	private int baseDefense;
	private int baseSpeed;
	private String name;
	private int specialSkillCooldown;
	private int currentCooldown;
	private ArrayList<StatusEffect> statusEffects;
	private ArrayList<Item> items;
	private String simpleName;

	public Combatant(int maxHp, int baseAttack, int baseDefense, int baseSpeed, String name, String simpleName, int specialSkillCooldown,
			int currentCooldown) {
		this.maxHp = maxHp;
		this.currentHp = maxHp;
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		this.baseSpeed = baseSpeed;
		this.name = name;
		this.simpleName = simpleName;
		this.specialSkillCooldown = specialSkillCooldown;
		this.currentCooldown = currentCooldown;
		this.statusEffects = new ArrayList<>();
		this.items = new ArrayList<>();
	}
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

	public void setCurrentCooldown(int specialSkillCooldown) {
		currentCooldown = specialSkillCooldown;
	}

	public void addItem(Item item) {
		items.add(item);
	}

	public boolean isSkillReady() {
		return (currentCooldown == 0);
	}

	public boolean hasItems() {
		int usableItemCount = 0;
		for (Item i: this.items) {
			if (i.isUsable()) usableItemCount++;
		}
		return usableItemCount > 0;
	}
	public abstract void performAction(BattleContext bc);
	
	public String getSimpleName() {
		return simpleName;
	}
	public int getTotalAttack() {
		int totalAtk = baseAttack;
		for (StatusEffect e: statusEffects) {
			totalAtk += e.modifyAttack();
		}
		
		return totalAtk;
	}
	public int getTotalDef() {
		int totalDef = baseDefense;
		for (StatusEffect e: statusEffects) {
			totalDef += e.modifyDefense();
		}
		
		return totalDef;
	}
	public List<Item> getItems() {
		return items;
	}
	
	public abstract void specialSkill(BattleContext bc, boolean cdReset);

	public abstract String getEntityEmoji();
	
	public void reduceSpecialSkillCooldown() { 
		this.currentCooldown = (this.currentCooldown > 0) ? this.currentCooldown - 1: 0;
	}
	
	public void resetCombatant() {
		this.currentHp = this.maxHp;
		this.currentCooldown = 0;
		this.statusEffects = new ArrayList<>();
		for(int i = 0; i < this.items.size(); i++) {
			this.items.get(i).resetUseCount();
		}
	}
}
