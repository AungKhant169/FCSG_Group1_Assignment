public class ShieldBashEffect implements Action {

    @Override
    public void execute(Combatant warrior, Combatant target) {
        BasicAttack basicAttack = new BasicAttack() ;
        basicAttack.execute(warrior, target);
        target.addStatusEffect(new StunEffect());
    }

}