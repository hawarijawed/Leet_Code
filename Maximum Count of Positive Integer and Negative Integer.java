/*
Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.

In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
Note that 0 is neither positive nor negative.
*/
class Solution {
    public int maximumCount(int[] nums) {
        int neg = 0, pos = 0;
        for(int val: nums){
            if(val < 0){
                neg++;
            }
            if(val > 0){
                pos++;
            }
        }

        return Math.max(pos, neg);
    }
}
