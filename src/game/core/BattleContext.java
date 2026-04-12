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
		int index_lowest_hp = 0;
		for (int i = 1; i < enemies.size(); i++) {
			if (enemies.get(i).getCurrentHp() < enemies.get(index_lowest_hp).getCurrentHp()){
				index_lowest_hp = i;
			}
		}
		return enemies.get(index_lowest_hp);
	}

	public boolean hasLivingAllies() {
		return getAllies().stream().anyMatch(Combatant::isAlive);
	}
    
}
