/*
This code defines a class called Zombie that extends the Entity class.
It overrides the default constructor to set the name, attack, defense, and health values of the Zombie entity.
*/

package Entity.Monster;  // Declares the package name where the class belongs to.

import Entity.Entity;  // Imports the Entity class from another package.

public class Zombie extends Entity {  // Declares the Zombie class that extends the Entity class.
    public Zombie() {  // Declares the constructor for the Zombie class.
        super("Zombie", 3, 10, 4);  // Calls the constructor of the superclass (Entity) with specific values for name, attack, defense, and health.
    }
}
