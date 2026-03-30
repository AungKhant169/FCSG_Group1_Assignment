public class Game {
//    private Player player;
//    private Level level;
//    private int roundCount;
//    private BattleEngine battleManager;
	private UI ui;

	public Game(UI ui) {
		this.ui = ui;
	}

	public void start() {
		ui.displayWelcome();
		Combatant player = initPlayer();
		Level level = initLevel();
		BattleEngine be = new BattleEngine(player, level);
	}

	public Combatant initPlayer() {
		int playerClass;
		Combatant player;
		playerClass = ui.selectClass();
		// assuming ui class return only the valid input
		// hence 1 for warrior and 2 for wizard,

		// update on this function is needed if more player classes are added

		if (playerClass == 1) {
			player = new Warrior();
		} else {
			player = new Wizard();
		}
		return player;

	}

	public Level initLevel() {
		int selectedLevel;
		selectedLevel = ui.selectLevel();
		// assuming ui class return only the valid input

		// similar idea with initPlayer()
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

	public void showResult() {

	}

}
