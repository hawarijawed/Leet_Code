/*
You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:

Let i, i + 1, ..., j be the indices in the subarray. Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
Return the total number of continuous subarrays.

A subarray is a contiguous non-empty sequence of elements within an array.
*/
class Solution {
    public long continuousSubarrays(int[] nums) {
        int l = 0;
        long res = 0;  // Use long to avoid overflow
        Deque<Integer> minD = new LinkedList<>(), maxD = new LinkedList<>();

        for (int r = 0; r < nums.length; r++) {
            // Maintain the min deque
            while (!minD.isEmpty() && nums[minD.peekLast()] >= nums[r]) {
                minD.pollLast();
            }
            // Maintain the max deque
            while (!maxD.isEmpty() && nums[maxD.peekLast()] <= nums[r]) {
                maxD.pollLast();
            }

            // Add the current element index to the deques
            minD.offerLast(r);
            maxD.offerLast(r);

            // Shrink the window from the left until the condition holds
            while (nums[maxD.peekFirst()] - nums[minD.peekFirst()] > 2) {
                l++;
                if (minD.peekFirst() < l) minD.pollFirst();
                if (maxD.peekFirst() < l) maxD.pollFirst();
            }

            // Add the valid subarrays count from l to r
            res += r - l + 1;
        }

        return res;
    }
}
