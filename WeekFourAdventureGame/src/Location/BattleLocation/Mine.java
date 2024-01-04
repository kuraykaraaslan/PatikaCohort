// This code belongs to the package "Location.BattleLocation"
package Location.BattleLocation;

// Importing necessary classes and packages
import Entity.Player.Player;
import Entity.Monster.Snake;
import java.util.Random;
import Tool.Armor.*;
import Tool.Weapon.*;

// Define a class called "Mine" which extends the "BattleLocation" class
public class Mine extends BattleLocation {
    // Define private final variables for armor and weapon types
    private final LightArmor lightarmor;
    private final MediumArmor mediumArmor;
    private final HeavyArmor heavyArmor;

    private final Pistol pistol;
    private final Sword sword;
    private final Rifle rifle;

    // Create an instance of the Random class
    private final Random random = new Random();

    // Constructor for the Mine class which takes a Player object as a parameter
    public Mine(Player player) {
        // Call the constructor of the superclass (BattleLocation) with the Player object and a new Snake object
        super(player, new Snake());

        // Initialize the armor and weapon objects
        this.lightarmor = new LightArmor();
        this.mediumArmor = new MediumArmor();
        this.heavyArmor = new HeavyArmor();

        this.pistol = new Pistol();
        this.sword = new Sword();
        this.rifle = new Rifle();
    }

    // Override the itemControl method from the superclass
    @Override
    boolean itemControl() {
        return false;
    }

    // Override the getReward method from the superclass
    @Override
    void getReward() {
        // Generate a random number between 1 and 101
        double randomNumber = random.nextDouble(1, 101);
        
        // Check the random number to determine the reward
        if (randomNumber <= 15) {
            if (randomNumber <= 3) {
                getPlayer().getCharacter().setWeapon(rifle);
                printTrophy(rifle.getName());
            } else if (randomNumber <= 7.5) {
                getPlayer().getCharacter().setWeapon(sword);
                printTrophy(sword.getName());
            } else {
                getPlayer().getCharacter().setWeapon(pistol);
                printTrophy(pistol.getName());
            }
        } else if (randomNumber <= 30) {
            if (randomNumber <= 18) {
                getPlayer().getCharacter().setArmor(heavyArmor);
                printTrophy(heavyArmor.getName());
            } else if (randomNumber <= 22.5) {
                getPlayer().getCharacter().setArmor(mediumArmor);
                printTrophy(mediumArmor.getName());
            } else {
                getPlayer().getCharacter().setArmor(lightarmor);
                printTrophy(lightarmor.getName());
            }
        } else if (randomNumber <= 55) {
            if (randomNumber <= 35) {
                getPlayer().getCharacter().setMoney(getPlayer().getCharacter().getMoney() + 10);
                printTrophy("10 Money");
            } else if (randomNumber <= 42.5) {
                getPlayer().getCharacter().setMoney(getPlayer().getCharacter().getMoney() + 5);
                printTrophy("5 Money");
            } else {
                getPlayer().getCharacter().setMoney(getPlayer().getCharacter().getMoney() + 1);
                printTrophy("1 Money");
            }
        } else {
            System.out.println("No Loot!");
        }
    }

    // A private helper method to print the trophy found in the cave
    private void printTrophy(String trophy) {
        System.out.println(trophy + " Found in Cave");
    }
}
