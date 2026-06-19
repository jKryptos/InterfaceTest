package entities;

import java.util.Random;

public class Monster extends CombatEntity implements Combatant {

    private final Random rand = new Random();

    public Monster(String name, int healthPoints, int attack, int accuracy) {
        this.name = name;
        this.maxHealthPoints = healthPoints;
        this.currentHealthPoints = this.maxHealthPoints;
        this.attack = attack;
        this.accuracy = accuracy;
        this.mostRecentDamageTaken = 0;
    }
    @Override
    public void takeDamage(int amount){
        this.currentHealthPoints = Math.max(0, this.currentHealthPoints - amount);
        this.mostRecentDamageTaken = amount;
    }
    @Override
    public boolean isDead(){
        return this.currentHealthPoints <= 0;

    }

    @Override
    public boolean tryAttack(Attackable target){
        if(attackSuccessful()){
            dealDamage(target);
            return true;
        }
        return false;
    }

    @Override
    public void dealDamage(Attackable target){
        int total = this.attack + rand.nextInt((this.attack / 2));
        target.takeDamage(total);
    }

    @Override
    public boolean attackSuccessful(){
        int accuracyRoll = rand.nextInt(100);
        if(this.accuracy - accuracyRoll > 0){
            return true;
        } else {
            return false;
        }
    }
}
