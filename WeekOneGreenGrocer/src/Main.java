import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double POVERTY_PRICE = 2.14;
        double APPLE_PRICE = 3.67;
        double TOMATO_PRICE = 1.11;
        double BANANA_PRICE = 0.95;
        double EGGPLANT_PRICE = 5.00;


        Scanner scanner = new Scanner(System.in);

        // Ask from user input for kilo of poverty
        System.out.println("Kaç kilo armut istiyorsunuz: ");
        int povertyKilo = scanner.nextInt();

        // Ask from user input for kilo of apple
        System.out.println("Kaç kilo elma istiyorsunuz: ");
        int appleKilo = scanner.nextInt();

        // Ask from user input for kilo of tomato
        System.out.println("Kaç kilo domates istiyorsunuz: ");
        int tomatoKilo = scanner.nextInt();

        // Ask from user input for kilo of banana
        System.out.println("Kaç kilo muz istiyorsunuz: ");
        int bananaKilo = scanner.nextInt();

        // Ask from user input for kilo of eggplant
        System.out.println("Kaç kilo patlıcan istiyorsunuz: ");
        int eggplantKilo = scanner.nextInt();

        // Calculate the total price
        double totalPrice = (povertyKilo * POVERTY_PRICE) + (appleKilo * APPLE_PRICE) + (tomatoKilo * TOMATO_PRICE) + (bananaKilo * BANANA_PRICE) + (eggplantKilo * EGGPLANT_PRICE);

        // Print the total price
        System.out.println("Toplam tutar: " + totalPrice);
    }
}
