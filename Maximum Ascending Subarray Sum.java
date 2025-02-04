/*
Given an array of positive integers nums, return the maximum possible sum of an ascending subarray in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

A subarray [numsl, numsl+1, ..., numsr-1, numsr] is ascending if for all i where l <= i < r, numsi  < numsi+1. Note that a subarray of size 1 is ascending.
*/
public class Solution {

    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int currentSubarraySum = nums[0];

        // Loop through the array starting from the second element
        for (int currentIdx = 1; currentIdx < nums.length; ++currentIdx) {
            if (nums[currentIdx] <= nums[currentIdx - 1]) {
                // If the current element is not greater than the previous one,
                // update maxSum
                maxSum = Math.max(maxSum, currentSubarraySum);
                // Reset the sum for the next ascending subarray
                currentSubarraySum = 0;
            }
            currentSubarraySum += nums[currentIdx];
        }

        // Final check after the loop ends to account for the last ascending
        // subarray
        return Math.max(maxSum, currentSubarraySum);
    }
}
