package game.entities;
import java.util.Random;

import game.actions.BasicAttack;
import game.core.BattleContext;
import game.effects.PoisonEffect;

public abstract class Enemy extends Combatant {

	public Enemy(int maxHp, int baseAttack, int baseDefense, int baseSpeed, String name, String simpleName) {
		super(maxHp, baseAttack, baseDefense, baseSpeed, name, simpleName, 0, 0);
	}
	
	public void performAction(BattleContext bc) {
		int randNum = new Random().nextInt(10);
		// equal chances for num 0-9
		// if number == 0, with probability of 10% enemy poison player
		if (randNum != 0) {
			new BasicAttack().execute(this, bc.getPlayer(), bc.getUI());
		} else {
	    	String display = this.getName()+" -> Poison -> " + bc.getPlayer().getName();
	    	bc.getUI().displayActionResult(display);
	    	bc.getPlayer().addStatusEffect(new PoisonEffect());
		}
	}
	
}
