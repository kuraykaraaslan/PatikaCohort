
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Define a 10-element array
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Prompt user for index input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an index (0-9): ");
        int index = scanner.nextInt();

        try {
            // Call the method to retrieve the element at the specified index
            int result = retrieveElementAtIndex(array, index);
            System.out.println("Element at the specified index: " + result);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle the error by printing an error message
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to retrieve the element at the specified index
    public static int retrieveElementAtIndex(int[] array, int index) {
        // Attempt to retrieve the element at the specified index
        return array[index];
    }
}