import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Ask from user input for diameter of the circle
        System.out.println("Dairenin yarıçapını giriniz: ");
        int radius = scanner.nextInt();

        // Calculate the area of the circle
        double area = 3.14 * radius * radius;
        // Calculate the perimeter of the circle
        double perimeter = 2 * 3.14 * radius;

        // Print the area and perimeter of the circle
        System.out.println("Dairenin alanı: " + area);
        System.out.println("Dairenin çevresi: " + perimeter);
    }
}
