// only items can tough this class directly as it is abstract
public abstract class Item {

    // Fields
    private String name;
    private String description;
    private int useCount;
    private int currentUseCount;

    // Constructor
    public Item(String name, String description, int useCount) {
        this.name = name;
        this.description = description;
        this.useCount = useCount;
        this.currentUseCount = useCount;
    }

    // Getters
    public String getName()        { return name; }
    public String getDescription() { return description; }

    // Abstract — each subclass defines its own use behaviour( so overridden- POLYMORPHISM)
    public abstract void use(Combatant user, BattleContext bc);

    @Override
    public String toString() {
        return name + ": " + description;
    }
    public boolean isUsable() {
    	return (currentUseCount > 0);
    }
    
    public void reduceUseCount() {
    	this.currentUseCount--;
    }
    
    public void resetUseCount() {
    	this.currentUseCount = useCount;
    }
    
    public int getCurrentUseCount() {
    	return this.currentUseCount;
    }
    public int getUseCount() {
    	return this.useCount;
    }
}