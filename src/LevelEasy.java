import java.util.ArrayList;
import java.util.List;

public class LevelEasy extends Level {
    public LevelEasy() {
        List<Enemy> initialList = new ArrayList<>();
        initialList.add(new Goblin());
        initialList.add(new Goblin());
        initialList.add(new Goblin());
        setInitialWave(initialList);
        setBackupWave(new ArrayList<>());
    }
}
