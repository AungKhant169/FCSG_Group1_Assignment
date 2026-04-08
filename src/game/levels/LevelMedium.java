package game.levels;
import java.util.ArrayList;
import java.util.List;

import game.entities.Enemy;
import game.entities.Goblin;
import game.entities.Wolf;

public class LevelMedium extends Level {
    public LevelMedium() {
        List<Enemy> initialList = new ArrayList<>();
        List<Enemy> backupList = new ArrayList<>();
        initialList.add(new Goblin("Goblin A"));
        initialList.add(new Wolf("Wolf A"));
        setInitialWave(initialList);
        backupList.add(new Wolf("Wolf B"));
        backupList.add(new Wolf("Wolf C"));
        setBackupWave(backupList);
    }
}
