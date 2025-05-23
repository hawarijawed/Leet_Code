/*
You are given a 2D integer grid of size m x n and an integer x. In one operation, you can add x to or subtract x from any element in the grid.

A uni-value grid is a grid where all the elements of it are equal.

Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.
*/
class Solution {

    public int minOperations(int[][] grid, int x) {
        // Initialize an empty array to store all numbers
        ArrayList<Integer> numsArray = new ArrayList<>();
        int result = Integer.MAX_VALUE;

        // Flatten the grid into numsArray and check if all elements have the same remainder when divided by x
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // If remainder of any element doesn't match the first element, return -1
                if (grid[row][col] % x != grid[0][0] % x) return -1;
                numsArray.add(grid[row][col]);
            }
        }

        // Sort numsArray in non-decreasing order to easily calculate operations
        Collections.sort(numsArray);

        int length = numsArray.size();
        int[] prefixSum = new int[length];
        int[] suffixSum = new int[length];

        // Calculate the prefix sum up to each index (excluding the current element)
        for (int index = 1; index < length; index++) {
            prefixSum[index] = prefixSum[index - 1] + numsArray.get(index - 1);
        }

        // Calculate the suffix sum from each index (excluding the current element)
        for (int index = length - 2; index >= 0; index--) {
            suffixSum[index] = suffixSum[index + 1] + numsArray.get(index + 1);
        }

        // Iterate through numsArray to calculate the number of operations for each potential common value
        for (int index = 0; index < length; index++) {
            int leftOperations =
                (numsArray.get(index) * index - prefixSum[index]) / x;
            int rightOperations =
                (suffixSum[index] -
                    numsArray.get(index) * (length - index - 1)) /
                x;
            // Update the result with the minimum operations needed
            result = Math.min(result, leftOperations + rightOperations);
        }

        return result;
    }
}
