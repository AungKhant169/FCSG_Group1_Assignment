
public abstract class Enemy extends Combatant {

	public Enemy(int maxHp, int baseAttack, int baseDefense, int baseSpeed, String name, String simpleName) {
		super(maxHp, baseAttack, baseDefense, baseSpeed, name, simpleName, 0, 0);
	}
	
	public void performAction(BattleContext bc) {
		new BasicAttack().execute(this, bc.getPlayer(), bc.getUI());
	}
	
}
