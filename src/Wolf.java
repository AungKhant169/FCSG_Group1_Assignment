
public class Wolf extends Enemy {

	public Wolf(String name) {
		super(40, 45, 5, 35, name, "Wolf");
	}
	
	public void performAction(BattleContext bc) {
		new BasicAttack().execute(this, bc.getPlayer(), bc.getUI());
	}
}
