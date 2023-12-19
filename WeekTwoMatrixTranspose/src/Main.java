
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the rows of the matrix:");
        int rows = scanner.nextInt();
        System.out.println("Enter the columns of the matrix:");
        int columns = scanner.nextInt();

        // Declare the matrix here
        int[][] matrix = new int[rows][columns];

        // Read the matrix according to the format
        for (int i = 0; i < rows; i++) {
            System.out.println("Enter the elements of row " + (i + 1) + ":");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("The matrix is:");

        // Print the matrix here
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        // Declare the transpose matrix here
        int[][] transposeMatrix = new int[columns][rows];

        // get the transpose matrix
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                transposeMatrix[i][j] = matrix[j][i];
            }
        }

        // print the transpose matrix
        for (int[] row : transposeMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }

        scanner.close();

    }

}