
public abstract class Enemy extends Combatant {

	public Enemy(int maxHp, int baseAttack, int baseDefense, int baseSpeed, String name, String simpleName) {
		super(maxHp, baseAttack, baseDefense, baseSpeed, name, simpleName, -1, -1);
	}

	public abstract void performAction(BattleContext bc);
}
