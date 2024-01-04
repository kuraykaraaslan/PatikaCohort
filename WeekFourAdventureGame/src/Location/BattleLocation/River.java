// This code belongs to the package "Location.BattleLocation"
package Location.BattleLocation;

// Importing necessary classes and packages
import Entity.Monster.Bear;
import Entity.Player.Player;

// Define a class called "River" which extends the "BattleLocation" class
public class River extends BattleLocation {
    // Constructor for the River class which takes a Player object as a parameter
    public River(Player player) {
        // Call the constructor of the superclass (BattleLocation) with the Player object and a new Bear object
        super(player, new Bear());
    }

    // Override the itemControl method from the superclass
    @Override
    public boolean itemControl() {
        // Return the value of the "hasWater" attribute of the Player object
        return getPlayer().hasWater;
    }

    // Override the getReward method from the superclass
    @Override
    public void getReward() {
        // Check if the player's character health is greater than 0
        if (getPlayer().getCharacter().getHealth() > 0)
            // If true, set the "hasWater" attribute of the Player object to true
            getPlayer().hasWater = true;
        // Print a message indicating that the player has collected water
        System.out.println("You Have Collected Water!");
    }
}
