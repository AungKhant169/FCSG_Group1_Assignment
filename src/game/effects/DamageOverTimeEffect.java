package game.effects;

import game.entities.Combatant;
import game.ui.UI;

public class DamageOverTimeEffect extends Debuff {
	private int DOTdamage;
	public DamageOverTimeEffect(String Name, int cooldown, int DOTdamage) {
		super(Name, cooldown);
		this.DOTdamage = DOTdamage;
	}

	public void inflectDamage(Combatant c, UI ui) {
//		String statusDamageMessage = c.getName() + " takes poison damage -> HP: " + c.getCurrentHp() + " -> ";
		String statusDamageMessage = "HP: From " + c.getCurrentHp() + " -> To ";
		c.takeDamage(this.DOTdamage);
		statusDamageMessage = statusDamageMessage + c.getCurrentHp()+" ";
//		ui.displayActionResult(statusDamageMessage);
        ui.displayActionResult("takes "+this.getName()+" damage", c, null, "", statusDamageMessage);
	}
}
