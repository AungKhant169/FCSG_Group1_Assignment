import static java.lang.Math.max;

public class BasicAttack implements Action {

    @Override
    public void execute(Combatant attacker, Combatant target) {
        int attackerAtk = attacker.getBaseAttack() + attacker.getAddOnAttack();
        int targetDef = target.getBaseDefense() + target.getAddOnDefense();
        int damage = max(0, attackerAtk - targetDef);

        for (StatusEffect effect : attacker.getStatusEffects()) {
            damage = effect.interactWithOutDamage(damage);
        }

        damage = max(0, damage);
        target.takeDamage(damage);
    }
}
