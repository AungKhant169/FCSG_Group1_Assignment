
public class DefendAction implements Action{

    public void execute(Combatant c) {
        StatusEffect def = new DefendEffect(10);
        c.addStatusEffect(def);
    }
}
