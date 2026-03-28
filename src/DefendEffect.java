public class DefendEffect extends Buff {
    private int damageReduction;

    public DefendEffect(int damageReduction) {
        super("Defend", 1); // lasts 1 turn
        this.damageReduction = damageReduction;
    }

    @Override
    public void apply(Combatant target) {
        target.setDamageReduction(damageReduction);
        System.out.println(target.getName() + " takes a defensive stance! Damage reduced by " + damageReduction + "!");
    }

    @Override
    public void remove(Combatant target) {
        target.setDamageReduction(0);
        System.out.println(target.getName() + "'s defensive stance ends!");
    }
}