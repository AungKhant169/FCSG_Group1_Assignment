import java.util.List;

public abstract class Level {
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

}
