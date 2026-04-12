package game.core;
import java.util.List;
import java.util.ArrayList;

import game.entities.Combatant;
import game.entities.Enemy;
import game.ui.UI;

public class BattleContext {
	private Combatant player;
	private List<Combatant> allies = new ArrayList<>();
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

	public void setEnemies(List<Enemy> enemies) {
		this.enemies = enemies;
	}

	public void addAlly(Combatant ally){
		allies.add(ally);
	}

	public void removeAlly(Combatant ally){
		allies.remove(ally);
	}

	public List<Combatant> getAllies(){
		return allies;
	}

	public Combatant getLowestHPEnemy(){
		Combatant lowest = null;
		for (Enemy enemy : enemies) {
			if (enemy.isAlive()) {
				if (lowest == null || enemy.getCurrentHp() < lowest.getCurrentHp()) {
					lowest = enemy;
				}
			}
		}
		return lowest;
	}

	public boolean hasLivingAllies() {
		return getAllies().stream().anyMatch(Combatant::isAlive);
	}
    
}
