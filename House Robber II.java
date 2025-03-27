/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
*/
class Solution {
    public int robber(int[] nums) {
        int n = nums.length;
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

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];

        int[] nums1 = new int[n-1];//holds all the elements of nums except nums[0]
        int[] nums2 = new int[n-1];//holds all the elements of nums except nums[n-1]
        int j=0, k =0;
        for(int i=0; i<n; i++){
            if(i!=0){
                nums1[j++] = nums[i];
            }
            if(i != n-1){
                nums2[k++] = nums[i];
            }
        }
        return Math.max(robber(nums1), robber(nums2));
    }
}
