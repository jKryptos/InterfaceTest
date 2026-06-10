package combat;

import entities.Monster;
import entities.Player;

import java.util.ArrayList;

//This class calculates all information related to combat, receiving direction from the UI for decisions

public class CombatManager {

    private final Player player;
    private final ArrayList<Monster> listOfMonsters;
    private CombatAction playerAction;

    public CombatManager(Player player, ArrayList<Monster> listOfMonsters){
        this.player = player;
        this.listOfMonsters = listOfMonsters;
    }
    //TODO: Modify this method for dealing with multiple options during a turn's beginning
    public CombatResult processTurn(){
        boolean playerHit = false;
        int playerDamage = 0;
        boolean monsterHit = false;
        int monsterDamage = 0;

        if(this.playerAction == CombatAction.ATTACK){
            playerHit = this.player.tryAttack(this.listOfMonsters.get(0));
            playerDamage = playerHit ? this.listOfMonsters.get(0).getMostRecentDamageTaken() : 0;

            if (!this.listOfMonsters.get(0).isDead()){
                monsterHit = this.listOfMonsters.get(0).tryAttack(this.player);
                monsterDamage = monsterHit ? this.player.getMostRecentDamageTaken() : 0;
            }
        }
        return new CombatResult(playerHit, playerDamage, monsterHit, monsterDamage);
    }

    public boolean isCombatOngoing(){
        return !this.player.isDead() && !this.listOfMonsters.get(0).isDead();
    }

    public boolean isPlayerDead(){
        return this.player.isDead();
    }

    public Player getPlayer(){
        return this.player;
    }

    public Monster getMonster(){
        return this.listOfMonsters.get(0);
    }

    public void receiveCombatAction(CombatAction action){
        this.playerAction = action;
    }
}
