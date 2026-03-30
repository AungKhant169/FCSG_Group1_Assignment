
public class Enemy extends Combatant {

	public Enemy(int maxHp, int baseAttack, int baseDefense, int baseSpeed, String name) {
		// dummy value for specialSkillCooldown and currentCooldown
		super(maxHp, baseAttack, baseDefense, baseSpeed, name, -1, -1);
	}

}
