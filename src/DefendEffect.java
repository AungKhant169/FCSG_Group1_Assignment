
public class DefendEffect extends Buff {
    private int boostAmount;

    public DefendEffect(int boostAmount) {
        super("Defend", 1); // lasts 1 turn
        this.boostAmount = boostAmount;
    }
    
    public int modifyDefense() {
    	return boostAmount;
    }
}