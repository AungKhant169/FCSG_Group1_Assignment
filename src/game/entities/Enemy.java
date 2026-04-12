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
		// Determine target: player if alive, otherwise any living ally
		Combatant target;
		if (bc.getPlayer().isAlive()) {
			target = bc.getPlayer();
		} else {
			// Find a living ally to attack
			target = bc.getAllies().stream()
				.filter(Combatant::isAlive)
				.findFirst()
				.orElse(null);
		}
		
		if (target == null) return; // No valid target
		
		// equal chances for num 0-9
		// if number == 0, with probability of 10% enemy poison player
		if (randNum != 0) {
			new BasicAttack().execute(this, bc.getPlayer(), bc.getUI());
		} else {
	    	bc.getUI().displayActionResult("Poison -> " + bc.getPlayer().getName(), this, null, "", "");
	    	bc.getPlayer().addStatusEffect(new PoisonEffect());
		}
	}
	
}
