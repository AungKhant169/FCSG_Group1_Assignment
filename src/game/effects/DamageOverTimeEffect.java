package game.effects;

import game.entities.Combatant;
import game.ui.UI;

public class DamageOverTimeEffect extends Debuff {
	private int dotDamage;
	public DamageOverTimeEffect(String name, int duration, int dotDamage) {
		super(name, duration);
		this.dotDamage = dotDamage;
	}

	public void inflectDamage(Combatant c, UI ui) {
//		String statusDamageMessage = c.getName() + " takes poison damage -> HP: " + c.getCurrentHp() + " -> ";
		String statusDamageMessage = "HP: From " + c.getCurrentHp() + " -> To ";
		c.takeDamage(this.dotDamage);
		statusDamageMessage = statusDamageMessage + c.getCurrentHp()+" ";
//		ui.displayActionResult(statusDamageMessage);
        ui.displayActionResult("takes "+this.getName()+" damage", c, null, "", statusDamageMessage);
	}
}
