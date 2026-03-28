public abstract class Buff extends StatusEffect {

    public Buff(String name, int duration) {
        super(name, duration);
    }
    // apply() and remove() inherited from StatusEffect
    // concrete subclasses will implement them
}