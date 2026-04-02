
public class Warrior extends Player {

	public Warrior() {
		super(260, 40, 20, 30, 3, "Warrior", "Warrior");
	}
	
	public String getName() {
		return "Warrior";
	}
	public void performAction(BattleContext bc) {
		bc.getUI().displayActionMenu(this);
		int action = bc.getUI().getPlayerAction(this);
		bc.getUI().displaySelectedAction(action);
		if (action == 1) {
			new BasicAttack().execute(this, bc.getEnemies().get(0), bc.getUI());
		} else if (action == 2) {
			new DefendAction().execute(this, bc.getUI());
		} else if (action == 3) {
			new UseItem().execute(this, bc.getUI());
		} else { // action == 4, assuming only 1-4 is passed from getPlayerAction()
			new ShieldBashSkill().execute(this, bc.getEnemies().get(0), bc.getUI());
		}
	}
}
