package entities;

public interface Combatant extends Attackable, Attacker{


    default void spendMana(int amount){
    }

    default int getMana(){
        return 0;
    }
}
