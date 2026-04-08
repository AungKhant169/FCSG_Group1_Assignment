package game.core;
import java.util.List;

import game.entities.Combatant;
import game.entities.Enemy;
import game.ui.UI;

public class BattleContext {
	private Combatant player;
    private List<Enemy> enemies;
    private UI ui;
    
	public BattleContext(Combatant player, List<Enemy> enemies, UI ui) {
		super();
		this.player = player;
		this.enemies = enemies;
		this.ui = ui;
	}
	public Combatant getPlayer() {
		return player;
	}
	public List<Enemy> getEnemies() {
		return enemies;
	}
	public UI getUI() {
		return ui;
	}
    
}
