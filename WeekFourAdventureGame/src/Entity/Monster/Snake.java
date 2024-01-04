/*
This code defines a class called Snake that extends the Entity class.
It overrides the default constructor to set the name, attack, defense, and health values of the Snake entity.
*/

package Entity.Monster;  // Declares the package name where the class belongs to.

import Entity.Entity;  // Imports the Entity class from another package.
import java.util.Random;  // Imports the Random class from java.util package.

public class Snake extends Entity {  // Declares the Snake class that extends the Entity class.
    private static final Random random = new Random();  // Declares a static final variable to generate random numbers.

    public Snake() {  // Declares the constructor for the Snake class.
        super("Snake", random.nextInt(3, 7), 12, 0);  // Calls the constructor of the superclass(Entity) with specific values for name, attack, defense, and health.
    }
}
