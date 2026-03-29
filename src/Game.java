public class Game {
    private Player player;
    private Level level;
    private int roundCount;
    private BattleManager battleManager;

    public Game() {

    }

    public void start() {
        battleManager = new BattleManager(player, level);
    }

    public void initPlayer() {

    }

    public void initLevel() {
        
    }

    public void showResult() {

    }

}
