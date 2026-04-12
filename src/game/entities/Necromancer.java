package game.entities;
import game.actions.ResurrectionSkill;
import game.actions.SingleTargetAction;


public class Necromancer extends Player {
    
    public Necromancer() {
        super(190, 40, 15, 25, 4, "Necromancer", "Necromancer");
    }

    public String getName() {
        return "Necromancer";
    }

    public void specialSkill(BattleContext bc, boolean cdReset) {

        SingleTargetAction res = new ResurrectionSkill();
        Combatant target = res.pickTarget(bc);
        res.execute(this, target, bc.getUI(), bc);
        if (!cdReset){
            this.setCurrentCooldown(this.getSpecialSkillCooldown());
        }
        
    }
}
