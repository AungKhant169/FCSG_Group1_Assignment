import java.util.List;

public interface Action {

    default void execute(Combatant attacker, Combatant target) {
        throw new UnsupportedOperationException("Single-target execution is not supported by this action.");
    }

    default void execute(Combatant attacker, List<Enemy> enemyList) {
        throw new UnsupportedOperationException("Multi-target execution is not supported by this action.");
    }

    default void execute(Combatant c, UI ui) {
        throw new UnsupportedOperationException("Target execution is not supported by this action.");
    }
}
