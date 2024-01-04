/*
This code defines a class called Knight that extends the Entity class.
It overrides the default constructor to set the name, attack, defense, and health values of the Knight entity.
*/

package Entity.Character;  // Declares the package name where the class belongs to.

import Entity.Entity;  // Imports the Entity class from another package.

public class Knight extends Entity {  // Declares the Knight class that extends the Entity class.
    public Knight() {  // Declares the constructor for the Knight class.
        super("Knight", 8, 24, 5);  // Calls the constructor of the superclass(Entity) with specific values for name, attack, defense, and health.
    }
}
