package game.actions;

import static java.lang.Math.max;

import game.effects.StatusEffect;
import game.entities.Combatant;
import game.ui.UI;

public class BasicAttack extends SingleTargetAction {

	@Override
	public void execute(Combatant attacker, Combatant target, UI ui) {
		int attackerAtk = attacker.getTotalAttack();
		int targetDef = target.getTotalDef();
		int damage = max(0, attackerAtk - targetDef);
		boolean dmgBlocked = false;

		for (StatusEffect effect : target.getStatusEffects()) {
			dmgBlocked = effect.blockInDamage();
			damage = effect.interactWithInDamage(damage);
		}

		String display = "Target HP: From " + target.getCurrentHp() + " -> To ";
		damage = max(0, damage);
		target.takeDamage(damage);
		display = display + target.getCurrentHp() + " ";
		String dmg = "Damage: " + attackerAtk + " - " + targetDef + " = " + damage;
		if (dmgBlocked) {
			display = "0 damage (Smoke Bomb active) ";
		}
		ui.displayActionResult("Basic Attack", attacker, target, dmg, display);

	}
}