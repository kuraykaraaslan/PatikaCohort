import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Ask from user input for Weather Temperature
        System.out.println("Hava sıcaklığını giriniz: ");
        int weatherTemperature = scanner.nextInt();

        // Suggestion for suitable sports, according to weather temperature
        if (weatherTemperature < 5) {
            System.out.println("Kayak yapabilirsiniz.");
        } else if (weatherTemperature >= 5 && weatherTemperature < 15) {
            System.out.println("Sinemaya gidebilirsiniz.");
        } else if (weatherTemperature >= 15 && weatherTemperature < 25) {
            System.out.println("Pikniğe gidebilirsiniz.");
        } else {
            System.out.println("Yüzmeye gidebilirsiniz.");
        }


    }

}