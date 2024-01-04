package Location.BattleLocation;

import Entity.Monster.Zombie;
import Entity.Player.Player;

public class Cave extends BattleLocation {
    public Cave(Player player) {
        super(player, new Zombie());
        // Create a new Cave object by calling the constructor of the parent class
        // "BattleLocation" and passing the player object and a new Zombie object
        // as arguments.
    }

    @Override
    public boolean itemControl() {
        // Override the method "itemControl()" defined in the parent class
        // "BattleLocation".

        return getPlayer().hasFood;
        // Return whether the player has food as a boolean value.
    }

    @Override
    public void getReward() {
        // Override the method "getReward()" defined in the parent class
        // "BattleLocation".

        if (getPlayer().getCharacter().getHealth() > 0) {
            // Check if the player's character's health is greater than 0.
            // If it is, continue with the following code.

            getPlayer().hasFood = true;
            // Set the player's "hasFood" variable to true.

            System.out.println("You Have Collected Food!");
            // Print "You Have Collected Food!" to the console.
        }
    }
}
