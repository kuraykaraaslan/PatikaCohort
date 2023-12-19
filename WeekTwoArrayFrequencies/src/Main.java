import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 20, 20, 10, 10, 20, 5, 20};

        // Sort the array to group identical elements together
        Arrays.sort(array);

        // Create a 2D array to store element values and their frequencies
        // The first column stores element values, and the second column stores frequencies
        int[][] frequencies = new int[array.length][2];

        int count = 0; // Counter for the number of unique elements

        // Calculate frequencies
        for (int i = 0; i < array.length; i++) {
            // If it's the first occurrence of the element
            if (i == 0 || array[i] != array[i - 1]) {
                frequencies[count][0] = array[i]; // Store the element value
                frequencies[count][1]++; // Increment the frequency
                count++;
            } else {
                frequencies[count - 1][1]++; // Increment the frequency for an existing element
            }
        }

        // Print the frequencies
        for (int i = 0; i < count; i++) {
            if (frequencies[i][1] > 0) {
                System.out.println(frequencies[i][0] + " occurs " + frequencies[i][1] + " time(s)");
            }

        }
    }
}
