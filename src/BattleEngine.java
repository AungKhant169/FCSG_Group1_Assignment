import java.util.ArrayList;

public class BattleEngine {
	TurnOrder to;
	UI ui;
    public BattleEngine(UI ui) {
    	this.ui = ui;
        to = new TurnOrder(ui);
    }
    
    public boolean run(Combatant player, Level level) {
    	return true;
    }
    
    public void runRound(Combatant player, ArrayList<Combatant> enemies) {
    	
    }
    
    public void executeTurn(Combatant c) {
    	
    }

}
