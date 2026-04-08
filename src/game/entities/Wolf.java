package game.entities;
import game.core.BattleContext;

public class Wolf extends Enemy {

	public Wolf(String name) {
		super(40, 45, 5, 35, name, "Wolf");
	}
	
	public void specialSkill(BattleContext bc, boolean cd) {
		
	}
}
