public class SmokeBomb extends Item {

    public SmokeBomb() {
        super("💨 Smoke Bomb", "Enemy attacks deal 0 damage this turn + next");
    }

    @Override
    public void use(Combatant user) {
        // Apply SmokeBombInvulnerability status effect to the user for 2 turns
        user.addStatusEffect(new SmokeBombInvulnerability());
        System.out.println(user.getName() + " Enemy attacks deal 0 damage this turn + next");
    }
}