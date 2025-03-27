/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==2){
            return Math.max(nums[0], nums[1]);
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);

        return recur(nums, n-1, dp);
    }

    public int recur(int [] nums, int n, int []dp){
        if(n == 0) return nums[0];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];

        int pick = nums[n] + recur(nums, n-2, dp);
        int no_pick = 0 + recur(nums, n-1, dp);
        dp[n] = Math.max(pick, no_pick);
        return dp[n];
    }
}

//Tabulation method
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2; i<=n; i++){
            int pick = nums[i-1] + dp[i-2];
            int no_pick = 0 + dp[i-1];
            dp[i] = Math.max(pick, no_pick);
        }
 
        return dp[n];
    }
}


//Space optimized
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        //int dp[] = new int[n+1];
        if(n==1) return nums[0];
        int prev0 = 0;
        int prev1 = nums[0];
        int ans = 0;
        for(int i=2; i<=n; i++){
            int pick = nums[i-1] + prev0;
            int no_pick = 0 + prev1;
            ans = Math.max(pick, no_pick);
            prev0 = prev1;
            prev1 = ans;
            
        }
 
        return ans;
    }
}
