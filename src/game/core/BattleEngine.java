package game.core;
import java.util.ArrayList;
import java.util.List;

import game.effects.StatusEffect;
import game.entities.Combatant;
import game.entities.Enemy;
import game.levels.Level;
import game.ui.UI;

public class BattleEngine {
	private TurnOrder to;
	private UI ui;
	private int roundCount;
	private boolean isLevelWon;

	public BattleEngine(UI ui) {
		this.ui = ui;
		this.to = new TurnOrder(ui);
		this.roundCount = 0;
		this.isLevelWon = false;
	}

	public void run(Combatant player, Level level) {
		List<Enemy> enemies = level.getInitialWave();
		BattleContext bc = new BattleContext(player, enemies, ui);

		List<Combatant> orderedCombatant = getAllOrderedCombatants(player, enemies, bc);
		to.displayOrder(new ArrayList<Combatant>(orderedCombatant));

		while ((player.isAlive() || bc.hasLivingAllies()) && level.hasLivingEnemiesInitialW()) {
			roundCount++;
			ui.displayRoundStart(roundCount);
			this.runRound(player, level.getLivingEnemiesInitialW(), bc);
		}
		if (level.hasLivingEnemiesBackupW()) {
			ui.printLine("BACK UP WAVE SPAWNED!");
			enemies = level.getBackupWave();
			bc.setEnemies(enemies);
			orderedCombatant = getAllOrderedCombatants(player, enemies, bc);
			to.displayOrder(new ArrayList<Combatant>(orderedCombatant));
			while ((player.isAlive() || bc.hasLivingAllies()) && !level.hasLivingEnemiesInitialW() && level.hasLivingEnemiesBackupW()) {
				roundCount++;
				ui.displayRoundStart(roundCount);
				this.runRound(player, level.getLivingEnemiesBackupW(), bc);
			}
		}
		this.isLevelWon = player.isAlive() || bc.hasLivingAllies();
	}

	private void runRound(Combatant player, List<Enemy> enemies, BattleContext bc) {

		List<Combatant> orderedCombatant = getAllOrderedCombatants(player, enemies, bc);
		for (Combatant c : orderedCombatant) {
			executeTurn(c,bc);
		}
		for (Combatant c: orderedCombatant) {
			c.reduceEffectDurations();
			c.removeExpiredEffects();
			c.reduceSpecialSkillCooldown();
		}

		bc.getAllies().removeIf(ally -> !ally.isAlive());

		ui.displayRoundSummary(orderedCombatant);
	}

	private void executeTurn(Combatant c, BattleContext bc) {
		if (!c.isAlive())
			return;
		boolean turnSkip = false;
		for (StatusEffect effect : c.getStatusEffects()) {
			effect.inflectDamage(c, ui);
			if (!c.isAlive()) {
				return;
			}
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

	private ArrayList<Combatant> getAllOrderedCombatants(Combatant player, List<Enemy> enemies, BattleContext bc) {

		ArrayList<Combatant> allCombatants = new ArrayList<>(enemies);
		allCombatants.add(player);
		allCombatants.addAll(bc.getAllies());
		return to.getTurnsBasedOnSpeed(allCombatants);

	}
	
	public int getTotalRound() {
		return roundCount;
	}
	
	public boolean getIsLevelWon() {
		return isLevelWon;
	}

}
