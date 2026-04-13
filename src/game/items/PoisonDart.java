package game.items;

import game.actions.SingleTargetAction;
import game.core.BattleContext;
import game.effects.DamageOverTimeEffect;
import game.entities.Combatant;

public class PoisonDart extends Item{

	public PoisonDart() {
		super("Poison Dart", "Poisons selected target for 3 turns", 1);
	}
	
    @Override
    public void use(Combatant user, BattleContext bc) {
    	SingleTargetAction sta = new SingleTargetAction();
    	Combatant target = sta.pickTarget(bc);
    	bc.getUI().displayActionResult("Poison Dart -> " + target.getName(), user, null, "", "");
    	target.addStatusEffect(new DamageOverTimeEffect("Poison", 3, 10));
    }
}
