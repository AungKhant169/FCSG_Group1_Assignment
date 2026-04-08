package game.actions;

import game.core.BattleContext;
import game.entities.Combatant;

public class SingleTargetAction implements Action{
	public Combatant pickTarget(BattleContext bc) {
		int targetIndex = bc.getUI().getTargetEnemy(bc.getEnemies());
		return bc.getEnemies().get(targetIndex);
	}
}
