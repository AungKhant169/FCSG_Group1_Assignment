import java.util.List;

public interface UI {

	public void displayWelcome();

	public void invalidInput(String message);

	public int selectClass();

	public void displaySelectedClass(int choice);

	public List<Integer> selectItems();

	public void displaySelectedItems(List<Integer> items);

	public int selectLevel();

	public void displaySelectedLevel(int level);

	public void displayRoundStart(int roundNum);

	public void displayTurnOrder(List<Combatant> order);

	public void displayActionMenu(Combatant c);

	public int getPlayerAction(Combatant c);

	public void displaySelectedAction(int action);

	public void displayActionResult(String message);

	public void displayRoundSummary(List<Combatant> combatants);

	public void displayLevelSummary(List<Combatant> combatants, int totalRound);

	public void displayBackupSpawn();

	public void displayStunned(String name);

	public void displayVictory();

	public void displayDefeat();

	public void printLine(String text);

	public int getUseItem(Combatant c);

	public String askToContinue();

	public String askToTryAgain();

	public void displayEndGame();

}
