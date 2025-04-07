/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
*/
class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        if(sum %2 != 0){
            return false;
        }
        
        int target = sum/2;
        boolean [] dp = new boolean[target+1];
        dp[0] = true;
        for(int i=0; i<nums.length; i++){
            for(int j=target; j>= nums[i]; j--){
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
