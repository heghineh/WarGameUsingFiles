package com.company;

public class Archer extends Warrior {
    //region Properties
    private int criticalHitCoefficient;
    //endregion

    //region Constructors
    public Archer() {
    }

    public Archer(String name, int health, int damage) {
        super(name, health, damage);
    }
    //endregion

    //region Public Methods
    @Override
    public void attack(Warrior opponent, Warrior activePlayer) {

        if (criticalHitCoefficient == 0) {
            int temp = activePlayer.getDamage();
            int tempCriticalHitCoefficient = criticalHitCoefficient;

            activePlayer.setDamage(activePlayer.getDamage() * 2);
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
            activePlayer.setDamage(temp);
            criticalHitCoefficient--;
            criticalHitCoefficient = tempCriticalHitCoefficient;
        } else {
            opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
        }
    }

    @Override
    protected int takeDamage(Warrior activePlayer) {
        return activePlayer.getDamage();
    }
    //endregion

    //region Getters and setters
    public int getCriticalHitCoefficient() {
        return criticalHitCoefficient;
    }

    public void setCriticalHitCoefficient(int criticalHitCoefficient) {
        this.criticalHitCoefficient = criticalHitCoefficient;
    }
    //endregion
}