import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a Scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a text
        System.out.println("Enter a text:");
        String text = scanner.nextLine();

        // Split the text into words using the split method
        String[] words = text.split("\\s+");

        // Use a HashMap to count the occurrences of each word
        Map<String, Integer> wordCountMap = new HashMap<>();

        for (String word : words) {
            // Convert the word to lowercase to make the counting case-insensitive
            String lowercaseWord = word.toLowerCase();

            // If the word is already in the map, increment its count; otherwise, add it with count 1
            wordCountMap.put(lowercaseWord, wordCountMap.getOrDefault(lowercaseWord, 0) + 1);
        }

        // Find the most frequent word
        String mostFrequentWord = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }

        // Display the result
        if (mostFrequentWord != null) {
            System.out.println("Most frequent word: " + mostFrequentWord + " (Count: " + maxCount + ")");
        } else {
            System.out.println("No words found in the input.");
        }
    }
}
