package Entity;

import Tool.Armor.Armor;
import Tool.Weapon.Weapon;

public abstract class Entity {
    private Armor armor = null;  // The entity's armor, initially set to null
    private Weapon weapon = null;  // The entity's weapon, initially set to null
    private final String name;  // The name of the entity (cannot be changed)
    private final int damage;  // The base damage of the entity (cannot be changed)
    private int health;  // The current health of the entity
    private int money;  // The amount of money the entity has

    public Entity(String name, int damage, int health, int money) {
        this.name = name;  // Set the name using the provided argument
        this.damage = damage;  // Set the damage using the provided argument
        this.health = health;  // Set the health using the provided argument
        this.money = money;  // Set the money using the provided argument
    }

    public void setHealth(int health) {
        this.health = health;  // Update the entity's health with the provided value
    }

    public void setMoney(int money) {
        this.money = money;  // Update the entity's money with the provided value
    }

    public String getName() {
        return name;  // Return the entity's name
    }

    public int getHealth() {
        return health;  // Return the entity's health
    }

    public int getMoney() {
        return money;  // Return the entity's money
    }

    public void setArmor(Armor armor) {
        this.armor = armor;  // Set the entity's armor using the provided armor object
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;  // Set the entity's weapon using the provided weapon object
    }

    public Armor getArmor() {
        return armor;  // Return the entity's armor
    }

    public Weapon getWeapon() {
        return weapon;  // Return the entity's weapon
    }

    public void hit(Entity oppositeEntity) {
        int weaponDamage;  // Variable to store the damage of the attacking entity's weapon
        int oppositeProtection;  // Variable to store the protection of the opposite entity's armor
        int totalDamage;  // Variable to store the total damage inflicted

        // Determine the weapon damage, considering the possibility of no weapon equipped
        if (this.weapon == null)
            weaponDamage = 0;
        else
            weaponDamage = this.weapon.getDamage();

        // Determine the opposite entity's protection, considering the possibility of no armor equipped
        if (oppositeEntity.armor == null)
            oppositeProtection = 0;
        else
            oppositeProtection = oppositeEntity.armor.getProtection();

        // Calculate the total damage inflicted based on weapon damage and base damage
        totalDamage = weaponDamage + this.damage;

        // Reduce the total damage by the opposite entity's protection, or set it to 0 if protection is greater than total damage
        if (totalDamage <= oppositeProtection) {
            totalDamage = 0;
        } else {
            totalDamage -= oppositeProtection;
        }

        // Reduce the health of the opposite entity by the total damage inflicted
        oppositeEntity.setHealth(oppositeEntity.getHealth() - totalDamage);

        // If the opposite entity's health drops below 0, set it to 0
        if (oppositeEntity.getHealth() <= 0)
            oppositeEntity.setHealth(0);
    }
}
