package game.core;
import java.util.ArrayList;
import java.util.List;

import game.entities.Combatant;
import game.entities.Warrior;
import game.entities.Wizard;
import game.entities.Necromancer;
import game.items.PoisonDart;
import game.items.Potion;
import game.items.PowerStone;
import game.items.SmokeBomb;
import game.levels.Level;
import game.levels.LevelCustom;
import game.levels.LevelEasy;
import game.levels.LevelHard;
import game.levels.LevelMedium;
import game.ui.CommandLineUI;
import game.ui.UI;

public class Game {
	private Combatant player;
	private Level level;
	private BattleEngine battleManager;
	private UI ui;

	public Game() {
		this.ui = new CommandLineUI();
		ui.displayWelcome();
	}

	public void start() {
		initPlayer();
		initLevel();
		this.battleManager = new BattleEngine(ui);
		battleManager.run(player, level);
		showResult();
//        playAgain = ui.askPlayAgain(); // now works
	}

	public void initPlayer() {
		int playerClass;
		playerClass = ui.selectClass();
		// assuming ui class return only the valid input
		// hence 1 for warrior and 2 for wizard,

		// update on this function is needed if more player classes are added
		ui.displaySelectedClass(playerClass);
		switch (playerClass) {
			case 1:	
				this.player = new Warrior();
				break;
			case 2: 
				this.player = new Wizard();
				break;
			case 3:
				this.player = new Necromancer();
				break;
		}
		initItem();

	}

	public void initLevel() {
		int selectedLevel;
		selectedLevel = ui.selectLevel();
		// assuming ui class return only the valid input

		// similar idea with initPlayer()
		ui.displaySelectedLevel(selectedLevel);
		if (selectedLevel == 1) {
			this.level = new LevelEasy();
		} else if (selectedLevel == 2) {
			this.level = new LevelMedium();
		} else if (selectedLevel == 3) {
			this.level = new LevelHard();
		} else {
			this.level = new LevelCustom(ui);
		}

	}

	public void showResult() {
		List<Combatant> resultList = new ArrayList<Combatant>();
		if (this.battleManager.getIsLevelWon()) {
			ui.displayVictory();
			resultList.add(player);
		} else {
			ui.displayDefeat();
			if (this.level.hasLivingEnemiesInitialW()) {
				resultList.addAll(this.level.getLivingEnemiesInitialW());
			}
			if (this.level.hasLivingEnemiesBackupW()) {
				resultList.addAll(this.level.getLivingEnemiesBackupW());
			}
		}
		ui.displayLevelSummary(resultList, this.battleManager.getTotalRound());
		manageEndGame();
	}

	public void initItem() {
		List<Integer> items = ui.selectItems();
		ui.displaySelectedItems(items);
		for (int i : items) {
			if (i == 1) {
				this.player.addItem(new Potion());
			} else if (i == 2) {
				this.player.addItem(new SmokeBomb());
			} else if (i == 3) {
				this.player.addItem(new PowerStone());
			} else if (i == 4) {
				this.player.addItem(new PoisonDart());
			}
		}
	}

	public void manageEndGame() {
		String choice;
		if (this.battleManager.getIsLevelWon()) {
			choice = ui.askToContinue();
		} else {
			choice = ui.askToTryAgain();
		}
		if (choice.equals("start again")) {
			this.start();
		} else if (choice.equals("play same")) {
			this.player.resetCombatant();
			this.level.resetLevel();
			this.battleManager = new BattleEngine(ui);
			battleManager.run(player, level);
			showResult();
		} else if (choice.equals("exit")) {
			ui.displayEndGame();
			return;
		}
	}

}
