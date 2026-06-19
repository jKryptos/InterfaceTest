package entities;

import skills.Ability;
import skills.Magic;

import java.util.ArrayList;

public class CombatEntity extends Entity{

    protected int attack;
    protected int maxHealthPoints;
    protected int currentHealthPoints;
    protected int maxMana;
    protected int currentMana;
    protected int accuracy;
    protected int mostRecentDamageTaken;
    protected ArrayList<Ability> listOfAbilities;
    protected ArrayList<Magic> listOfMagicSpells;

    public CombatEntity(){
        this.listOfAbilities = new ArrayList<>();
        this.listOfMagicSpells = new ArrayList<>();
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

    public int getCurrentMana() {
        return this.currentMana;
    }

    public int getMaxMana(){
        return this.maxMana;
    }

    public void addAbility(Ability ability){
        this.listOfAbilities.add(ability);
    }

    public void addMagicSpell(Magic magicSpell){
        this.listOfMagicSpells.add(magicSpell);
    }

    public ArrayList<Ability> getListOfAbilities(){
        ArrayList<Ability> list = new ArrayList<>(this.listOfAbilities);
        return list;
    }
}
