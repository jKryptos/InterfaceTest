package entities;

public class Entity {

    String name;
    int attack;
    int maxHealthPoints;
    int currentHealthPoints;
    int accuracy;
    int mostRecentDamageTaken;

    public Entity() {
    }

    public String getName(){
        return this.name;
    }

    public int getCurrentHealthPoints(){
        return this.currentHealthPoints;
    }

    public int getMaxHealthPoints(){
        return this.maxHealthPoints;
    }

    public int getMostRecentDamageTaken(){
        return this.mostRecentDamageTaken;
    }
}
