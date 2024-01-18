package org.tracker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static Map<String, Boolean> studentList = new HashMap<>();

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a new Scanner object to read user input
        // Check if a session file exists
        if (Files.exists(Paths.get("session.txt"))) {
            readFromSession(); // If the session file exists, read data from it
            scanner.close(); // Close the scanner
            return; // Exit the program
        } else {
            System.out.println("Session file does not exist. Input File Name:"); // Prompt the user to input a file name
            String fileName = scanner.nextLine(); // Read the file name from the user
            studentList = readFromTxt(fileName); // Read student list from the file
                                                 // a text file
        }
        System.out.println("Student List Loaded"); // Print a message indicating that the student list has been loaded

        // Infinite loop until interrupted
        while (true) {
            System.out.println("Press Enter to select a student or type 'exit' to exit"); // Prompt the user to press enter or type 'exit'
                                                                                          
            String input = scanner.nextLine(); // Wait for the user to press enter

            // Check if the user input is 'exit'
            if (input.equals("exit")) {
                System.out.println("Exiting..."); // Print a message indicating that the program is exiting
                System.exit(0); // Exit the program
            }

            String selectedStudent = getRandomUnselectedStudent(); // Get a random unselected student

            System.out.println("Selected Student: " + selectedStudent); // Print the selected student

            setStudentSelected(selectedStudent); // Mark the selected student as selected

            writeToSession(); // Write the selected student to the session file

            // Check if all students have been selected
            if (isEveryoneSelected()) {
                System.out.println("######################################");
                System.out.println("Everyone has been selected. Starting the next round");
                resetAllStudentsSelection(); // Reset the selection status of all students for the next round
            }
        }
    }

    // Method to get a random unselected student from the studentList
    public static String getRandomUnselectedStudent() {
        Random rand = new Random(); // Create a new Random object

        List<String> unselectedStudents = new ArrayList<>(); // Create a new ArrayList to hold the unselected students

        // Iterate over the studentList
        for (Map.Entry<String, Boolean> entry : studentList.entrySet()) {
            // Check if the student is unselected (value is false)
            if (!entry.getValue()) {
                unselectedStudents.add(entry.getKey()); // Add the unselected student to the unselectedStudents list
            }
        }

        // Check if there are no unselected students left
        if (unselectedStudents.isEmpty()) {
            return null; // Return null to indicate that there are no unselected students left
        }

        // Generate a random index based on the number of unselected students
        int index = rand.nextInt(unselectedStudents.size());

        // Return the selected unselected student at the generated index
        return unselectedStudents.get(index);
    }

    // Method to read data from a text file and return it as a Map of student names
    // and selection status
    public static Map<String, Boolean> readFromTxt(String fileName) {
        Path filePath = Paths.get(fileName); // Create a Path object from the given fileName
        Map<String, Boolean> studentMap = new HashMap<>(); // Create a new HashMap to store the student names and their
                                                           // selection status

        try (BufferedReader reader = Files.newBufferedReader(filePath)) { // Open a BufferedReader to read from the file
            String readLine; // Variable to store each line read from the file
            int line = 0; // Variable to keep track of the current line number

            // Read each line of the file until reaching the end (readLine will be null)
            while ((readLine = reader.readLine()) != null) {
                // Check if the line number is odd (starting from 1), indicating a student name
                if (line % 2 != 0) {
                    studentMap.put(readLine, false); // Add the student name to the studentMap with a default selection
                                                     // status of false
                }
                line++; // Increment the line number
            }
        } catch (IOException e) {
            throw new RuntimeException(e); // Throw a RuntimeException if an IOException occurs while reading the file
        }

        return studentMap; // Return the studentMap containing the student names and their selection status
    }

    // Method to write data to the session file
    public static void writeToSession() {
        try {
            Files.deleteIfExists(Paths.get("session.txt")); // Delete the session file if it exists
        } catch (IOException e) {
            e.printStackTrace(); // Print the stack trace if an IOException occurs while deleting the file
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get("session.txt"))) { // Open a BufferedWriter to
                                                                                          // write to the session file
            // Iterate over each entry in the studentList
            for (Map.Entry<String, Boolean> entry : studentList.entrySet()) {
                String studentName = entry.getKey(); // Get the student name
                Boolean isSelected = entry.getValue(); // Get the selection status

                writer.write(studentName + ":" + isSelected); // Write the student name and selection status to the file
                writer.newLine(); // Write a new line character to separate each student
            }
        } catch (IOException ex) {
            ex.printStackTrace(); // Print the stack trace if an IOException occurs while writing to the file
        }
    }

    public static void readFromSession() {
        // Creating a Path object to specify the file location
        Path filePath = Paths.get("session.txt");

        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String readLine;

            // Reading each line from the file until null is returned
            while ((readLine = reader.readLine()) != null) {
                // Splitting each line by ":" to separate the student name and their selection
                // status
                String[] exploded = readLine.split(":");
                String studentName = exploded[0];
                Boolean isSelected = Boolean.parseBoolean(exploded[1]);

                // Adding the extracted student name and selection status to the "studentList"
                // map
                studentList.put(studentName, isSelected);
            }
        } catch (IOException e) {
            // Throwing a runtime exception if any IO error occurs
            throw new RuntimeException(e);
        }
    }

    public static void setStudentSelected(String studentName) {
        // Setting the selection status of the specified student name to true in the
        // "studentList" map
        studentList.put(studentName, true);
    }

    public static void resetAllStudentsSelection() {
        // Iterating over each entry in the "studentList" map
        for (Map.Entry<String, Boolean> entry : studentList.entrySet()) {
            // Setting the selection status of each student to false
            entry.setValue(false);
        }
    }

    public static boolean isEveryoneSelected() {
        // Checking if there is any student in the "studentList" map whose selection
        // status is false
        for (Boolean isSelected : studentList.values()) {
            if (!isSelected) {
                // If a student is found whose selection status is false, returning false
                return false;
            }
        }
        // Returning true if all students have their selection status set as true
        return true;
    }

}
