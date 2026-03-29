import java.util.ArrayList;
import java.util.List;

public class LevelTwo extends Level {
    public LevelTwo() {
        List<Enemy> initialList = new ArrayList<>();
        List<Enemy> backupList = new ArrayList<>();
        initialList.add(new Goblin());
        initialList.add(new Wolf());
        setInitialWave(initialList);
        backupList.add(new Wolf());
        backupList.add(new Wolf());
        setBackupWave(backupList);
    }

    public List<Enemy> loadInitialWave() {
        return getInitialWave();
    }

    public List<Enemy> loadBackupWave() {
        return getBackupWave();
    }
}
