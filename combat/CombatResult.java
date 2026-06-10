package combat;

public class CombatResult {

    private final boolean playerHit;
    private final int playerDamage;
    private final boolean monsterHit;
    private final int monsterDamage;

    public CombatResult(boolean playerHit, int playerDamage, boolean monsterHit, int monsterDamage){
        this.playerHit = playerHit;
        this.playerDamage = playerDamage;
        this.monsterHit = monsterHit;
        this.monsterDamage = monsterDamage;
    }

    public boolean isPlayerHit(){
        return this.playerHit;
    }
    public int getPlayerDamage(){
        return this.playerDamage;
    }

    public boolean isMonsterHit() {
        return this.monsterHit;
    }

    public int getMonsterDamage() {
        return this.monsterDamage;
    }
}
