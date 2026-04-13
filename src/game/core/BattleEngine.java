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
	private BattleContext bc;

	public BattleEngine(UI ui) {
		this.ui = ui;
		this.to = new TurnOrder(ui);
		this.roundCount = 0;
		this.isLevelWon = false;
	}

	public void run(Combatant player, Level level) {
		List<Enemy> enemies = level.getInitialWave();
		this.bc = new BattleContext(player, enemies, ui);

		List<Combatant> orderedCombatant = getAllOrderedCombatants();
		to.displayOrder(new ArrayList<Combatant>(orderedCombatant));

		while ((player.isAlive() || bc.hasLivingAllies()) && level.hasLivingEnemiesInitialW()) {
			roundCount++;
			ui.displayRoundStart(roundCount);
			this.bc.setEnemies(level.getLivingEnemiesInitialW());
			this.runRound();
		}
		if (level.hasLivingEnemiesBackupW()) {
			ui.printLine("BACK UP WAVE SPAWNED!");
			enemies = level.getBackupWave();
			bc.setEnemies(enemies);
			orderedCombatant = getAllOrderedCombatants();
			to.displayOrder(new ArrayList<Combatant>(orderedCombatant));
			while ((player.isAlive() || bc.hasLivingAllies()) && !level.hasLivingEnemiesInitialW()
					&& level.hasLivingEnemiesBackupW()) {
				roundCount++;
				ui.displayRoundStart(roundCount);
				this.bc.setEnemies(level.getLivingEnemiesBackupW());
				this.runRound();
			}
		}
		this.isLevelWon = player.isAlive() || this.bc.hasLivingAllies();
	}

	private void runRound() {

		List<Combatant> orderedCombatant = getAllOrderedCombatants();
		for (Combatant c : orderedCombatant) {
			executeTurn(c);
		}
		for (Combatant c : orderedCombatant) {
			c.reduceEffectDurations();
			c.removeExpiredEffects();
			c.reduceSpecialSkillCooldown();
		}

		this.bc.getAllies().removeIf(ally -> !ally.isAlive());

		ui.displayRoundSummary(orderedCombatant);
	}

	private void executeTurn(Combatant c) {
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
			c.performAction(this.bc);
		} else {
			ui.displayStunned(c.getName());
		}
	}

	private ArrayList<Combatant> getAllOrderedCombatants() {

		ArrayList<Combatant> allCombatants = new ArrayList<>(this.bc.getEnemies());
		allCombatants.add(this.bc.getPlayer());
		allCombatants.addAll(this.bc.getAllies());
		return to.getTurnsBasedOnSpeed(allCombatants);

	}

	public int getTotalRound() {
		return roundCount;
	}

	public boolean getIsLevelWon() {
		return isLevelWon;
	}

}
