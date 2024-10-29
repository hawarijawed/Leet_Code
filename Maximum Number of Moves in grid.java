/*
You are given a 0-indexed m x n matrix grid consisting of positive integers.

You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.
Return the maximum number of moves that you can perform.
*/
class Solution {
    public int dfs(int[][]mat,int[][]grid, int row, int col) {
        // If we've already computed the result for this cell, return it
        if (mat[row][col] != -1) {
            return mat[row][col];
        }
        int m = grid.length;
        int n = grid[0].length;
        int maxMoves = 0;
        // Explore the three possible moves
        for (int newRow = row - 1; newRow <= row + 1; newRow++) {
            if (newRow >= 0 && newRow < m && col + 1 < n) {
                if (grid[newRow][col + 1] > grid[row][col]) {
                    maxMoves = Math.max(maxMoves, 1 + dfs(mat, grid,newRow, col + 1));
                }
            }
        }

        // Store the result in the memoization array
        mat[row][col] = maxMoves;
        return maxMoves;
    }
    public int maxMoves(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int mat[][] = new int[row][col];
        for(int i=0;i<row; i++){
            for(int j=0; j<col; j++){
                mat[i][j] = -1;
            }
        }
        int res = 0;
        for(int i=0; i<row; i++){
            res  = Math.max(res, dfs(mat, grid, i, 0));
        }

        return res;
    }
}
