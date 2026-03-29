public class Game {
    private Player player;
    private Level level;
    private int roundCount;
    private BattleManager battleManager;

    public Game() {

    }

    public void start() {
    	// ask user for player
    	// ask user for level
    	// create user
    	// create level
        battleManager = new BattleManager(player, level);
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
