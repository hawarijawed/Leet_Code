/*
You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with any other server.
*/
class Solution {
    public int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[] rowCount = new int[row];
        int[] colCount = new int[col];
        int count = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    rowCount[i]++;
                    colCount[j]++;
                    count++;
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    if(rowCount[i] == 1 && colCount[j] == 1){
                        count--;
                    }
                }
            }
        }

        return count;
    }
}
