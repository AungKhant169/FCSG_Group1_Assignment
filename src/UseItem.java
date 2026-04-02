
public class UseItem implements Action{
	public void execute(Combatant c, UI ui) {
		int itemToUse = ui.getUseItem();
		int itemIndex = itemToUse - 1;
		c.getItems().get(itemIndex).use(c);
	}
}
