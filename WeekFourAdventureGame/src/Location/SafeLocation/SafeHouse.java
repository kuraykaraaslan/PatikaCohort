// This code belongs to the package "Location.SafeLocation"
package Location.SafeLocation;

// Importing necessary classes and packages
import Entity.Player.Player;
import Location.Location;

// Define a class called "SafeHouse" which extends the "Location" class
public class SafeHouse extends Location {
    // Declare instance variables for the Player object and player's maximum health
    Player player;
    int playerMaxHealth;

    // Constructor for the SafeHouse class which takes a Player object as a parameter
    public SafeHouse(Player player) {
        // Initialize the instance variables with the values from the Player object
        this.player = player;
        this.playerMaxHealth = player.getCharacter().getHealth();
    }

    // Override the enter method from the superclass
    @Override
    public void enter() {
        // Set the player's health to the maximum health value
        player.getCharacter().setHealth(playerMaxHealth);
        // Print a message indicating that the player has rested at the safe house and their health has been refreshed
        System.out.println("\nYou Rested at Safe House! Your Health Has Been Refreshed.");
    }
}
