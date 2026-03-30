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
    	// ask user for player
    	// Player p1 = input();
    	// ask user for level
    	// Level = input();
    	// create user
    	// create level
//        battleManager = new BattleEngine(player, level);
        // get game state (win or lose of the chosen level)
    }

    public void initPlayer() {
    	
    }

    public void initLevel() {
        
    }

    // showResult or printResult should be under UI class
    // this here can be end()
    public void showResult() {

    }

}
