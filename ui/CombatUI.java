package ui;

import combat.*;
import combat.CombatManager;
import combat.CombatResult;
import entities.Monster;
import skills.Ability;

//This class calls from the CombatManager to get information for UI display
//TODO Add Ability and Magic menus, Make windowUI for Ability/Magic/Item

public class CombatUI extends UI{

    private final CombatManager combatManager;

    public CombatUI(CombatManager cm){
        super();
        this.combatManager = cm;
    }

    public void startCombat(){

        while (this.combatManager.isCombatOngoing()){

            CombatCommand command = getPlayerCommand();
            this.combatManager.receiveCombatCommand(command);
            CombatResult result = this.combatManager.processTurn();
            displayTurnResult(result);
            displayHealthOfCombatants();
        }
        displayOutcomeOfCombat();
    }

    public CombatCommand getPlayerCommand(){
        while (true){
            System.out.println("1. Attack\n2. Ability\n3. Magic\n4. Item");

            try{
                int input = Integer.parseInt(scanner.nextLine());

                switch (input){
                    case 1: {
                        CombatCommand command = new CombatCommand(CombatAction.ATTACK);
                        Monster target = combatManager.getMonster();
                        command.setTarget(target);

                        return command;
                    }

                    case 2: {
                        CombatCommand command = new CombatCommand(CombatAction.ABILITY);
                        AbilityUI aUI = new AbilityUI(combatManager.getPlayer());
                        Ability ability = aUI.selectAbility();
                        if(ability == null){
                            return getPlayerCommand();
                        }
                        Monster target = combatManager.getMonster();

                        command.setAbility(ability);
                        command.setTarget(target);

                        return command;
                    }
                    case 3: return new CombatCommand(CombatAction.MAGIC);
                    case 4: return new CombatCommand(CombatAction.ITEM);
                    default:
                        System.out.println("Invalid option");
                }
            } catch (NumberFormatException e){
                System.out.println("Please enter a number");
            }
        }
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
    public void displayHealthOfCombatants(){
        System.out.println("Player: " + this.combatManager.getPlayer().getCurrentHealthPoints() + "/" + this.combatManager.getPlayer().getMaxHealthPoints() + " HP");
        System.out.println(this.combatManager.getMonster().getName() + ": " + this.combatManager.getMonster().getCurrentHealthPoints() + "/" + this.combatManager.getMonster().getMaxHealthPoints() + " HP");
    }
    //Shows who dies in the fight when it is over
    public void displayOutcomeOfCombat(){
        if(this.combatManager.isPlayerDead()){
            System.out.println("You died!");
        } else {
            System.out.println("You have defeated the " + this.combatManager.getMonster().getName() + "!");
        }
    }
}
