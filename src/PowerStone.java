// use the special skill with no cooldown 
public class PowerStone extends Item {

    public PowerStone() {
        super("💎 Power Stone", "Power Stone does not affect cooldown) ", 1);
    }

    @Override
    public void use(Combatant user, BattleContext bc) {
        // Cast to Player — only players have special skills
    	user.specialSkill(bc, true);
    }
}
