/*
You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
*/

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;

        // Step 1: Pair value with its index
        int[][] paired = new int[n][2];
        for (int i = 0; i < n; i++) {
            paired[i][0] = nums[i]; // value
            paired[i][1] = i;       // original index
        }

        // Step 2: Sort by value descending
        Arrays.sort(paired, (a, b) -> b[0] - a[0]);

        // Step 3: Select top k elements
        int[][] topK = Arrays.copyOfRange(paired, 0, k);

        // Step 4: Sort the top k by their original indices
        Arrays.sort(topK, Comparator.comparingInt(a -> a[1]));

        // Step 5: Extract the values in correct order
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][0];
        }

        return result;
    }
}
