package game.entities;
import game.core.BattleContext;

public class Goblin extends Enemy {

	public Goblin(String name) {
		super(55, 35, 15, 25, name, "Goblin");
	}
	
	public void specialSkill(BattleContext bc, boolean cd) {
		
	}

	@Override
	public String getEntityEmoji() {
		return "🧌 "; 
	}
}
