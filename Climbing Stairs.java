/*
You are climbing a staircase. It takes n steps to reach the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
*/
class Solution {
    public int helper(int n, int i, int [] dp){
        if(i==n) return 1;
        if(i>n) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i] = helper(n, i+1,dp) + helper(n, i+2,dp);
        return dp[i];
    }
    public int climbStairs(int n) {
       int [] dp = new int[n+1];
       for(int i=0; i<=n; i++){
        dp[i] = -1;
       }
        return helper(n, 0, dp);
    }
}
