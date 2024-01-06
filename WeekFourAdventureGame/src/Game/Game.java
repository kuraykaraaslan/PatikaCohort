package Game;

import Entity.Player.Player;
import Location.BattleLocation.*;
import Location.SafeLocation.*;

import java.util.Scanner;
import java.lang.StringBuilder;

public class Game {
    public Scanner scanner = new Scanner(System.in);
    public Player player;
    public Forest forest;
    public Cave cave;
    public River river;
    public Mine mine;
    public SafeHouse safeHouse;
    public Workshop workshop;

    public void start() {
        buildPlayer();
        this.forest = new Forest(this.player); // Create a new instance of the Forest location passing the player object
        this.cave = new Cave(this.player); // Create a new instance of the Cave location passing the player object
        this.river = new River(this.player); // Create a new instance of the River location passing the player object
        this.mine = new Mine(this.player); // Create a new instance of the Mine location passing the player object
        this.safeHouse = new SafeHouse(this.player); // Create a new instance of the SafeHouse location passing the player object
        this.workshop = new Workshop(this.player); // Create a new instance of the Workshop location passing the player object
        mainMenu(); // Call the mainMenu method
    }

    public void buildPlayer() {
        System.out.print("Enter a nickname: "); // Print message to the console
        String nickName = scanner.nextLine(); // Read user input for the player's name
        player = new Player(nickName); // Create a new Player object and assign it to the player variable
    }

    public void mainMenu() {
        while (true) {
            if (player.getCharacter().getHealth() == 0) {
                System.out.println("\nYou Died!"); // Print message if player's health is 0
                break;
            } else if (player.hasFireWood && player.hasFood && player.hasWater) {
                System.out.println("\nYou Won! Congratulations!"); // Print message if player has all the items
                break;
            }
            StringBuilder menu = new StringBuilder(); // Create a StringBuilder object for the menu
            menu.append("\n---------------------------Main Menu-----------------------------\n");
            menu.append("1-Cave          Zombies Inside. Kill Them to Get the Food!\n");
            menu.append("2-Forest        Vampires Inside. Kill Them to Get the Firewood!\n");
            menu.append("3-River         Bears Inside. Kill Them to Get the Water!\n");
            menu.append("4-Mine          Snakes Inside. Kill Them to Get the Loot!\n");
            menu.append("5-Workshop      Buy Weapon and Armor\n");
            menu.append("6-Safe House    Rest to Restore Your Health\n");
            menu.append("7-Inventory     Look Inventory\n");
            menu.append("-----------------------------------------------------------------\n");
            menu.append("Make a selection: ");

            System.out.print(menu.toString()); // Print the main menu options
            String selectNum = (scanner.next()).toLowerCase(); // Read user input for the selected option and convert to lowercase
            switch (selectNum) { // Check the selected option
                case "1" -> cave.enter(); // Call the enter method of the Cave location
                case "2" -> forest.enter(); // Call the enter method of the Forest location
                case "3" -> river.enter(); // Call the enter method of the River location
                case "4" -> mine.enter(); // Call the enter method of the Mine location
                case "5" -> workshop.enter(); // Call the enter method of the Workshop location
                case "6" -> safeHouse.enter(); // Call the enter method of the SafeHouse location
                case "7" -> inventory(); // Call the inventory method
                default -> System.out.println("Invalid selection. Please try again."); // Display an error message
            }
        }
    }

    public void inventory() {
        scanner.nextLine(); // Consume the leftover newline character from the input buffer

        StringBuilder inventory = new StringBuilder(); // Create a StringBuilder object for the inventory
        inventory.append("\n----------------Inventory----------------\n");
        inventory.append("Food: ").append(player.hasFood ? "1" : "0").append("\n"); // Check if player has food and append the appropriate value
        inventory.append("FireWood: ").append(player.hasFireWood ? "1" : "0").append("\n"); // Check if player has firewood and append the appropriate value
        inventory.append("Water: ").append(player.hasWater ? "1" : "0").append("\n"); // Check if player has water and append the appropriate value
        inventory.append("Weapon: ").append((player.getCharacter().getWeapon() == null) ? "Empty" : player.getCharacter().getWeapon().getName()).append("\n"); // Check if player has a weapon and append its name
        inventory.append("Armor: ").append((player.getCharacter().getArmor() == null) ? "Empty" : player.getCharacter().getArmor().getName()).append("\n");
        inventory.append("Balance: ").append(player.getCharacter().getMoney()).append("\n"); // Append the player's money balance
        inventory.append("-----------------------------------------\n");
        inventory.append("Press Enter to Quit");

        System.out.print(inventory.toString()); // Print the inventory details
        scanner.nextLine(); // Wait for user to press enter to continue
    }

}