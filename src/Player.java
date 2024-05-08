package src;

public class Player {
    int health;
    int strength;
    int attack;

    /*
     * constructor to initialize player objects
     * 
     * @params : {int} health - health of a player
     * 
     * @params : {int} strength - strength of a player
     * 
     * @params : {int} attack - attack of a player
     * 
     */
    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    // getters
    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getStrength() {
        return strength;
    }
}
