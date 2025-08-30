/*
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Track seen digits: rows, columns, and boxes
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                int num = board[r][c] - '1';  // 0-based index for digits 1-9
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check if the digit already exists
                if (row[r][num] || col[c][num] || box[boxIndex][num]) {
                    return false;
                }

                // Mark the digit as seen
                row[r][num] = true;
                col[c][num] = true;
                box[boxIndex][num] = true;
            }
        }
        return true;
    }
}
