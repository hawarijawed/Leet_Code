/*
You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.
*/

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        int lastMin = -1; // Last index where nums[i] == minK
        int lastMax = -1; // Last index where nums[i] == maxK
        int lastInvalid = -1; // Last index where nums[i] < minK || nums[i] > maxK
        long count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                lastInvalid = i;
            }
            if (nums[i] == minK) {
            lastMin = i;
        }
        if (nums[i] == maxK) {
            lastMax = i;
            }

            int validStart = Math.min(lastMin, lastMax);
            if (validStart > lastInvalid) {
                count += validStart - lastInvalid;
            }
        }

        return count;  
    }
}
