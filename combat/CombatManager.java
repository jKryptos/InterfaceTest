package combat;

import entities.Monster;
import entities.Player;
import skills.Ability;

import java.util.ArrayList;

//This class calculates all information related to combat, receiving direction from the UI for decisions

public class CombatManager {

    private final Player player;
    private final ArrayList<Monster> listOfMonsters;
    private CombatCommand command;

    public CombatManager(Player player, ArrayList<Monster> listOfMonsters){
        this.player = player;
        this.listOfMonsters = listOfMonsters;
    }
    //TODO: Modify this method for dealing with multiple options during a turn's beginning
    //TODO: Swap this.listOfMonsters.get(0).tryAttack(this.player) with a different way to get the monster

    public CombatResult processTurn(){
        Monster target = this.command.getTarget();
        boolean playerHit = false;
        int playerDamage = 0;
        boolean monsterHit = false;
        int monsterDamage = 0;

        switch(this.command.getAction()){
            case ATTACK:
                playerHit = this.player.tryAttack(target);
                playerDamage = playerHit ? target.getMostRecentDamageTaken() : 0;
                break;

            case ABILITY:
                playerHit = this.command.getAbility().use(player, target);
                playerDamage = target.getMostRecentDamageTaken();
                break;

            case MAGIC:
                break;

            case ITEM:
                break;
        }
        if (!target.isDead()){
            monsterHit = target.tryAttack(this.player);
            monsterDamage = monsterHit ? this.player.getMostRecentDamageTaken() : 0;
        }

        tickCooldowns();
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

    public void receiveCombatCommand(CombatCommand command){
        this.command = command;
    }

    public void tickCooldowns(){
        for (Ability ability : player.getListOfAbilities()){
            ability.tickCooldown();
        }
    }
}
