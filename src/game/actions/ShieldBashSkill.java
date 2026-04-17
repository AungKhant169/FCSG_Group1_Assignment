package game.actions;
import game.effects.StunEffect;
import game.entities.Combatant;
import game.ui.UI;

public class ShieldBashSkill extends SingleTargetAction {

    @Override
    public void execute(Combatant warrior, Combatant target, UI ui) {
        String display = target.getEntityEmoji() + " " + target.getName() + " Stunned 💫";
        ui.displayActionResult("🫴 ✨", warrior, target, null , display);
        target.addStatusEffect(new StunEffect());

        SingleTargetAction basicAttack = new BasicAttack() ;
        basicAttack.execute(warrior, target, ui);
        
    }

}