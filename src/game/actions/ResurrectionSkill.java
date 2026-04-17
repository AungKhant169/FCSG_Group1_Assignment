package game.actions;
import game.entities.Skeleton;
import game.entities.Combatant;
import game.core.BattleContext;         


public class ResurrectionSkill extends SingleTargetAction{
    
    @Override
    public void execute(Combatant necromancer, Combatant enemy, BattleContext bc) {
    	bc.getUI().displayActionResult("🫴 ✨", necromancer, null, null , "");
        
        SingleTargetAction basicAttack = new BasicAttack();
        basicAttack.execute(necromancer, enemy, bc.getUI());
        
        Combatant skeleton = new Skeleton();
        bc.addAlly(skeleton);
        skeleton.performAction(bc);
    }
}