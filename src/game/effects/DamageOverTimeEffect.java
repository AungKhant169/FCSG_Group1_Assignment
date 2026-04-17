package game.effects;

import game.entities.Combatant;
import game.ui.UI;

public abstract class DamageOverTimeEffect extends Debuff {
	private int dotDamage;
	public DamageOverTimeEffect(String name, int duration, int dotDamage) {
		super(name, duration);
		this.dotDamage = dotDamage;
	}

	public void inflictDamage(Combatant c, UI ui) {
		String statusDamageMessage = "HP⬇️: " + c.getCurrentHp() + " → ";
		c.takeDamage(this.dotDamage);
		statusDamageMessage = statusDamageMessage + c.getCurrentHp();
        ui.displayActionResult("takes " + this.getEffectEmoji() , c, null, this.dotDamage , statusDamageMessage);
	}
	
	public int getDotDamage() {
		return this.dotDamage;
	}
	public abstract String getEffectEmoji();
}
