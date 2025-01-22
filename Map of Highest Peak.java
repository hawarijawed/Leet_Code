/*
You are given an integer matrix isWater of size m x n that represents a map of land and water cells.

If isWater[i][j] == 0, cell (i, j) is a land cell.
If isWater[i][j] == 1, cell (i, j) is a water cell.
You must assign each cell a height in a way that follows these rules:

The height of each cell must be non-negative.
If the cell is a water cell, its height must be 0.
Any two adjacent cells must have an absolute height difference of at most 1. A cell is adjacent to another cell if the former is directly north, east, south, or west of the latter (i.e., their sides are touching).
Find an assignment of heights such that the maximum height in the matrix is maximized.

Return an integer matrix height of size m x n where height[i][j] is cell (i, j)'s height. If there are multiple solutions, return any of them.
*/
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int dir[][] = {{-1,0},{0, 1},{1, 0}, {0, -1}};
        int n = isWater.length;
        int m = isWater[0].length;
        int res[][] = new int[n][m];
        Queue<int []> queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(isWater[i][j] == 1){
                    res[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
                else{
                    res[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()){
            int cell[] = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int h = res[r][c];
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(nr>=0 && nr<n
                && nc>=0 && nc<m
                && res[nr][nc] == -1){
                    res[nr][nc] = h + 1;
                    queue.offer(new int[] {nr, nc});
                }
            }
        }
        return res;
    }
}
