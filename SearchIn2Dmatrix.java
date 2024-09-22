/*
You are given an m x n integer matrix matrix with the following two properties:
Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        // Start from the top right corner of the matrix
    int i = 0;
    int j = col - 1;

    while (i < row && j >= 0) {
        if (matrix[i][j] == target) {
            return true; // Target found
        } else if (matrix[i][j] > target) {
            j--; // Move left
        } else {
            i++; // Move down
        }
    }

    return false; // Target not found
    }
}
