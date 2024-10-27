/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
*/
class Solution {
    public int countSquares(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int [][] mat = new int[row][col];
        for(int i=0; i<row;i++){
            mat[i][0] = matrix[i][0];
        }
        for(int i=0; i<col; i++){
            mat[0][i] = matrix[0][i];
        }

        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(matrix[i][j] == 0){
                    mat[i][j] = 0;
                    continue;
                }
                int temp = Math.min(mat[i][j-1], mat[i-1][j]);
                temp = Math.min(temp, mat[i-1][j-1]);
                mat[i][j] = temp+1;
            }
        }

        int count = 0;
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                count += mat[i][j];
            }
        }
        return count;
    }
}
