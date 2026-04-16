package game.effects;

import game.entities.Combatant;
import game.ui.UI;

public class DamageOverTimeEffect extends Debuff {
	protected int dotDamage;
	public DamageOverTimeEffect(String name, int duration, int dotDamage) {
		super(name, duration);
		this.dotDamage = dotDamage;
	}

	public void inflictDamage(Combatant c, UI ui, String emoji) {
	}
}
