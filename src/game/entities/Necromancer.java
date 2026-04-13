package game.entities;
import game.actions.ResurrectionSkill;
import game.actions.SingleTargetAction;
import game.core.BattleContext;


public class Necromancer extends Player {
    
    public Necromancer() {
        super(200, 40, 15, 25, 3, "Necromancer", "Necromancer");
    }

    public void specialSkill(BattleContext bc, boolean cdReset) {

        SingleTargetAction res = new ResurrectionSkill();
        Combatant target = res.pickTarget(bc);
        res.execute(this, target, bc);
        if (!cdReset){
            this.setCurrentCooldown(this.getSpecialSkillCooldown());
        }
        
    }
}
