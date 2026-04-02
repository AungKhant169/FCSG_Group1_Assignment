
public class DefendAction implements Action{
	
	public void execute(Combatant c, UI ui) {
		StatusEffect def = new DefendEffect(10);
		c.addStatusEffect(def);
		String display = c.getName() + " -> Defend -> Def: " + c.getBaseDefense() + " -> " + c.getTotalDef();
		ui.displayActionResult(display);
	}
}
