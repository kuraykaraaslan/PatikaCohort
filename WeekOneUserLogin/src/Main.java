import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userName;
        String password, newPassword;

        // Get username
        System.out.print("Enter Username: ");
        userName = input.nextLine();

        // Get initial password
        System.out.print("Enter Password: ");
        password = input.nextLine();

        // Confirm password
        System.out.print("Confirm Password: ");
        String confirmPassword = input.nextLine();

        // Check if passwords match
        if (password.equals(confirmPassword)) {
            System.out.println("Password successfully created.");
        } else {
            // Offer options if passwords don't match
            System.out.println("Did you forget your password? Enter 1 to create a new one or 2 to exit.");
            int decide = input.nextInt();

            switch (decide) {
                case 1:
                    // Loop until a valid new password is created
                    do {
                        System.out.print("Create a New Password: ");
                        newPassword = input.next();

                        // Add password strength check if needed

                        // Check if the new password is the same as the initial one
                        if (newPassword.equals(password)) {
                            System.out.println("Password creation failed. Please try a different password.");
                        } else {
                            System.out.println("Password successfully created.");
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    // Exit the program
                    System.out.println("Exiting.");
                    break;
                default:
                    // Handle invalid option
                    System.out.println("Invalid option.");
            }
        }
    }
}
