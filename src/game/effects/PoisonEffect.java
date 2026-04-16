package game.effects;
import game.entities.Combatant;
import game.ui.UI;

public class PoisonEffect extends DamageOverTimeEffect {
    public PoisonEffect(String name, int duration, int dotDamage) {
        super(name, duration, dotDamage);
    }

   @Override
   public void inflictDamage(Combatant c, UI ui, String emoji) {
		String statusDamageMessage = "HP⬇️: " + c.getCurrentHp() + " → ";
		c.takeDamage(this.dotDamage);
		statusDamageMessage = statusDamageMessage + c.getCurrentHp();
        ui.displayActionResult("takes " + emoji , c, null, this.dotDamage , statusDamageMessage);
    }

    @Override
    public String getEffectEmoji() {
        return "☣️ "; 
    }
}
