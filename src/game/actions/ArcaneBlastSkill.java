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
        String display = "Wizard -> ArcaneBlast";
        ui.displayActionResult(display);
        BasicAttack basicAttack = new BasicAttack() ;

        for (Enemy enemy : enemyList){
            if (!enemy.isAlive()) continue;
            basicAttack.execute(wizard, enemy, ui);
            if (!enemy.isAlive()) kills++;
        }

        if (kills > 0) {
            wizard.addStatusEffect(new ATKBoostEffect(kills * 10));
            display = "Wizard attack boosted -> " + wizard.getBaseAttack() + " + " + (kills * 10);
            ui.displayActionResult(display);
        }
    }
}