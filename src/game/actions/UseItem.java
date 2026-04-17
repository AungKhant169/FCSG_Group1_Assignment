package game.actions;
import game.core.BattleContext;
import game.entities.Combatant;

public class UseItem implements Action{
	public void execute(Combatant c, BattleContext bc) {
		int itemIndex = bc.getUI().getUseItem(c);
		// String display = c.getName() + "uses" + c.getItems().get(itemIndex).getName();
 		// String display = "Used " + c.getItems().get(itemIndex).getName();
		// bc.getUI().displayActionResult(display, c, null, "", "");

		c.getItems().get(itemIndex).use(c, bc);
		c.getItems().get(itemIndex).reduceUseCount();
	}
}
