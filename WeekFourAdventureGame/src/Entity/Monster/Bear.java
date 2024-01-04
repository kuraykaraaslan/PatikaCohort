/*
This code defines a class called Bear that extends the Entity class.
It overrides the default constructor to set the name, attack, defense, and health values of the Bear entity.
*/

package Entity.Monster;  // Declares the package name where the class belongs to.

import Entity.Entity;  // Imports the Entity class from another package.

public class Bear extends Entity {  // Declares the Bear class that extends the Entity class.
    public Bear() {  // Declares the constructor for the Bear class.
        super("Bear", 7, 20, 12);  // Calls the constructor of the superclass(Entity) with specific values for name, attack, defense, and health.
    }
}
