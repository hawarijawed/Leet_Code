/*
Given an integer array nums, return the number of subarrays filled with 0.

A subarray is a contiguous non-empty sequence of elements within an array.
*/
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long cnt = 0, streak = 0;
        for (int num : nums) {
            streak = (num == 0) ? streak + 1 : 0;
            cnt += streak;
        }
        return cnt;
    }
}
