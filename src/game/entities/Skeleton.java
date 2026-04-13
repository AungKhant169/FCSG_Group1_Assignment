package game.entities;
import game.actions.SingleTargetAction;
import game.actions.BasicAttack;
import game.core.BattleContext;

public class Skeleton extends Player {
    
    public Skeleton() {
        super(30, 20, 5, 25, 0, "Skeleton", "Skeleton");
    }

    public String getName() {
        return "Skeleton";
    }

    //no special skill 
    public void specialSkill(BattleContext bc, boolean cdReset){
    }

    @Override 
    public void performAction(BattleContext bc){
        Combatant target = bc.getLowestHPEnemy();
        if (target == null) return; // No living enemies left

        SingleTargetAction basicAttack = new BasicAttack();
        basicAttack.execute(this, target, bc.getUI());
    }
}
