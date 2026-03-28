public class StunEffect extends Debuff {

    public StunEffect() {
        super("Stun", 2); // lasts 2 turns
    }

    @Override
    public void apply(Combatant target) {
        target.setStunned(true);
        System.out.println(target.getName() + " is STUNNED for 2 turns!");
    }

    @Override
    public void remove(Combatant target) {
        target.setStunned(false);
        System.out.println(target.getName() + "'s stun has worn off!");
    }
}