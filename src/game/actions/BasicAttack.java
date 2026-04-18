package game.actions;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
		List<String> se = new ArrayList<String>();
		for (StatusEffect effect : target.getStatusEffects()) {
			dmgBlocked = effect.blockInDamage();
			if (dmgBlocked) {
				se.add(effect.getName());
			}
			damage = effect.interactWithInDamage(damage);
		}

		String display = "HP⬇️ : " + target.getCurrentHp() + " → ";
		damage = max(0, damage);
		target.takeDamage(damage);
		display = display + target.getCurrentHp() + " ";
		if (damage == 0) {
			display = "HP🔒: " + target.getCurrentHp() + " (";
			display = display + se.stream().collect(Collectors.joining(", ")) + ")";
		}
		ui.displayActionResult("🤜💥", attacker, target, damage, display);
		if (!target.isAlive()) {
			ui.displayActionResult(" ✗ ELIMINATED", target, null, 0,"");
		}
	}
}