import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create Scanner to read user input
        Scanner input = new Scanner(System.in);

        // Initialize variables
        String userName, password;
        int right = 3; // Number of login attempts allowed
        int balance = 1500; // Initial account balance
        int select;

        // Main login loop
        while (right > 0) {
            System.out.print("Kullanıcı Adınız :");

            // Read user's username
            userName = input.nextLine();
            System.out.print("Parolanız : ");

            // Read user's password
            password = input.nextLine();

            // Check if username and password are correct
            if (userName.equals("patika") && password.equals("dev123")) {
                System.out.println("Merhaba, Kodluyoruz Bankasına Hoşgeldiniz!");

                // Inner menu loop
                do {
                    // Display menu options
                    System.out.println("1-Para yatırma\n" +
                            "2-Para Çekme\n" +
                            "3-Bakiye Sorgula\n" +
                            "4-Çıkış Yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");

                    // Read user's choice
                    select = input.nextInt();

                    // Process selected action
                    switch (select) {
                        case 1:
                            // Deposit money
                            System.out.print("Para miktarı : ");
                            int price = input.nextInt();
                            balance += price;
                            break;
                        case 2:
                            // Withdraw money
                            System.out.print("Para miktarı : ");
                            int price = input.nextInt();
                            if (price > balance) {
                                System.out.println("Bakiye yetersiz.");
                            } else {
                                balance -= price;
                            }
                            break;
                        case 3:
                            // Check balance
                            System.out.println("Bakiyeniz : " + balance);
                            break;
                        case 4:
                            // Exit the program
                            System.out.println("Tekrar görüşmek üzere.");
                            break;
                        default:
                            // Invalid selection
                            System.out.println("Geçersiz bir seçim yaptınız.");
                            break;
                    }
                } while (select != 4); // Continue until user chooses to exit
                break;
            } else {
                // Incorrect username or password
                right--;
                System.out.println("Hatalı kullanıcı adı veya şifre. Tekrar deneyiniz.");

                if (right == 0) {
                    // Account blocked
                    System.out.println("Hesabınız bloke olmuştur lütfen banka ile iletişime geçiniz.");
                } else {
                    // Remaining login attempts
                    System.out.println("Kalan Hakkınız : " + right);
                }
            }
        }
    }
}
