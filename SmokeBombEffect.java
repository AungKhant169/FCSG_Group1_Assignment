public class SmokeBombEffect extends Buff {

    public SmokeBombEffect() {
        super("Smoke Bomb", 2); // blocks damage for 2 turns
    }

    @Override
    public void apply(Combatant target) {
        target.setSmokeBombActive(true);
        System.out.println(target.getName() + " is shrouded in smoke! Enemy attacks deal 0 damage!");
    }

    @Override
    public void remove(Combatant target) {
        target.setSmokeBombActive(false);
        System.out.println("Smoke Bomb effect has worn off!");
    }
}