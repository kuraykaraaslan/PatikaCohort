package Location.BattleLocation;

import Entity.Entity;
import Entity.Player.Player;
import Location.Location;

import java.util.Random;

public abstract class BattleLocation extends Location {
    private final int monsterMaxHealth; // The maximum health of the monster in the battle
    private final Random random = new Random(); // Random object to generate random numbers
    private final Player player; // The player object participating in the battle
    private final Entity monster; // The monster participating in the battle
    private int totalMoney; // Total money accumulated during the battle

    BattleLocation(Player player, Entity monster) {
        this.player = player; // Assign the provided player object to the local player variable
        this.monster = monster; // Assign the provided monster object to the local monster variable
        this.monsterMaxHealth = monster.getHealth(); // Set the maximum health of the monster
        this.totalMoney = 0; // Initialize the total money to 0
    }

    @Override
    public void enter() {
        if (!itemControl()) { // Check if the player has already entered this location before
            fight(player, monster); // Initiate the battle between the player and the monster
            if (player.getCharacter().getHealth() > 0) { // If the player's health is greater than 0 after the battle
                if (!(monster.getName().equals("Snake"))) { // If the monster is not a snake
                    System.out.println("\nYou Got " + totalMoney + " Money From Monsters!"); // Print the total money
                                                                                             // earned from the battle
                }
                getReward(); // Give the reward to the player
            }
            monster.setHealth(monsterMaxHealth); // Reset the monster's health to its maximum value
        } else {
            System.out.println("\nYou Have Already Cleared This Location!"); // Print message if the player has already
                                                                             // entered this location before
        }
    }

    public void fight(Player player, Entity monster) {
        int monsterNum = this.random.nextInt(2, 4); // Generate a random number of monsters between 2 and 4
        boolean playerHitFirst;
        System.out.println("\nThere are " + monsterNum + " " + monster.getName() + "s Inside!!"); // Print the number of
                                                                                                  // monsters

        for (int i = 1; i <= monsterNum; i++) { // Iterate for each monster
            monster.setHealth(monsterMaxHealth); // Reset the monster's health to its maximum value
            System.out.println("\n---------------" + i + ". " + monster.getName() + "----------------"); // Print the
                                                                                                         // monster's
                                                                                                         // name

            int playerHealth = player.getCharacter().getHealth();
            int monsterHealth = monster.getHealth();
            System.out.println(
                    player.getNickName() + ": " + playerHealth + " <> " + monster.getName() + ": " + monsterHealth); // Print

            playerHitFirst = this.random.nextBoolean(); // Determine randomly if the player will hit first

            if (playerHitFirst) { // If the player hits first
                player.getCharacter().hit(monster); // Player's character attacks the monster
                printHealth(playerHealth, monster, true); // Print the health status after the player's attack
                if (monsterHealth == 0) { // If the monster's health becomes 0
                    System.out.println("----------------------------------------");
                    totalMoney += monster.getMoney(); // Add the monster's money to the total money earned
                    continue; // Move to the next iteration of the loop
                }
            }

            while (true) { // Infinite loop until someone's health becomes 0
                monster.hit(player.getCharacter()); // Monster attacks the player's character
                printHealth(playerHealth, monster, false); // Print the health status after the monster's attack
                if (playerHealth == 0)
                    break; // If the player's health becomes 0, break out of the loop

                player.getCharacter().hit(monster); // Player's character attacks the monster
                printHealth(playerHealth, monster, true); // Print the health status after the player's attack
                if (monsterHealth == 0)
                    break; // If the monster's health becomes 0, break out of the loop
            }

            System.out.println("----------------------------------------");

            if (playerHealth == 0)
                break; // If the player's health becomes 0, break out of the loop
            totalMoney += monster.getMoney(); // Add the monster's money to the total money earned
        }

        player.getCharacter().setMoney(player.getCharacter().getMoney() + totalMoney); // Add the total money earned to
                                                                                       // the player's money balance
    }

    private void printHealth(int playerHealth, Entity monster, boolean isPlayerAttacking) {
        System.out.println((isPlayerAttacking ? "Player" : "Monster") + " attacks!");
        System.out.println("Player Health: " + playerHealth + " <> Monster Health: " + monster.getHealth());
    }

    private boolean isHealthZero(int health) {
        return health == 0;
    }

    public Player getPlayer() {
        return player; // Return the player object
    }

    abstract boolean itemControl(); // Abstract method to check if the player has

    abstract void getReward();

    public void printHealth(Player player, Entity monster, boolean isPlayer) {
        System.out.print(player.getNickName() + ": " + player.getCharacter().getHealth());
        if (player.getCharacter().getHealth() < 10)
            System.out.print(" ");
        System.out.print(isPlayer ? " -> " : " <- ");
        System.out.println(monster.getName() + ": " + monster.getHealth());
    }
}