package skills;

import entities.Attackable;
import entities.Combatant;

public class Skill {

    protected final String name;
    protected final String description;
    protected final int damage;
    protected final int turnOrderPriorityLevel;

    public Skill(String name, String description, int damage, int turnOrderPriorityLevel){
        this.name = name;
        this.description = description;
        this.damage = damage;
        this.turnOrderPriorityLevel = turnOrderPriorityLevel;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public int getDamage(){
        return this.damage;
    }

    public int getTurnOrderPriorityLevel() {
        return this.turnOrderPriorityLevel;
    }

    public boolean use(Combatant user, Combatant target){
        return false;
    }
}
