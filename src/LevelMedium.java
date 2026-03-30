import java.util.ArrayList;
import java.util.List;

public class LevelMedium extends Level {
    public LevelMedium() {
        List<Enemy> initialList = new ArrayList<>();
        List<Enemy> backupList = new ArrayList<>();
        initialList.add(new Goblin());
        initialList.add(new Wolf());
        setInitialWave(initialList);
        backupList.add(new Wolf());
        backupList.add(new Wolf());
        setBackupWave(backupList);
    }
}
