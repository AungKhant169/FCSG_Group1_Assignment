
public class Wizard extends Player {

	public Wizard() {
		super(200, 50, 10, 20, 3, "Wizard", "Wizard");
	}

	public String getName() {
		return "Wizard";
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
			new UseItem().execute(this, bc);
		} else { // action == 4, assuming only 1-4 is passed from getPlayerAction()
			this.specialSkill(bc, false);
		}
	}
	
	public void specialSkill(BattleContext bc, boolean cdReset) {
		new ArcaneBlastSkill().execute(this, bc.getEnemies(), bc.getUI());
		if (!cdReset) {
			this.setCurrentCooldown(this.getSpecialSkillCooldown());
		}
	}
}
