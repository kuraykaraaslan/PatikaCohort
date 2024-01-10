import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;

public class Main {
    public static void main(String[] args) {
        // Specify the file path
        String file = "example.txt";

        // Initialize the total variable
        int total = 0;


        // Try to read the file
        try {
            // Create a new FileReader
            FileReader fileReader = new FileReader(file);

            // Create a new BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Initialize the line variable
            String line;

            // Read the file line by line
            while ((line = bufferedReader.readLine()) != null) {
                // Convert the line to an integer
                int number = Integer.parseInt(line);

                // Add the number to the total
                total += number;
            }

            // Close the BufferedReader
            bufferedReader.close();
        } catch (IOException e) {
            // Print the error message
            System.out.println("Error: " + e.getMessage());

            // Exit the program

        }
    }
}