
public class DefendEffect extends Buff {
    private int damageReduction;

    public DefendEffect(int damageReduction) {
        super("Defend", 1); // lasts 1 turn
        this.damageReduction = damageReduction;
    }
    
    public void modifyDefense(Combatant combatant) {
    	combatant.setAddOnDefense(combatant.getAddOnDefense()+damageReduction);
    }
}