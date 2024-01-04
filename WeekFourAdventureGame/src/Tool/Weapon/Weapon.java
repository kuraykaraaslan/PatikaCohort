// This code is for a Weapon class that extends the Tool class and is part of the Tool.Weapon package

package Tool.Weapon;

import Tool.Tool; // Importing the Tool class

public abstract class Weapon extends Tool {
    private final int damage; // Declaring a private final variable "damage"

    public Weapon(String name, int damage, int price) {
        super(name, price); // Calling the Tool class constructor with name and price parameters
        this.damage = damage; // Assigning the damage parameter to the damage variable
    }

    public int getDamage() {
        return damage; // Returning the value of the damage variable
    }
}
