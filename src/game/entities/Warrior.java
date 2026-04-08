package game.entities;
import game.actions.ShieldBashSkill;
import game.actions.SingleTargetAction;
import game.core.BattleContext;

public class Warrior extends Player {

	public Warrior() {
		super(260, 40, 20, 30, 3, "Warrior", "Warrior");
	}
	
	public String getName() {
		return "Warrior";
	}

	public void specialSkill(BattleContext bc, boolean cdReset) {
		SingleTargetAction sb = new ShieldBashSkill();
		Combatant target = sb.pickTarget(bc);
		sb.execute(this, target, bc.getUI());
		if (!cdReset) {
			this.setCurrentCooldown(this.getSpecialSkillCooldown());
		}
	}
}
