package skills;

import entities.Combatant;

public class Magic extends Skill{

    private final int manaCost;

    public Magic(String name, String description, int manaCost, int damage, int turnOrderPriorityLevel){
        super(name, description, damage, turnOrderPriorityLevel);
        this.manaCost = manaCost;
    }

    public int getManaCost(){
        return this.manaCost;
    }

    @Override
    public boolean use(Combatant user, Combatant target){
        if(user.getMana() < this.manaCost){
            return false;
        }
        user.spendMana(this.manaCost);
        target.takeDamage(this.damage);
        return true;
    }
}
