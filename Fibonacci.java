/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).
*/
class Solution {
    public int helper(int n, int []dp){
        if(n==0 || n==1) return n;
        if(dp[n] != -1) return dp[n];
        dp[n] = helper(n-1, dp) + helper(n-2, dp);
        return dp[n];
    }
    public int fib(int n) {
        int []dp = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }

        return helper(n, dp);
    }
}
