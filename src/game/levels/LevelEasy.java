package game.levels;
import java.util.ArrayList;
import java.util.List;

import game.entities.Enemy;
import game.entities.Goblin;

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
