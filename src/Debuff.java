public abstract class Debuff extends StatusEffect {

    public Debuff(String name, int duration) {
        super(name, duration);
    }
    // apply() and remove() inherited from StatusEffect
    // concrete subclasses will implement them
}