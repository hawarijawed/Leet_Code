/*
You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.

Return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The testcases are generated so that the answer will be less than or equal to 2 * 109.
*/
//Optimized approach
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                else{
                    if(i>0){
                        dp[i][j] += dp[i-1][j];
                    }
                    if(j>0){
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }

        return dp[m-1][n-1];
    }
}

//Memoization approach
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return recur(m-1, n-1, obstacleGrid, dp);
    }

    public int recur(int i, int j, int[][] obstacleGrid, int[][] dp){
        //Index out of bound
        if(i<0 || j<0) return 0;
        //Obstacle appeared
        if(obstacleGrid[i][j] == 1) {
            dp[i][j] = 0;
            return 0;
        }
        //Reached to Starting Point
        if(i==0 && j==0) {
            dp[i][j] = 1;
            return 1;
        }    
        int case1 = recur(i-1, j, obstacleGrid, dp);
        int case2 = recur(i, j-1, obstacleGrid, dp);
        dp[i][j] = case1 + case2;
        return dp[i][j];
    }
}

//Recursive method
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        return recur(m-1, n-1, obstacleGrid);
    }

    public int recur(int i, int j, int[][] obstacleGrid){
        //Index out of bound
        if(i<0 || j<0) return 0;
        //Obstacle appeared
        if(obstacleGrid[i][j] == 1) return 0;
        //Reached to Starting Point
        if(i==0 && j==0) return 1;    
        int case1 = recur(i-1, j, obstacleGrid);
        int case2 = recur(i, j-1, obstacleGrid);
        return (case1 + case2);
    }
}
