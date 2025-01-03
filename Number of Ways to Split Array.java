/*
You are given a 0-indexed integer array nums of length n.

nums contains a valid split at index i if the following are true:

The sum of the first i + 1 elements is greater than or equal to the sum of the last n - i - 1 elements.
There is at least one element to the right of i. That is, 0 <= i < n - 1.
Return the number of valid splits in nums.
*/
class Solution {

    public int waysToSplitArray(int[] nums) {
        // Keep track of sum of elements on left and right sides
        long leftSum = 0, rightSum = 0;

        // Initially all elements are on right side
        for (int num : nums) {
            rightSum += num;
        }

        int count = 0;
        // Try each possible split position
        for (int i = 0; i < nums.length - 1; i++) {
            // Move current element from right to left side
            leftSum += nums[i];
            rightSum -= nums[i];

            // Check if this creates a valid split
            if (leftSum >= rightSum) {
                count++;
            }
        }

        return count;
    }
}
