
public class Wizard extends Player {

	public Wizard() {
		super(200, 50, 10, 20, 3, "Wizard", "Wizard");
	}

	public String getName() {
		return "Wizard";
	}
	
	public void specialSkill(BattleContext bc, boolean cdReset) {
		new ArcaneBlastSkill().execute(this, bc.getEnemies(), bc.getUI());
		if (!cdReset) {
			this.setCurrentCooldown(this.getSpecialSkillCooldown());
		}
	}
}
