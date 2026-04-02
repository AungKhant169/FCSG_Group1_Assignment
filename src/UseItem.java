
public class UseItem implements Action{
	public void execute(Combatant c, UI ui) {
		int itemToUse = ui.getUseItem(c);
		int itemIndex = itemToUse - 1;
		c.getItems().get(itemIndex).use(c);
		String display = c.getName() + " -> used " + c.getItems().get(itemIndex).getName();
		ui.displayActionResult(display);
		c.getItems().remove(itemIndex);
	}
}
