package game.actions;
import game.effects.StunEffect;
import game.entities.Combatant;
import game.ui.UI;

public class ShieldBashSkill extends SingleTargetAction {

    @Override
    public void execute(Combatant warrior, Combatant target, UI ui) {
        ui.displayActionResult("Shield Bash -> " + target.getName(), warrior, null, "", "");
        SingleTargetAction basicAttack = new BasicAttack() ;
        basicAttack.execute(warrior, target, ui);
        target.addStatusEffect(new StunEffect());
    }

}