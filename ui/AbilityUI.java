package ui;

import entities.Player;
import skills.Ability;

import java.util.ArrayList;

public class AbilityUI extends UI{

    private final ArrayList<Ability> listOfAbilities;

    public AbilityUI(Player player){
        this.listOfAbilities = player.getListOfAbilities();
    }

    public Ability selectAbility() {

        while(true){

            for(int i = 0; i < this.listOfAbilities.size(); i++){
                Ability ability = this.listOfAbilities.get(i);
                String status = ability.isOnCooldown() ? " (ON COOLDOWN)" : "";

                System.out.println((i + 1) + ". " + this.listOfAbilities.get(i).getName() + status);
            }
            System.out.println("0. Go back");


            try {
                int input = Integer.parseInt(scanner.nextLine());

                if (input == (0)){
                    return null;
                }

                if (input >= 1 && input <= this.listOfAbilities.size()) {
                    Ability selected = this.listOfAbilities.get(input - 1);
                    if(selected.isOnCooldown()){
                        System.out.println("That ability is on cooldown, choose another");
                        continue;
                    }
                    return selected;
                }
                    System.out.println("Invalid selection");

            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
    }
}
