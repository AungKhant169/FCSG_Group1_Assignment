package game.levels;

import java.util.ArrayList;
import java.util.List;

import game.entities.Enemy;
import game.entities.Goblin;
import game.entities.Wolf;
import game.ui.UI;

public class LevelCustom extends Level {
	
	public LevelCustom (UI ui) {
        List<Enemy> initialList = new ArrayList<>();
        List<Enemy> backupList = new ArrayList<>();
        int waveSize = ui.getWaveSize("initial");
        for ( int i  = 0; i < waveSize; i++) {
        	int enemyType = ui.getEnemyType(i);
        	if (enemyType == 1) {
        		initialList.add(new Goblin("Goblin " + (i+1)));
        	} else {
        		initialList.add(new Wolf("Wolf "+ (i+1)));
        	}
        }
        setInitialWave(initialList);
        waveSize = ui.getWaveSize("backup");
        for ( int i  = 0; i < waveSize; i++) {
        	int enemyType = ui.getEnemyType(i);
        	if (enemyType == 1) {
        		backupList.add(new Goblin("Goblin " + (i+1)));
        	} else {
        		backupList.add(new Wolf("Wolf "+ (i+1)));
        	}
        }
        setBackupWave(backupList);
	}
}
