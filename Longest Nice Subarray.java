/*
You are given an array nums consisting of positive integers.

We call a subarray of nums nice if the bitwise AND of every pair of elements that are in different positions in the subarray is equal to 0.

Return the length of the longest nice subarray.

A subarray is a contiguous part of an array.

Note that subarrays of length 1 are always considered nice.
*/
class Solution {
    public int longestNiceSubarray(int[] nums) {
        int len = 1;
        int n  = nums.length;
        int st = 0;
        int bitMask = 0;
        for(int en = 0; en < n; en++){
            while((bitMas & nums[en]) != 0){
                bitMask = bitMask ^ nums[st];
                st++;
            }
            bitMask = bitMask | nums[en];
            len = Math.max(len, en - st + 1);
        }
        return len;
    }
}
