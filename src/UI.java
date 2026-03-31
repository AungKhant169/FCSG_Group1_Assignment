import java.util.List;

public interface UI {

	public void displayWelcome();

	public int selectClass();

	public List<Integer> selectItems();

	public int selectLevel();

	public void displayRoundStart(int roundNum);

	public void displayTurnOrder(List<Combatant> order);

	public void displayActionMenu(Player player);
	
	public int getPlayerAction();
	
	public void displayActionResult(String message);
	
	public void displayRoundSummary(List<Combatant> combatants);
	
	public void displayBackupSpawn();
	
	public void displayStunned(String name);

	public void displayVictory();
	
	public void displayDefeat();
	
	public void printLine(String text);

}
