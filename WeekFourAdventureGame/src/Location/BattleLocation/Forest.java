package Location.BattleLocation;

import Entity.Monster.Vampire;
import Entity.Player.Player;

public class Forest extends BattleLocation {
    public Forest(Player player) {
        super(player, new Vampire());
        // Create a new Forest object by calling the constructor of the parent class
        // "BattleLocation" and passing the player object and a new Vampire object
        // as arguments.
    }

    @Override
    public boolean itemControl() {
        // Override the method "itemControl()" defined in the parent class
        // "BattleLocation".

        return getPlayer().hasFireWood;
        // Return whether the player has firewood as a boolean value.
    }

    @Override
    public void getReward() {
        // Override the method "getReward()" defined in the parent class
        // "BattleLocation".

        if (getPlayer().getCharacter().getHealth() > 0) {
            // Check if the player's character's health is greater than 0.
            // If it is, continue with the following code.

            getPlayer().hasFireWood = true;
            // Set the player's "hasFireWood" variable to true.

            System.out.println("You Have Collected Firewood!");
            // Print "You Have Collected Firewood!" to the console.
        }
    }
}
