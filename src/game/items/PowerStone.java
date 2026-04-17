// use the special skill with no cooldown 
package game.items;

import game.core.BattleContext;
import game.entities.Combatant;

public class PowerStone extends Item {

    public PowerStone() {
        super("💎 Power Stone", "Power Stone does not affect cooldown ", 1);
    }

    @Override
    public void use(Combatant user, BattleContext bc) {
        // Cast to Player — only players have special skills
        bc.getUI().displayActionResult("uses 💎 Power Stone", user, null, null, "");
    	user.specialSkill(bc, true);
    }
}
