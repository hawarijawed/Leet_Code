/*
You are given an integer array nums of size n.

Consider a non-empty subarray from nums that has the maximum possible bitwise AND.

In other words, let k be the maximum value of the bitwise AND of any subarray of nums. Then, only subarrays with a bitwise AND equal to k should be considered.
Return the length of the longest such subarray.

The bitwise AND of an array is the bitwise AND of all the numbers in it.

A subarray is a contiguous sequence of elements within an array.
*/

class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        int ans = 0;
        int current_streak = 0;
        
        for(int i=0; i<nums.length; i++){
            if(maxVal < nums[i]){
                maxVal = nums[i];
                ans = 0; 
                current_streak = 0;
            }
            if(maxVal == nums[i]){
                current_streak++;
            }
            else{
                current_streak = 0;
            }

            ans = Math.max(ans, current_streak);
        }

        return ans;
    }
}
