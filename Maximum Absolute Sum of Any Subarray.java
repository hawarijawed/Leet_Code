/*
You are given an integer array nums. The absolute sum of a subarray [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).

Return the maximum absolute sum of any (possibly empty) subarray of nums.

Note that abs(x) is defined as follows:

If x is a negative integer, then abs(x) = -x.
If x is a non-negative integer, then abs(x) = x.
*/
class Solution {

    public int maxAbsoluteSum(int[] nums) {
        int minPrefixSum = Integer.MAX_VALUE, maxPrefixSum = Integer.MIN_VALUE;
        int prefixSum = 0, maxAbsSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Prefix sum from index 0 to i
            prefixSum += nums[i];

            // Minimum & Maximum prefix sum we have seen so far
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
            maxPrefixSum = Math.max(maxPrefixSum, prefixSum);

            if (prefixSum >= 0) {
                // If the prefixSum is positive, we will get the difference between prefixSum &
                // minPrefixSum
                maxAbsSum = Math.max(
                    maxAbsSum,
                    Math.max(prefixSum, prefixSum - minPrefixSum)
                );
            } else if (prefixSum <= 0) {
                // If the prefixSum is negative, we will get the absolute difference between
                // prefixSum & maxPrefixSum
                maxAbsSum = Math.max(
                    maxAbsSum,
                    Math.max(
                        Math.abs(prefixSum),
                        Math.abs(prefixSum - maxPrefixSum)
                    )
                );
            }
        }

        return maxAbsSum;
    }
}
