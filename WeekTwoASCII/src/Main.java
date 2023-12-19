public class Main {
    public static void main(String[] args) {
        int[][] letterA = new int[6][6]; // 0 for empty, 1 for *

        // 0 for empty, 1 for *

        letterA = new int[][] {
                { 0, 0, 1, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 0 },
                { 1, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1 },
        public class Main {
            public static void main(String[] args) {
                int[][] letterA = new int[6][6]; // 2D array to represent letter A, initialized with 0s (empty spaces)

                // Initializing letterA with a predefined pattern
                letterA = new int[][] {
                        { 0, 0, 1, 1, 0, 0 },
                        { 0, 1, 0, 0, 1, 0 },
                        { 1, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 0, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 0, 1 }
                };


                int[][] letterB = new int[6][6]; // 2D array to represent letter B, initialized with 0s (empty spaces)

                // Initializing letterB with a predefined pattern
                letterB = new int[][] {
                        { 1, 1, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 0 },
                        { 1, 0, 0, 0, 0, 1 },
                        { 1, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 0 }
                };

                printLetter(letterB); // Call the printLetter function and pass the letterB array

            }

            // Function to print a letter represented by a 2D array
            public static void printLetter(int[][] letter) {
                for (int i = 0; i < letter.length; i++) { // Iterate over rows
                    for (int j = 0; j < letter[i].length; j++) { // Iterate over columns
                        if (letter[i][j] == 1) {
                            System.out.print("*"); // Print '*' if the element is 1
                        } else {
                            System.out.print(" "); // Print a space if the element is 0
                        }
                    }
                    System.out.println(); // Move to the next line after each row is printed
                }
            }

        }
