package array;

public class _73_SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {

        boolean findZeroInRow = false;
        boolean findZeroInColumn = false;

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                findZeroInRow = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                findZeroInColumn = true;
                break;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (findZeroInRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (findZeroInColumn) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    // Helper method to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        _73_SetMatrixZeroes solution = new _73_SetMatrixZeroes();

        // Test case 1
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        System.out.println("Before setZeroes:");
        _73_SetMatrixZeroes.printMatrix(matrix1);

        solution.setZeroes(matrix1);

        System.out.println("After setZeroes:");
        _73_SetMatrixZeroes.printMatrix(matrix1);

        // Test case 2
        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        System.out.println("Before setZeroes:");
        _73_SetMatrixZeroes.printMatrix(matrix2);

        solution.setZeroes(matrix2);

        System.out.println("After setZeroes:");
        _73_SetMatrixZeroes.printMatrix(matrix2);
    }

}
