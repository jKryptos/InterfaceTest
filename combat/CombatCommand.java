package combat;

import entities.Monster;
import skills.Ability;

public class CombatCommand {

    private CombatAction action;
    private Ability ability;
    private Monster target;

    public CombatCommand(CombatAction action){
        this.action = action;
    }

    public CombatAction getAction(){
        return this.action;
    }

    public Ability getAbility(){
        return this.ability;
    }

    public Monster getTarget(){
        return this.target;
    }

    public void setAbility(Ability ability){
        this.ability = ability;
    }

    public void setTarget(Monster target){
        this.target = target;
    }
}
