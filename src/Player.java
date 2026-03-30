
public class Player extends Combatant {
	public Player(int maxHp, int baseAttack, int baseDefense, int baseSpeed, int specialSkillCooldown, String name) {
		super(maxHp, baseAttack, baseDefense, baseSpeed, name, specialSkillCooldown, 0);
	}

}
