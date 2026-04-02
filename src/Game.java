import java.util.List;

public class Game {
//    private Player player;
//    private Level level;
//    private int roundCount;
//    private BattleEngine battleManager;
	private UI ui;

	public Game() {
		this.ui = new CommandLineUI();
	}

	public void start() {
		boolean isLevelWon;
		ui.displayWelcome();
		Combatant player = initPlayer();
		Level level = initLevel();
		BattleEngine be = new BattleEngine(ui);
		isLevelWon = be.run(player, level);
		showResult(isLevelWon);
	}

	public Combatant initPlayer() {
		int playerClass;
		Combatant player;
		playerClass = ui.selectClass();
		// assuming ui class return only the valid input
		// hence 1 for warrior and 2 for wizard,

		// update on this function is needed if more player classes are added
		ui.displaySelectedClass(playerClass);
		if (playerClass == 1) {
			player = new Warrior();
		} else {
			player = new Wizard();
		}
		initItem(player);
		return player;

	}

	public Level initLevel() {
		int selectedLevel;
		selectedLevel = ui.selectLevel();
		// assuming ui class return only the valid input

		// similar idea with initPlayer()
		ui.displaySelectedLevel(selectedLevel);
		Level level;
		if (selectedLevel == 1) {
			level = new LevelEasy();
		} else if (selectedLevel == 2) {
			level = new LevelMedium();
		} else {
			level = new LevelHard();
		}

		return level;
	}

	public void showResult(boolean isLevelWon) {

		if (isLevelWon) {
			ui.displayVictory();
		} else {
			ui.displayDefeat();
		}
	}
	
	public void initItem(Combatant c) {
		List<Integer> items = ui.selectItems();
		ui.displaySelectedItems(items);
		for (int i: items) {
			if (i == 1) {
				c.addItem(new Potion());
			} else if (i == 2) {
				c.addItem(new SmokeBomb());
			} else if (i == 3) {
				c.addItem(new PowerStone());
			} 
		}
	}

}
