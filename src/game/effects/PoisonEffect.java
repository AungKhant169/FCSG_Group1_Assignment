package game.effects;
import game.entities.Combatant;
import game.ui.UI;

public class PoisonEffect extends DamageOverTimeEffect {
    public PoisonEffect(String name, int duration, int dotDamage) {
        super(name, duration, dotDamage);
    }

    @Override
    public String getEffectEmoji() {
        return "☣️ "; 
    }
}
