import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask for user input for edges of the triangle
        System.out.println("Üçgenin birinci kenarını giriniz: ");
        int edge1 = scanner.nextInt();

        System.out.println("Üçgenin ikinci kenarını giriniz: ");
        int edge2 = scanner.nextInt();

        System.out.println("Üçgenin üçüncü kenarını giriniz: ");
        int edge3 = scanner.nextInt();

        // Calculate the perimeter
        double u = (edge1 + edge2 + edge3) / 2.0;

        // Calculate the area
        double area = Math.sqrt(u * (u - edge1) * (u - edge2) * (u - edge3));

        // Print the area
        System.out.println("Üçgenin alanı: " + area);

    }

}

