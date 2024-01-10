import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String defaultRestoreFileName = "restore.txt";
        String oldFileName = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        // Using Scanner to get text input from the user
        try {
            // Check if restore.txt file exists
            File restoredFile = new File(defaultRestoreFileName);

            if (restoredFile.exists()) {
                // Read the file name from restore.txt
                fileReader = new FileReader(restoredFile);
                bufferedReader = new BufferedReader(fileReader);
                oldFileName = bufferedReader.readLine();

                // Print the content of the old file and ask the user for new input
                if (oldFileName != null) {
                    File oldFile = new File(oldFileName);
                    if (oldFile.exists()) {
                        System.out.println("Content of the old file (" + oldFileName + "):");
                        try (BufferedReader oldFileReader = new BufferedReader(new FileReader(oldFile))) {
                            String line;
                            while ((line = oldFileReader.readLine()) != null) {
                                System.out.println(line);
                            }
                        }
                        System.out.println("-------------------------------------");
                        System.out.println("Enter some additional text to append to the file: " + oldFileName);
                    } else {
                        System.out.println("Old file (" + oldFileName + ") does not exist.");
                    }
                }
            }

            // Ask the user for new text
            if (oldFileName == null) {
                System.out.println("Enter some text to save to a new file: ");
            }
            String newText = scanner.nextLine();

            // Use the old file if available, otherwise ask for a new file name
            String fileName;
            if (oldFileName != null) {
                fileName = oldFileName;
            } else {
                System.out.print("Enter file name: ");
                fileName = scanner.nextLine() + ".txt";
            }

            // Append the new text to the file
            try (PrintWriter fileWriter = new PrintWriter(new FileWriter(fileName, true))) {
                fileWriter.println(newText);
                System.out.println("Text appended to file: " + fileName);
            } catch (IOException e) {
                System.out.println("Error writing to the file: " + e.getMessage());
            }

            // Update the restore.txt file with the current file name
            try (PrintWriter restoreWriter = new PrintWriter(defaultRestoreFileName)) {
                restoreWriter.println(fileName);
            } catch (IOException e) {
                System.out.println("Error writing to restore.txt: " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            // Close the scanner and file resources to avoid leaks
            scanner.close();
            try {
                if (bufferedReader != null) bufferedReader.close();
                if (fileReader != null) fileReader.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
