package game.effects;

import game.entities.Combatant;
import game.ui.UI;

public class PoisonEffect extends Debuff {
	public PoisonEffect() {
		super("Poison", 3);
	}

	public void inflectDamage(Combatant c, UI ui) {
//		String statusDamageMessage = c.getName() + " takes poison damage -> HP: " + c.getCurrentHp() + " -> ";
		String statusDamageMessage = "HP: From " + c.getCurrentHp() + " -> To ";
		c.takeDamage(10);
		statusDamageMessage = statusDamageMessage + c.getCurrentHp()+" ";
//		ui.displayActionResult(statusDamageMessage);
        ui.displayActionResult("takes poison damage", c, null, "", statusDamageMessage);
	}
}
