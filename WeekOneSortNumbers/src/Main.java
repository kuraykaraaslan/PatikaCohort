import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Ask from user input for three numbers
        Scanner scanner = new Scanner(System.in);
        System.out.println("Birinci sayıyı giriniz: ");
        int firstNumber = scanner.nextInt();
        System.out.println("İkinci sayıyı giriniz: ");
        int secondNumber = scanner.nextInt();
        System.out.println("Üçüncü sayıyı giriniz: ");
        int thirdNumber = scanner.nextInt();

        if (firstNumber >= secondNumber && firstNumber >= thirdNumber) {
            if (secondNumber >= thirdNumber) {
                System.out.println("firstNumber >= secondNumber >= thirdNumber");
            } else {
                System.out.println("firstNumber >= thirdNumber >= secondNumber");
            }
        } else if (secondNumber >= firstNumber && secondNumber >= thirdNumber) {
            if (firstNumber >= thirdNumber) {
                System.out.println("secondNumber >= firstNumber >= thirdNumber");
            } else {
                System.out.println("secondNumber >= thirdNumber >= firstNumber");
            }
        } else {
            if (firstNumber >= secondNumber) {
                System.out.println("thirdNumber >= firstNumber >= secondNumber");
            } else {
                System.out.println("thirdNumber >= secondNumber >= firstNumber");
            }
        }
    }

}

