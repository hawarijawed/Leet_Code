/******************************************************************************
An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. 
These characters divide the square into contiguous regions.

Given the grid grid represented as a string array, return the number of regions.

Note that backslash characters are escaped, so a '\' is represented as '\\'.

*******************************************************************************/

class Solution {
    int rows;
    int cols;  
    int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
    public void dfs(int row, int col, int[][]matrix){
        if(row<0||row>=rows ||col<0 ||col>=cols||matrix[row][col]==1){
            return;
        }

        matrix[row][col] = 1;
        for(int i=0; i<4;i++){
            dfs(row+dir[i][0], col+dir[i][1],matrix);
        }
    }
    public int regionsBySlashes(String[] grid) {
        int size = grid.length;
        rows = size*3;
        cols = size*3;
        int matrix[][] = new int[size*3][size*3];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                int row = i*3;
                int col = j*3;
                if(grid[i].charAt(j)=='/'){
                    matrix[row][col+2]=1;
                    matrix[row+1][col+1]=1;
                    matrix[row+2][col]=1;
                }
                else if(grid[i].charAt(j)=='\\'){
                    matrix[row][col]=1;
                    matrix[row+1][col+1]=1;
                    matrix[row+2][col+2]=1;
                }
            }
        }

        //Finding number of components
        int count = 0;
        for(int i=0; i<size*3;i++){
            for(int j=0; j<size*3;j++){
                if(matrix[i][j]==0){
                    dfs(i,j,matrix);
                    count++;
                }
            }
        }
        return count;
    }
}