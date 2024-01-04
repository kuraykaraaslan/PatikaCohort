/*
This code defines a class called Samurai that extends the Entity class.
It overrides the default constructor to set the name, attack, defense, and health values of the Samurai entity.
*/

package Entity.Character;  // Declares the package name where the class belongs to.

import Entity.Entity;  // Imports the Entity class from another package.

public class Samurai extends Entity {  // Declares the Samurai class that extends the Entity class.
    public Samurai() {  // Declares the constructor for the Samurai class.
        super("Samurai", 5, 21, 15);  // Calls the constructor of the superclass(Entity) with specific values for name, attack, defense, and health.
    }
}
