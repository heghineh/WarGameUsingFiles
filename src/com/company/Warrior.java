package com.company;

public abstract class Warrior {
    //region Properties
    private String name;
    private int health;
    private int damage;
    //endregion

    //region Constructors
    public Warrior() {
    }

    public Warrior(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
    //endregion

    //region Public methods
    abstract public void attack(Warrior opponent, Warrior activePlayer);

    abstract protected int takeDamage(Warrior activePlayer);
    //endregion

    //region Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    //endregion
}