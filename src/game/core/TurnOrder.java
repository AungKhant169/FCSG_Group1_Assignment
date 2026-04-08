package game.core;
import java.util.ArrayList;

import game.entities.Combatant;
import game.ui.UI;

public class TurnOrder {	
	private UI ui;
	
	public TurnOrder(UI ui) {
		this.ui = ui;
	}
	
	public ArrayList<Combatant> getTurnsBasedOnSpeed(ArrayList<Combatant> c) {
		// sort the list based on speed and return
		int len = c.size();
		ArrayList<Combatant> turnOrder = new ArrayList<>(c);
		for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (turnOrder.get(j).getBaseSpeed() < turnOrder.get(j + 1).getBaseSpeed()) {
					Combatant temp = turnOrder.get(j);
					turnOrder.set(j, turnOrder.get(j + 1));
					turnOrder.set(j + 1, temp);
                }
            }
		}
//		this.displayOrder(turnOrder);
		return turnOrder;
	}

	public void displayOrder(ArrayList<Combatant> turnOrder) {
		ArrayList<Combatant> uniqueList = new ArrayList<>();
		for (Combatant combatant : turnOrder) {
            boolean duplicate = false;
			String combatantName = combatant.getSimpleName();
            for (Combatant unique : uniqueList) {
                if (unique.getSimpleName().equals(combatantName)) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                uniqueList.add(combatant);
            }
        }
		ui.displayTurnOrder(uniqueList);
	}
}


