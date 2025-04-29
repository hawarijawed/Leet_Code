/*
You are given an integer array nums and a positive integer k.

Return the number of subarrays where the maximum element of nums appears at least k times in that subarray.

A subarray is a contiguous sequence of elements within an array.
*/

class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max_val = nums[0];
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i] > max_val){
                max_val = nums[i];
            }
        }
        int left = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == max_val){
                count++;
            }
            while(count == k){
                res += (n - i);
                if(nums[left] == max_val){
                    count--;
                }
                left++;
            }
        }

        return res;
    }
}
