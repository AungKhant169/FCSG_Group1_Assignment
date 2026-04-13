package game.actions;
import game.entities.Skeleton;
import game.entities.Combatant;
import game.actions.BasicAttack;        
import game.actions.SingleTargetAction; 
import game.core.BattleContext;         
import game.ui.UI;    


public class ResurrectionSkill extends SingleTargetAction{
    
    @Override
    public void execute(Combatant necromancer, Combatant enemy, UI ui, BattleContext bc) {
        ui.displayActionResult("Resurrection", necromancer, null, "", "");
        
        SingleTargetAction basicAttack = new BasicAttack();
        basicAttack.execute(necromancer, enemy, ui);
        
        Combatant skeleton = new Skeleton();
        bc.addAlly(skeleton);
        skeleton.performAction(bc);
    }
}