import java.util.List;

public interface Action {

    default void execute(Combatant attacker, Combatant target) {
        throw new UnsupportedOperationException("Single-target execution is not supported by this action.");
    }

    default void execute(Combatant attacker, List<Enemy> enemyList) {
        throw new UnsupportedOperationException("Multi-target execution is not supported by this action.");
    }
}
