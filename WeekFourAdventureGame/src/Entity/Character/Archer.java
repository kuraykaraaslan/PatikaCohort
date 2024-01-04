/*
This code defines a class called Archer that extends the Entity class.
It overrides the default constructor to set the name, attack, defense, and health values of the Archer entity.
*/

package Entity.Character;  // Declares the package name where the class belongs to.

import Entity.Entity;  // Imports the Entity class from another package.

public class Archer extends Entity {  // Declares the Archer class that extends the Entity class.
    public Archer() {  // Declares the constructor for the Archer class.
        super("Archer", 7, 18, 20);  // Calls the constructor of the superclass(Entity) with specific values for name, attack, defense, and health.
    }
}
