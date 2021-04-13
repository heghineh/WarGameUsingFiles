package com.company;

public class Swordsman extends Warrior {
    //region Properties
    private int armorPercentage;
    //endregion

    //region Constructors
    public Swordsman() {
    }

    public Swordsman(String name, int health, int damage, int armorPercentage) {
        super(name, health, damage);
        this.armorPercentage = armorPercentage;
    }
    //endregion

    //region Public Methods
    @Override
    public void attack(Warrior opponent, Warrior activePlayer) {
        opponent.setHealth(opponent.getHealth() - opponent.takeDamage(activePlayer));
    }

    @Override
    public int takeDamage(Warrior activePlayer) {
        return (activePlayer.getDamage() * (100 - armorPercentage) / 100);
    }
    //endregion

    //region Getters and Setters
    public int getArmorPercentage() {
        return armorPercentage;
    }

    public void setArmorPercentage(int armorPercentage) {
        this.armorPercentage = armorPercentage;
    }
    //endregion
}