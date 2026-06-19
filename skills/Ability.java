package skills;

import entities.Combatant;

public class Ability extends Skill {

    private int remainingCooldownTime;
    private final int maxCooldownTime;

    public Ability(String name, String description, int damage, int turnOrderPriorityLevel, int maxCoolDownTime){
        super(name, description, damage, turnOrderPriorityLevel);
        this.maxCooldownTime = maxCoolDownTime;
        this.remainingCooldownTime = 0;
    }

    public int getCooldownTime(){
        return this.remainingCooldownTime;
    }

    public boolean isOnCooldown(){
        return this.remainingCooldownTime > 0;
    }

    public void tickCooldown(){
        if (this.remainingCooldownTime > 0){
            this.remainingCooldownTime--;
        }
    }

    @Override
    public boolean use(Combatant user, Combatant target){
        if (isOnCooldown()){
            return false;
        }
        this.remainingCooldownTime = this.maxCooldownTime;
        target.takeDamage(this.damage);
        return true;
    }
}
