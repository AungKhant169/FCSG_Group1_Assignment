package game.levels;
import java.util.ArrayList;
import java.util.List;

import game.entities.Enemy;
import game.entities.Goblin;
import game.entities.Wolf;

public class LevelHard extends Level {
    public LevelHard() {
        List<Enemy> initialList = new ArrayList<>();
        List<Enemy> backupList = new ArrayList<>();
        initialList.add(new Goblin("Goblin A"));
        initialList.add(new Goblin("Goblin B"));
        setInitialWave(initialList);
        backupList.add(new Goblin("Goblin C"));
        backupList.add(new Wolf("Wolf A"));
        backupList.add(new Wolf("Wolf B"));
        setBackupWave(backupList);
    }
}
