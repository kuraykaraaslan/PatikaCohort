import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask for the Price without KDV
        System.out.println("KDV'siz Fiyatı Giriniz: ");
        double priceWithoutKDV = scanner.nextDouble();

        // if the price is less than 1000, KDV is 18%
        // if the price is greater than or equal to 1000, KDV is 8%
        double kdv = priceWithoutKDV > 1000 ? 0.08 : 0.18;

        // Calculate the KDV
        double kdvAmount = priceWithoutKDV * kdv;

        // Calculate the price with KDV
        double priceWithKDV = priceWithoutKDV + kdvAmount;

        // Print the price with KDV
        System.out.println("KDV'li Fiyat: " + priceWithKDV);

        // Print the KDV amount
        System.out.println("KDV tutarı: " + kdvAmount);

        // Print the KDV rate
        System.out.println("KDV oranı: " + kdv);

    }

}


