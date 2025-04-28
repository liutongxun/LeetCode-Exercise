package array;

public class _48_Rotate_Image {

    public void rotate2(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1 ; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            int left = 0;
            int right = matrix.length - 1;

            while (left < right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0 ; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }

        }
    }

    public static void main(String[] args) {
        _48_Rotate_Image solution = new _48_Rotate_Image();

        // 测试1：标准 3x3 矩阵
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Test 1 (Before rotation):");
        printMatrix(matrix1);
        solution.rotate(matrix1);
        System.out.println("Test 1 (After rotation):");
        printMatrix(matrix1);  // 应该输出 旋转90度后的矩阵

        // 测试2：边界情况，1x1 矩阵
        int[][] matrix2 = {
                {1}
        };

        System.out.println("Test 2 (Before rotation):");
        printMatrix(matrix2);
        solution.rotate(matrix2);
        System.out.println("Test 2 (After rotation):");
        printMatrix(matrix2);  // 应该输出 旋转后还是 {1}

        // 测试3：4x4 矩阵
        int[][] matrix3 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        System.out.println("Test 3 (Before rotation):");
        printMatrix(matrix3);
        solution.rotate(matrix3);
        System.out.println("Test 3 (After rotation):");
        printMatrix(matrix3);  // 应该输出 旋转90度后的矩阵

        // 测试4：5x5 矩阵
        int[][] matrix4 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        System.out.println("Test 4 (Before rotation):");
        printMatrix(matrix4);
        solution.rotate(matrix4);
        System.out.println("Test 4 (After rotation):");
        printMatrix(matrix4);  // 应该输出 旋转90度后的矩阵
    }

    // 打印矩阵的辅助函数
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
