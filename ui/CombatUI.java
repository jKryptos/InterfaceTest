package ui;

import combat.CombatAction;
import combat.CombatManager;
import combat.CombatResult;

//This class calls from the CombatManager to get information for UI display

public class CombatUI extends UI{

    private final CombatManager combatManager;

    public CombatUI(CombatManager cm){
        super();
        this.combatManager = cm;
    }
    public void startCombat(){

        while (this.combatManager.isCombatOngoing()){

                System.out.println("1. Attack\n2. Ability\n3. Item");
                int input = Integer.parseInt(scanner.nextLine());

                CombatAction playerAction = switch(input){
                    case 1 -> CombatAction.ATTACK;
                    case 2 -> CombatAction.ABILITY;
                    case 3 -> CombatAction.ITEM;
                    default -> null;
                };

            combatManager.receiveCombatAction(playerAction);
            CombatResult result = this.combatManager.processTurn();
            displayTurnResult(result);
            displayStatus();
        }
        displayOutcome();
    }
    //Shows what happened during each turn
    private void displayTurnResult(CombatResult result){
        System.out.println();
        if (result.isPlayerHit()){
            System.out.println(this.combatManager.getMonster().getName() + " was hit for " + result.getPlayerDamage() + " damage!");
        } else {
            System.out.println("You missed the " + this.combatManager.getMonster().getName());
        }

        if (result.isMonsterHit()){
            System.out.println("You were struck by the " + this.combatManager.getMonster().getName() + " for " + result.getMonsterDamage() + " damage!");
        } else {
            System.out.println("The " + this.combatManager.getMonster().getName() + " missed!");
        }
    }
    //Shows current health out of max health for combatants
    public void displayStatus(){
        System.out.println("Player: " + this.combatManager.getPlayer().getCurrentHealthPoints() + "/" + this.combatManager.getPlayer().getMaxHealthPoints() + " HP");
        System.out.println(this.combatManager.getMonster().getName() + ": " + this.combatManager.getMonster().getCurrentHealthPoints() + "/" + this.combatManager.getMonster().getMaxHealthPoints() + " HP");
    }
    //Shows who dies in the fight when it is over
    public void displayOutcome(){
        if(this.combatManager.isPlayerDead()){
            System.out.println("You died!");
        } else {
            System.out.println("You have defeated the " + this.combatManager.getMonster().getName() + "!");
        }
    }
}
