
public class UseItem implements Action{
	public void execute(Combatant c, BattleContext bc) {
		int itemIndex = bc.getUI().getUseItem(c);
		String display = c.getName() + " -> used " + c.getItems().get(itemIndex).getName();
		bc.getUI().displayActionResult(display);
		c.getItems().get(itemIndex).use(c, bc);
		c.getItems().get(itemIndex).reduceUseCount();;
	}
}
