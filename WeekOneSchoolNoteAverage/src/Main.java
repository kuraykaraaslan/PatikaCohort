import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // Ask from user input for Matematik, Fizik, Kimya, Türkçe, Tarih, Müzik
        // Create Scanner object
        Scanner scanner = new Scanner(System.in);

        // Ask from user input for Matematik
        System.out.println("Matematik notunuzu giriniz: ");
        int matematik = scanner.nextInt();

        // Ask from user input for Fizik
        System.out.println("Fizik notunuzu giriniz: ");
        int fizik = scanner.nextInt();

        // Ask from user input for Kimya
        System.out.println("Kimya notunuzu giriniz: ");
        int kimya = scanner.nextInt();

        // Ask from user input for Türkçe
        System.out.println("Türkçe notunuzu giriniz: ");
        int turkce = scanner.nextInt();

        // Ask from user input for Tarih
        System.out.println("Tarih notunuzu giriniz: ");
        int tarih = scanner.nextInt();

        // Ask from user input for Müzik
        System.out.println("Müzik notunuzu giriniz: ");
        int muzik = scanner.nextInt();

        // Calculate the average
        double average = (matematik + fizik + kimya + turkce + tarih + muzik) / 6.0;

        // Print the average
        System.out.println("Ortalamanız: " + average);

        // Check if the average is greater than 60
        boolean isAverageGreaterThan60 = average > 60;

        // Print the result
        System.out.println("Sınıfı geçme durumunuz: " + (isAverageGreaterThan60 ? "Sınıfı Geçti" : "Sınıfta Kaldı"));

    }

}