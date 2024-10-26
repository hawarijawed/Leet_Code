/*
You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.
*/
class Solution {
    public int helper(int [] cost, int n, int i,int[] dp){
        if(i==0) return cost[0];
        if(i==1) return cost[1];
        if(dp[i] != -1) return dp[i];
        dp[i] =  cost[i] + Math.min(helper(cost, n, i-1, dp), helper(cost, n, i-2, dp));
        return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int []dp = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }
        return Math.min(helper(cost, n, n-1, dp), helper(cost, n, n-2,dp));
    }
}
