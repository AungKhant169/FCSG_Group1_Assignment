import java.util.ArrayList;
import java.util.List;

public class LevelHard extends Level {
    public LevelHard() {
        List<Enemy> initialList = new ArrayList<>();
        List<Enemy> backupList = new ArrayList<>();
        initialList.add(new Goblin());
        initialList.add(new Goblin());
        setInitialWave(initialList);
        backupList.add(new Goblin());
        backupList.add(new Wolf());
        backupList.add(new Wolf());
        setBackupWave(backupList);
    }
}
