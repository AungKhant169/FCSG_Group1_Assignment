package game.entities;
import game.actions.SingleTargetAction;
import game.actions.BasicAttack;
import game.core.BattleContext;

public class Skeleton extends Player {
    
    public Skeleton() {
        super(50, 25, 0, 25, 0, "Skeleton", "Skeleton");
    }

    public String getName() {
        return "Skeleton";
    }

    //no special skill 
    public void specialSkill(BattleContext bc, boolean cdReset){
    }

    @Override 
    public void performAction(BattleContext bc){
        SingleTargetAction basicAttack = new BasicAttack();
        Combatant target = bc.getLowestHPEnemy();
        basicAttack.execute(this, target, bc.getUI());
    }
}
