/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] lis = new int[n];
        Arrays.fill(lis, 1);
        int maxLen = 1; //Holds the max length of Subsequence
        for(int i=1; i<n; i++){
            for(int p = 0; p<i; p++){
                if(nums[p] < nums[i]){
                    lis[i] = Math.max(lis[i], 1 + lis[p]);
                }
            }
            maxLen = Math.max(maxLen, lis[i]);
        }
        return maxLen;
    }
}
