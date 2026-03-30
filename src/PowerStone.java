// use the special skill with no cooldown 
public class PowerStone extends Item {

    public PowerStone() {
        super("Power Stone", "Power Stone does not affect cooldown) ");
    }

    @Override
    public void use(Combatant user) {
        // Cast to Player — only players have special skills
        if (user instanceof Player player) {
//            player.executeSpecialSkill(); // runs skill but does NOT touch cooldown
//        	SpecialSkill.execute(player, target);
            System.out.println(user.getName() );
        }
    }
}
