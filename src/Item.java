// only items can tough this class directly as it is abstract
public abstract class Item {

    // Fields
    private String name;
    private String description;

    // Constructor
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Getters
    public String getName()        { return name; }
    public String getDescription() { return description; }

    // Abstract — each subclass defines its own use behaviour( so overridden- POLYMORPHISM)
    public abstract void use(Combatant user);

    @Override
    public String toString() {
        return name + ": " + description;
    }
}