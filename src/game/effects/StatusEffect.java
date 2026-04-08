package game.effects;

import game.entities.Combatant;

public class StatusEffect {
	private String name;
	private int duration;

	public StatusEffect(String name, int duration) {
		super();
		this.name = name;
		this.duration = duration;
	}

	// called every turn to count down
	public void tick() {
		if (duration > 0) {
			duration--;
		}
	}

	// check if effect is done
	public boolean isExpired() {
		return duration <= 0;
	}

	public String getName() {
		return name;
	}

	public int getDuration() {
		return duration;
	}

	public int modifyAttack() {
		return 0;
	}

	public int modifyDefense() {
		return 0;
	};

	public void modifySpeed(Combatant combatant) {
	};

	public boolean stopTurn() {
		return false;
	};

	public boolean blockInDamage() {
		return false;
	}

	public int interactWithOutDamage(int damage) {
		return damage;
	};

	public int interactWithInDamage(int damage) {
		return damage;
	};
}