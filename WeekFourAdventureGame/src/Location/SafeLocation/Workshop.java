package Location.SafeLocation;

import Entity.Player.Player;
import Location.Location;
import Tool.Tool;
import Tool.Armor.*;
import Tool.Weapon.*;
import java.lang.StringBuilder;

import java.util.Scanner;

public class Workshop extends Location {
    private final Scanner scanner = new Scanner(System.in);
    Player player;
    Armor lightArmor, mediumArmor, heavyArmor;
    Weapon pistol, rifle, sword;

    public Workshop(Player player) {
        this.player = player;
        pistol = new Pistol();
        rifle = new Rifle();
        sword = new Sword();
        lightArmor = new LightArmor();
        mediumArmor = new MediumArmor();
        heavyArmor = new HeavyArmor();
    }

    @Override
    public void enter() {
        toolMenu();
    }

    // Method to display the workshop menu
    public void toolMenu() {
        String select;
        toolMenu: while (true) {
            // Optimize the code for displaying the workshop menu
            StringBuilder menuBuilder = new StringBuilder();

            // Build the menu with options
            menuBuilder.append("\n--------------Workshop Menu--------------")
                    .append("\n1-Weapons")
                    .append("\n2-Armors")
                    .append("\nQ-Quit\n")
                    .append("-----------------------------------------")
                    .append("\nSELECT: ");

            System.out.print(menuBuilder.toString());

            // Get user input
            select = (scanner.next()).toLowerCase();
            switch (select) {
                case "1":
                    weaponMenu(); // Call the weapon menu
                    break;
                case "2":
                    armorMenu(); // Call the armor menu
                    break;
                case "q":
                    break toolMenu; // Exit the workshop menu loop
                default:
                    System.out.println("Enter Valid Number!"); // Invalid input
                    break;
            }
        }
    }

    // Method to display the weapon menu
    public void weaponMenu() {
        StringBuilder menuBuilder = new StringBuilder();
        menuBuilder.append("\nBalance: ")
                .append(player.getCharacter().getMoney())
                .append("\n---------------Weapon Menu---------------")
                .append("\n1-Pistol (Damage: 2, Price: 25)")
                .append("\n2-Sword  (Damage: 3, Price: 35)")
                .append("\n3-Rifle  (Damage: 7, Price: 45)")
                .append("\nQ-Back")
                .append("\n-----------------------------------------");

        System.out.println(menuBuilder.toString());
        String select;
        select: while (true) {
            System.out.print("SELECT: ");
            select = (scanner.next()).toLowerCase();
            switch (select) {
                case "1":
                    if (buyTool(pistol)) { // Buy the selected tool (pistol)
                        player.getCharacter().setWeapon(pistol);
                        break select; // Exit the weapon menu loop
                    } else
                        break;
                case "2":
                    if (buyTool(sword)) { // Buy the selected tool (sword)
                        player.getCharacter().setWeapon(sword);
                        break select; // Exit the weapon menu loop
                    } else
                        break;
                case "3":
                    if (buyTool(rifle)) { // Buy the selected tool (rifle)
                        player.getCharacter().setWeapon(rifle);
                        break select; // Exit the weapon menu loop
                    } else
                        break;
                case "q":
                    break select; // Exit the weapon menu loop
                default:
                    System.out.println("INVALID NUMBER!"); // Invalid input
                    break;
            }
        }
    }

    // Method to display the armor menu
    public void armorMenu() {
        StringBuilder menuBuilder = new StringBuilder();

        menuBuilder.append("\nBalance: ").append(player.getCharacter().getMoney())
                .append("\n---------------Armor Menu----------------")
                .append("\n1-Light Armor  (Protection: 1, Price: 15)")
                .append("\n2-Medium Armor (Protection: 3, Price: 25)")
                .append("\n3-Heavy Armor  (Protection: 5, Price: 40)")
                .append("\nQ-Back")
                .append("\n-----------------------------------------");

        System.out.println(menuBuilder.toString());
        String select;
        select: while (true) {
            System.out.print("SELECT: ");
            select = (scanner.next()).toLowerCase();
            switch (select) {
                case "1":
                    if (buyTool(lightArmor)) { // Buy the selected tool (light armor)
                        player.getCharacter().setArmor(lightArmor);
                        break select; // Exit the armor menu loop
                    } else
                        break;
                case "2":
                    if (buyTool(mediumArmor)) { // Buy the selected tool (medium armor)
                        player.getCharacter().setArmor(mediumArmor);
                        break select; // Exit the armor menu loop
                    } else
                        break;
                case "3":
                    if (buyTool(heavyArmor)) {
                        player.getCharacter().setArmor(heavyArmor);
                        break select; // Exit the armor menu loop
                    } else
                        break;
                case "q":
                    break select; // Exit the armor menu loop
                default:
                    System.out.println("Please Enter Valid Number!"); // Invalid input
                    break;
            }
        }
    }

    // Method to buy a tool (weapon or armor)
    public boolean buyTool(Tool tool) {
        if (player.getCharacter().getMoney() >= tool.getPrice()) { // Check if the player has enough money
            player.getCharacter().setMoney(player.getCharacter().getMoney() - tool.getPrice()); // Subtract the price of
                                                                                                // the tool from the
                                                                                                // player's money
            System.out.println("You Bought " + tool.getName() + "!"); // Notify the player that they bought the tool
            return true;
        } else {
            System.out.println("Your Balance is Not Enough!"); // Notify the player that they don't have enough money
            return false;
        }
    }
}