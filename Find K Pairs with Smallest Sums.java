/*
You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.
*/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // Edge case: if any array is empty
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        // Min heap: stores [sum, i, j] where i, j are indices in nums1 and nums2
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Only insert first min(k, nums1.length) pairs (nums1[i], nums2[0]) to start
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            // Initial pairs with nums2[0]
            minHeap.offer(new int[] {nums1[i] + nums2[0], i, 0});
        }

        // Extract k pairs with the smallest sums
        while (k > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1], j = top[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Move to next element in nums2 (same row)
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[] {nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return result;
    }
}
