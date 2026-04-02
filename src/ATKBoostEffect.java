
public class ATKBoostEffect extends Buff {
    private int boostAmount;

    public ATKBoostEffect(int boostAmount) {
        super("ATK Boost", -1); // permanent
        this.boostAmount = boostAmount;
    }
    
    public int modifyAttack() {
    	return boostAmount;
    }

    @Override
    public boolean isExpired() {
        return false;
    }
}