import java.util.ArrayList;

public class TurnManager {	
	public ArrayList<Combatant> getTurnsBasedOnSpeed(ArrayList<Combatant> c) {
		// sort the list based on speed and return
		int len = c.size();
		ArrayList<Combatant> turnOrder = new ArrayList<>(c);
		for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (turnOrder.get(j).getBaseSpeed() > turnOrder.get(j + 1).getBaseSpeed()) {
					Combatant temp = turnOrder.get(j);
					turnOrder.set(j, turnOrder.get(j + 1));
					turnOrder.set(j + 1, temp);
                }
            }
		}
		this.displayOrder(turnOrder);
		return turnOrder;
	}

	private void displayOrder(ArrayList<Combatant> turnOrder) {
		ArrayList<Combatant> uniqueList = new ArrayList<>();
		for (Combatant combatant : turnOrder) {
            boolean duplicate = false;
			Class<?> combatantClassName = combatant.getClass();
            for (Combatant unique : uniqueList) {
                if (unique.getClass().equals(combatantClassName)) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                uniqueList.add(combatant);
            }
        }
		UI.displayTurnOrder(uniqueList);
	}
}


