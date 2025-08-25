/*
Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
*/

class Solution {
    public int[] findDiagonalOrder(int[][] mat){
        if (mat == null || mat.length == 0) return new int[0];

        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m * n];
        int r = 0, c = 0;
        boolean upTraversal = true;

        for (int i = 0; i < res.length; i++) {
            res[i] = mat[r][c];

            // Move in up-right direction
            if (upTraversal) {
                if (c == n - 1) {      // Right border
                    r++;
                    upTraversal = false;
                } else if (r == 0) {   // Top border
                    c++;
                    upTraversal = false;
                } else {
                    r--;
                    c++;
                }
            } 
            // Move in down-left direction
            else {
                if (r == m - 1) {      // Bottom border
                    c++;
                    upTraversal = true;
                } else if (c == 0) {   // Left border
                    r++;
                    upTraversal = true;
                } else {
                    r++;
                    c--;
                }
            }
        }

        return res;
    }
}

