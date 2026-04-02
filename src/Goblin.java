
public class Goblin extends Enemy {

	public Goblin(String name) {
		super(55, 35, 15, 25, name, "Goblin");
	}

	public void performAction(BattleContext bc) {
		new BasicAttack().execute(this, bc.getPlayer(), bc.getUI());
	}
}
