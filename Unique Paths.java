/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.
*/
//Recursive approach: This will result in TLE
class Solution {
    public int uniquePaths(int m, int n) {
        //Try to reach index [0,0] from the position [m-1,n-1]
        //Move allowed: left, up
        return recur(m-1, n-1);
    }

    public int recur(int m, int n){
        //Base case
        if(m <0 || n < 0) return 0;

        if(m==0 && n==0) return 1;
        int left = recur(m-1, n);
        int right = recur(m, n-1);

        return left + right;
    }
}

//Memoization 
class Solution {
    public int uniquePaths(int m, int n) {
        //Try to reach index [0,0] from the position [m-1,n-1]
        //Move allowed: left, up
        int [][]dp = new int[m+1][n+1];
        for(int i=0; i<=m; i++){
           for(int j=0; j<=n; j++){
                dp[i][j] = -1;
           }
        }
        return recur(m, n, dp);
    }

    public int recur(int m, int n,int [][] dp){
        //Base case
        if(m ==0 || n == 0){
            dp[m][n] = 0;
            return 0;
        }

        if(m==1 && n==1) {
            dp[m][n] = 1;
            return 1;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int left = recur(m-1, n, dp);
        int right = recur(m, n-1, dp);
        dp[m][n] = left + right;
        return dp[m][n];
    }
}

//Bottom up approach
class Solution {
    public int uniquePaths(int m, int n) {
        //Try to reach index [0,0] from the position [m-1,n-1]
        //Move allowed: left, up
        int [][]dp = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
                else if(i==1 && j==1){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }
}
