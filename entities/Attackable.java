package entities;

public interface Attackable {

    default void takeDamage(int amount) {
    }

    default boolean isDead(){
        return false;
    }
}
