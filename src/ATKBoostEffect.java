public class ATKBoostEffect extends Buff {
    private int boostAmount;

    public ATKBoostEffect(int boostAmount) {
        super("ATK Boost", -1); // -1 = permanent, never expires
        this.boostAmount = boostAmount;
    }

    @Override
    public void apply(Combatant target) {
    	// ** keeping baseAttack untouched and chaning to addOnAttack to keep it separated
        target.setAddOnAttack(boostAmount);
        System.out.println(target.getName() + "'s ATK increased by " + boostAmount + "!");
    }

    @Override
    public void remove(Combatant target) {
        // permanent effect, nothing to reverse
    }

    @Override
    public boolean isExpired() {
        return false; // never expires
    }
}