/*
The score of an array is defined as the product of its sum and its length.

For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
Given a positive integer array nums and an integer k, return the number of non-empty subarrays of nums whose score is strictly less than k.

A subarray is a contiguous sequence of elements within an array.
*/

class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int start = 0;
        long sum = 0;
        long count = 0;
        for(int end = 0; end < n; end++){
            sum += nums[end];
            while(sum * (end - start + 1) >= k){
                sum -= (long) nums[start];
                start++;
            }

            count += (long) (end - start + 1);
        }

        return count;
    }
}
