
public abstract class Player extends Combatant {
	public Player(int maxHp, int baseAttack, int baseDefense, int baseSpeed, int specialSkillCooldown, String name, String simpleName) {
		super(maxHp, baseAttack, baseDefense, baseSpeed, name, simpleName, specialSkillCooldown, 0);
	}
	public abstract void performAction(BattleContext bc);
}
