package array;

import java.util.HashSet;

public class _36_Valid_Sudoku {

    private boolean isValidSudoku2(char[][] board) {

        HashSet<String> numbersFound = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                char currentEle = board[i][j];
                if (currentEle == '.') {
                    continue;
                }
                if (!numbersFound.add("row : "+ i+" "+currentEle)) {
                    return false;
                }
                if (!numbersFound.add("col : "+ j+" "+currentEle)) {
                    return false;
                }
                int boxIndex = (i / 3) * 3 + (j / 3);

                if (!numbersFound.add("box : "+ boxIndex+" "+currentEle)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidSudoku3(char[][] board) {

        HashSet<String> numbersFound = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                char currentEle = board[i][j];
                if (currentEle != '.') {
                    int boxIndex = (i / 3) * 3 + (j / 3);
                    if (!numbersFound.add("row : "+ i+" "+currentEle) ||
                            !numbersFound.add("col : "+ j+" "+currentEle) ||
                            !numbersFound.add("box : "+ boxIndex+" "+currentEle)) {
                        return false;
                    }
                }

            }
        }
        return true;
    }

    private boolean isValidSudoku(char[][] board) {

        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;

                int num = board[i][j] - '1'; // Convert '1'-'9' to 0-8
                int mask = 1 << num;         // Create bitmask for the number
                int boxIndex = (i / 3) * 3 + j / 3;

                // Check if the number is already set in the row, column, or box
                if ((rows[i] & mask) != 0 || (columns[j] & mask) != 0 || (boxes[boxIndex] & mask) != 0) {
                    return false;
                }

                // Mark the number in the row, column, and box
                rows[i] |= mask;
                columns[j] |= mask;
                boxes[boxIndex] |= mask;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        _36_Valid_Sudoku solution = new _36_Valid_Sudoku();

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '8', '6', '.', '.', '.', '3'},
                {'4', '.', '3', '4', '.', '8', '.', '5', '.'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '1'},
                {'.', '6', '.', '.', '.', '3', '9', '5', '8'},
                {'.', '9', '8', '5', '1', '.', '.', '.', '7'},
                {'.', '4', '.', '7', '3', '.', '.', '9', '.'}
        };

        boolean result = solution.isValidSudoku(board);
        System.out.println(result); // 输出 false，表示数独无效
    }


}
