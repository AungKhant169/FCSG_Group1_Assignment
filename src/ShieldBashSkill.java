public class ShieldBashSkill implements Action {

    @Override
    public void execute(Combatant warrior, Combatant target, UI ui) {
    	String display = "Warrior -> Shield Bash -> " + target.getName();
    	ui.displayActionResult(display);
        BasicAttack basicAttack = new BasicAttack() ;
        basicAttack.execute(warrior, target, ui);
        target.addStatusEffect(new StunEffect());
    }

}