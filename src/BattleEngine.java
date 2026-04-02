import java.util.ArrayList;
import java.util.List;

public class BattleEngine {
	TurnOrder to;
	UI ui;
	int roundCount;

	public BattleEngine(UI ui) {
		this.ui = ui;
		this.to = new TurnOrder(ui);
		this.roundCount = 0;
	}

	public boolean run(Combatant player, Level level) {
		List<Enemy> enemies = level.getInitialWave();
		enemies.addAll(level.getBackupWave());
		List<Combatant> orderedCombatant = getAllOrderedCombatants(player, enemies);
		to.displayOrder(new ArrayList<Combatant>(orderedCombatant));
		while (player.isAlive() && level.hasLivingEnemiesInitialW()) {
			roundCount++;
			ui.displayRoundStart(roundCount);
			this.runRound(player, level.getLivingEnemiesInitialW());
		}
		while (player.isAlive() && level.hasLivingEnemiesBackupW()) {
			roundCount++;
			ui.displayRoundStart(roundCount);
			this.runRound(player, level.getLivingEnemiesBackupW());
		}
		return player.isAlive();
	}

	private void runRound(Combatant player, List<Enemy> enemies) {

		List<Combatant> orderedCombatant = getAllOrderedCombatants(player, enemies);
		BattleContext bc = new BattleContext(player, enemies, ui);
		for (Combatant c : orderedCombatant) {
			executeTurn(c,bc);
		}
		for (Combatant c: orderedCombatant) {
			c.reduceEffectDurations();
			c.removeExpiredEffects();
		}
		ui.displayRoundSummary(orderedCombatant);
		for (StatusEffect e : player.getStatusEffects()) {
			System.out.println(e.getName() + " " + e.getDuration());

		}
	}

	private void executeTurn(Combatant c, BattleContext bc) {
		if (!c.isAlive())
			return;
		boolean turnSkip = false;
		for (StatusEffect effect : c.getStatusEffects()) {
			if (effect.stopTurn()) {
				turnSkip = true;
				break;
			}
		}
		if (!turnSkip) {
			c.performAction(bc);
		} else {
			ui.displayStunned(c.getName());
		}
	}

	private ArrayList<Combatant> getAllOrderedCombatants(Combatant player, List<Enemy> enemies) {

		ArrayList<Combatant> allCombatants = new ArrayList<>(enemies);
		allCombatants.add(player);
		return to.getTurnsBasedOnSpeed(allCombatants);

	}

}
