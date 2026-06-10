package entities;

public interface Attacker {

    default void dealDamage(Attackable target){
    }

    default boolean attackSuccessful(){
        return false;
    }

    default boolean tryAttack(Attackable target){
        return false;
    }
}
