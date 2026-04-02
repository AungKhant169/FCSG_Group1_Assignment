
public class UseItem implements Action{
	public void execute(Combatant c, BattleContext bc) {
		int itemToUse = bc.getUI().getUseItem(c);
		int itemIndex = itemToUse - 1;
		String display = c.getName() + " -> used " + c.getItems().get(itemIndex).getName();
		bc.getUI().displayActionResult(display);
		c.getItems().get(itemIndex).use(c, bc);
		c.getItems().remove(itemIndex);
	}
}
