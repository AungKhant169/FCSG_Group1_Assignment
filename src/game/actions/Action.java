package game.actions;
import java.util.List;

import game.core.BattleContext;
import game.entities.Combatant;
import game.entities.Enemy;
import game.ui.UI;

public interface Action {

	// for single target action
    default void execute(Combatant attacker, Combatant target, UI ui) {
        throw new UnsupportedOperationException("Single-target execution is not supported by this action.");
    }

    // for multi-target action
    default void execute(Combatant attacker, List<Enemy> enemyList, UI ui) {
        throw new UnsupportedOperationException("Multi-target execution is not supported by this action.");
    }
    
    // for action that has no target
    default void execute(Combatant c, UI ui) {
        throw new UnsupportedOperationException("Target execution is not supported by this action.");
    }
    
    // for using item
    default void execute(Combatant c, BattleContext bc) {}

    // for action that adds allies to the battle context
    default void execute(Combatant attacker, Combatant target, BattleContext bc) {}
}
