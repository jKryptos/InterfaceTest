import combat.CombatManager;
import entities.Monster;
import entities.Player;
import ui.CombatUI;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Player player = new Player("Bob", 120, 15, 50);
        Monster monster = new Monster("Goblin", 70, 20, 35);
        ArrayList<Monster> listOfMonsters = new ArrayList<>();
        listOfMonsters.add(monster);
        CombatManager cm = new CombatManager(player, listOfMonsters);
        CombatUI combatUI = new CombatUI(cm);
        combatUI.startCombat();
    }
}