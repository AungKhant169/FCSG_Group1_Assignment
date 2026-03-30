
public class ATKBoostEffect extends Buff {
    private int boostAmount;

    public ATKBoostEffect(int boostAmount) {
        super("ATK Boost", -1); // permanent
        this.boostAmount = boostAmount;
    }

    @Override
    public void apply(Combatant target) {
        target.setAddOnAttack(target.getAddOnAttack() + boostAmount);

       ui.println(target.getName() + 
            "'s ATK increased by " + boostAmount + "!");
    }

    @Override
    public void remove(Combatant target) {
        // If you EVER make it non-permanent, this must work correctly
        target.setAddOnAttack(target.getAddOnAttack() - boostAmount);
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}