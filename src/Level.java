import java.util.List;
import java.util.ArrayList;

public abstract class Level {
	private String levelInfo;
    private List<Enemy> initialWave;
    private List<Enemy> backupWave;

    public List<Enemy> getInitialWave() {
        return initialWave;
    }

    public List<Enemy> getBackupWave() {
        return backupWave;
    }

    public void setInitialWave(List<Enemy> enemies) {
        this.initialWave = enemies;
    }

    public void setBackupWave(List<Enemy> enemies) {
        this.backupWave = enemies;
    }
    
    public boolean hasLivingEnemiesInitialW() {
        for (Enemy e : initialWave) {
            if (e.isAlive()) return true;
        }
        return false;
    }

    public boolean hasLivingEnemiesBackupW() {
        for (Enemy e : backupWave) {
            if (e.isAlive()) return true;
        }
        return false;
    }
    
    public List<Enemy> getLivingEnemiesInitialW() {
        List<Enemy> living = new ArrayList<>();
        for (Enemy e : initialWave) {
            if (e.isAlive()) living.add(e);
        }
        return living;
    }
    
    public List<Enemy> getLivingEnemiesBackupW() {
        List<Enemy> living = new ArrayList<>();
        for (Enemy e : backupWave) {
            if (e.isAlive()) living.add(e);
        }
        return living;
    }

}
