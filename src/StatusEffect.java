public abstract class StatusEffect {
    private String name;
    private int duration;

    public StatusEffect(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    // what happens when effect is applied to combatant
    public abstract void apply(Combatant target);

    // what happens when effect wears off
    public abstract void remove(Combatant target);

    // called every turn to count down
    public void tick() {
        if (duration > 0) {
            duration--;
        }
    }

    // check if effect is done
    public boolean isExpired() {
        return duration <= 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}