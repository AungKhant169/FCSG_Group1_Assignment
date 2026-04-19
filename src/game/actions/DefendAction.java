package game.actions;
import game.effects.DefendEffect;
import game.effects.StatusEffect;
import game.entities.Combatant;
import game.ui.UI;

public class DefendAction implements Action{
	
	public void execute(Combatant c, UI ui) {
		StatusEffect def = new DefendEffect(10);
		c.addStatusEffect(def);
		String display = "🛡️ ⬆️ : " + c.getBaseDefense() + " → " + c.getTotalDef();
		ui.displayActionResult("improves 🛡️ ", c, null, null, display);
	}
}
