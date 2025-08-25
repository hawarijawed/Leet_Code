/*
Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
*/

class Solution {
    public int longestSubarray(int[] nums) {
       int n = nums.length;
       int longest_wind = 0;
       int curr_wind = 0;
       
       int left = 0;
       int right = 0;
       int zero_count=0;
       for(right = 0; right< nums.length; right++){
            if(nums[right] == 0){
                zero_count++;
            }

            if(zero_count >= 2){
                longest_wind = Math.max(longest_wind, right- left-1);
                while(zero_count >= 2){
                    if(nums[left] == 0){
                        zero_count--;
                    }
                    left++;
                }
            }
        }
        if(zero_count == 0) return nums.length - 1;
        if(zero_count == 1){
            longest_wind = Math.max(longest_wind, right - left-1);
        }
        return longest_wind;
    }
}
