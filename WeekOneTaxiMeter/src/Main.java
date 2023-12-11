import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Ask from user input for how many kilometers taxi went
        System.out.println("Kaç kilometre yol gittiniz: ");
        Scanner scanner = new Scanner(System.in);

        int km = scanner.nextInt();

        // Minimum price is 20 TL
        // Price per kilometer is 2.20 TL
        double total = 10 + (km * 2.20);

        // If total is less than 20 TL, then total is 20 TL
        total = total < 20 ? 20 : total;

        // Print the total
        System.out.println("Toplam tutar: " + total);

    }

}