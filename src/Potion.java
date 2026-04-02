public class Potion extends Item {

    private static final int HEAL_AMOUNT = 100;

    public Potion() {
        super("🧪 Potion", "Restores 100 HP, up to max HP.");
    }

    @Override
    public void use(Combatant user, BattleContext bc) {
        user.increaseHP(HEAL_AMOUNT);
        // increaseHP in Combatant should already ensure limit is not exceeded with the min(currentHP + heal, maxHP)
        
        // ** item shouldn't do print, it should be handled by UI
        // System.out.println(user.getName() + " used a Potion! HP restored by " + HEAL_AMOUNT + ".");
    }
}