public class ShieldBashSkill implements Action {

    @Override
    public void execute(Combatant warrior, Combatant target, UI ui) {
        BasicAttack basicAttack = new BasicAttack() ;
        basicAttack.execute(warrior, target, ui);
        target.addStatusEffect(new StunEffect());
    }

}