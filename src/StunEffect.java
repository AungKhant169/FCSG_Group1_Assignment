public class StunEffect extends Debuff {

    public StunEffect() {
        super("Stun", 2); // lasts 2 turns
    }
    
    public boolean stopTurn() {
    	return true;
    }
}