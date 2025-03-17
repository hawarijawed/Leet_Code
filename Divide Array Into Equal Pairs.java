/*
You are given an integer array nums consisting of 2 * n integers.

You need to divide nums into n pairs such that:

Each element belongs to exactly one pair.
The elements present in a pair are equal.
Return true if nums can be divided into n pairs, otherwise return false.
*/
class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[501];
        for(int val: nums){
            arr[val]++;
        }

        for(int i=0; i<n; i++){
            if(arr[nums[i]]%2 != 0){
                return false;
            }
        }

        return true;
    }
}
