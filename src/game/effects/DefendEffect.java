package game.effects;

public class DefendEffect extends Buff {
    private int boostAmount;

    public DefendEffect(int boostAmount) {
        super("Defend", 2); // lasts 2 turn
        this.boostAmount = boostAmount;
    }
    
    public int modifyDefense() {
    	return boostAmount;
    }

    @Override
    public String getEffectEmoji() {
        return "🛡️"; 
    }
}