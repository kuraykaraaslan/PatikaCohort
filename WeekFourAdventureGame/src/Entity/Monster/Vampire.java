/*
This code defines a class called Vampire that extends the Entity class.
It overrides the default constructor to set the name, attack, defense, and health values of the Vampire entity.
*/

package Entity.Monster;  // Declares the package name where the class belongs to.

import Entity.Entity;  // Imports the Entity class from another package.

public class Vampire extends Entity {  // Declares the Vampire class that extends the Entity class.
    public Vampire() {  // Declares the constructor for the Vampire class.
        super("Vampire", 4, 14, 7);  // Calls the constructor of the superclass(Entity) with specific values for name, attack, defense, and health.
    }
}
