import java.util.ArrayList;
import java.util.List;

public class LevelOne extends Level {
    public LevelOne() {
        List<Enemy> initialList = new ArrayList<>();
        initialList.add(new Goblin());
        initialList.add(new Goblin());
        initialList.add(new Goblin());
        setInitialWave(initialList);
    }

    public List<Enemy> loadInitialWave() {
        return getInitialWave();
    }

    public List<Enemy> loadBackupWave() {
        return getBackupWave();
    }
}
