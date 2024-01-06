/*
This code defines a class called Player.
It allows the player to select a character and manage their inventory (food, water, and firewood).
*/

package Entity.Player;  // Declares the package name where the class belongs to.

import Entity.Character.*;  // Imports character classes from the Entity.Character package.
import Entity.Entity;  // Imports the Entity class from another package.
import java.util.Scanner;  // Imports the Scanner class from java.util package.
import java.lang.StringBuilder;  // Imports the StringBuilder class from java.lang package.

// Declare a class called Player.
public class Player {
    private final Scanner scanner = new Scanner(System.in);  // Creates a Scanner object for user input.
    private final String nickName;  // Declare a final variable to store the player's nickname.
    private Entity character;  // Declare a variable to store the player's selected character.
    public boolean hasFood, hasWater, hasFireWood;  // Declare boolean variables to track the player's inventory status.

    public Player(String nickname) {  // Declare a constructor for the Player class.
        selectCharacter();  // Call the selectCharacter method to allow the player to select a character.
        this.nickName = nickname;  // Set the player's nickname.
        this.hasFireWood = false;  // Initialize the hasFireWood variable to false (player does not have firewood).
        this.hasWater = false;  // Initialize the hasWater variable to false (player does not have water).
        this.hasFood = false;  // Initialize the hasFood variable to false (player does not have food).
    }

    public Entity getCharacter() {  // Define a method to get the player's character.
        return character;  // Return the player's character.
    }

    public String getNickName() {  // Define a method to get the player's nickname.
        return nickName;  // Return the player's nickname.
    }

    public void selectCharacter() {  // Define a method to allow the player to select a character.
        selectCharacter:
        while (true) {
            // Display the character menu and prompt the player for selection.
            StringBuilder menu = new StringBuilder();
            menu.append("\n---------------Characters-----------------\n");
            menu.append("1-Samurai (Damage: 5, Health: 21, Money: 15)\n");
            menu.append("2-Archer  (Damage: 7, Health: 18, Money: 20)\n");
            menu.append("3-Knight  (Damage: 8, Health: 24, Money: 5 )\n");
            menu.append("--------------------------------------------\n");
            menu.append("Select a character: ");

            System.out.print(menu.toString());
            int selection = scanner.nextInt();  // Read the player's selection from the console.

            // Create an instance of the selected character based on player's selection.
            switch (selection) {
                case 1:
                    this.character = new Samurai();
                    break selectCharacter;  // Exit the loop after selecting a character.
                case 2:
                    this.character = new Archer();
                    break selectCharacter;  // Exit the loop after selecting a character.
                case 3:
                    this.character = new Knight();
                    break selectCharacter;  // Exit the loop after selecting a character.
                default:
                    System.out.println("Invalid selection. Please try again."); // Display an error message.
                    break;
            }
        }
    }
}
