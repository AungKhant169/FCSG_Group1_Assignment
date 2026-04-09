package game.items;
import game.core.BattleContext;
import game.entities.Combatant;

public class Potion extends Item {

    private static final int HEAL_AMOUNT = 100;

    public Potion() {
        super("🧪 Potion", "Restores 100 HP, up to max HP.", 1);
    }

    @Override
    public void use(Combatant user, BattleContext bc) {
    	String display = "Healed HP: From " + user.getCurrentHp() + " -> To ";
        user.increaseHP(HEAL_AMOUNT);
        display = display + user.getCurrentHp();
        bc.getUI().displayActionResult("", user, null, "", display);

    }
}