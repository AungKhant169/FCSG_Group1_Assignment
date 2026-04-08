package game.entities;
import game.actions.BasicAttack;
import game.actions.SingleTargetAction;
import game.actions.DefendAction;
import game.actions.UseItem;
import game.core.BattleContext;

public abstract class Player extends Combatant {
	public Player(int maxHp, int baseAttack, int baseDefense, int baseSpeed, int specialSkillCooldown, String name, String simpleName) {
		super(maxHp, baseAttack, baseDefense, baseSpeed, name, simpleName, specialSkillCooldown, 0);
	}
	public void performAction(BattleContext bc) {
		bc.getUI().displayActionMenu(this);
		int action = bc.getUI().getPlayerAction(this);
		bc.getUI().displaySelectedAction(action);
		if (action == 1) {
			SingleTargetAction ba = new BasicAttack();
			Combatant target = ba.pickTarget(bc);
			ba.execute(this, target, bc.getUI());
		} else if (action == 2) {
			new DefendAction().execute(this, bc.getUI());
		} else if (action == 3) {
			new UseItem().execute(this,bc);
		} else { // action == 4, assuming only 1-4 is passed from getPlayerAction()
			this.specialSkill(bc, false);
		}
	}
}
