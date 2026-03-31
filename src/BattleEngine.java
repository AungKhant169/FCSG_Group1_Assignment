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
    	while (player.isAlive() && level.hasLivingEnemiesInitialW()) {
    		roundCount++;
    		ui.printLine("Round " + roundCount);
    		this.runRound(player, level.getInitialWave());
    		break; // dummy break as no action to kill combatant yet
    	}
    	while (player.isAlive() && level.hasLivingEnemiesBackupW()) {
    		roundCount++;
    		ui.printLine("Round " + roundCount);
    		this.runRound(player, level.getBackupWave());
    		break; // dummy break as no action to kill combatant yet
    	}
    	return player.isAlive();
    }
    
    private void runRound(Combatant player, List<Enemy> enemies) {
    	
    	ArrayList<Combatant> allCombatants = new ArrayList<>(enemies);
    	allCombatants.add(player);
    	List<Combatant> orderedCombatant = to.getTurnsBasedOnSpeed(allCombatants);
    	for (Combatant c: orderedCombatant) {
    		this.executeTurn(c);
    	}
    }
    
    private void executeTurn(Combatant c) {
    	if (!c.isAlive()) return;
    	
    }

}
