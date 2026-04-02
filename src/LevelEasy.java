import java.util.ArrayList;
import java.util.List;

public class LevelEasy extends Level {
    public LevelEasy() {
        List<Enemy> initialList = new ArrayList<>();
        initialList.add(new Goblin("Goblin A"));
        initialList.add(new Goblin("Goblin B"));
        initialList.add(new Goblin("Goblin C"));
        setInitialWave(initialList);
        setBackupWave(new ArrayList<>());
    }
}
