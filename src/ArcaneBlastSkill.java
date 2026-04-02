import java.util.List;

public class ArcaneBlastSkill implements Action {

    @Override
    public void execute(Combatant wizard, List<Enemy> enemyList, UI ui){
        int kills = 0;
        BasicAttack basicAttack = new BasicAttack() ;

        for (Enemy enemy : enemyList){
            if (!enemy.isAlive()) continue;
            basicAttack.execute(wizard, enemy, ui);
            if (!enemy.isAlive()) kills++;
        }

        if (kills > 0) {
            wizard.addStatusEffect(new ATKBoostEffect(kills * 10));
        }
    }
}