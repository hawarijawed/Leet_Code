/*
Given an integer array nums, find the maximum possible bitwise OR of a subset of nums and return the number of different non-empty subsets with the maximum bitwise OR.

An array a is a subset of an array b if a can be obtained from b by deleting some (possibly zero) elements of b. Two subsets are considered different if the indices of the elements chosen are different.

The bitwise OR of an array a is equal to a[0] OR a[1] OR ... OR a[a.length - 1] (0-indexed).
*/
class Solution {
    public int Recursion(int ind, int [] nums, int currOr, int targetOr){
        if(ind == nums.length){
            return currOr == targetOr?1:0;
        }

        //Pick
        int pickCount = Recursion(ind+1, nums, currOr|nums[ind], targetOr);
        //Not picked element
        int noPickCount = Recursion(ind+1, nums, currOr, targetOr);
        return pickCount + noPickCount;
    }
    public int countMaxOrSubsets(int[] nums) {
        int OR = 0;
        for(int i=0; i<nums.length; i++){
            OR |= nums[i];
        }

        return Recursion(0, nums, 0, OR);
    }
}
