package game.actions;
import java.util.List;

import game.effects.ATKBoostEffect;
import game.entities.Combatant;
import game.entities.Enemy;
import game.ui.UI;

public class ArcaneBlastSkill implements Action {

    @Override
    public void execute(Combatant wizard, List<Enemy> enemyList, UI ui){
        int kills = 0;
        ui.displayActionResult("Arcane Blast", wizard, null, "", "");

        SingleTargetAction basicAttack = new BasicAttack() ;

        for (Enemy enemy : enemyList){
            if (!enemy.isAlive()) continue;
            basicAttack.execute(wizard, enemy, ui);
            if (!enemy.isAlive()) kills++;
        }

        if (kills > 0) {
            wizard.addStatusEffect(new ATKBoostEffect(kills * 10));
            
            String display = "Attack Boosted: From "+ wizard.getTotalAttack() + " + " + (kills * 10);
            ui.displayActionResult("", wizard, null, "", display);
        }
    }
}