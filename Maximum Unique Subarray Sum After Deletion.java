/*
You are given an integer array nums.

You are allowed to delete any number of elements from nums without making it empty. After performing the deletions, select a subarray of nums such that:

All elements in the subarray are unique.
The sum of the elements in the subarray is maximized.
Return the maximum sum of such a subarray.
*/
class Solution {
    public int maxSum(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for(int val: nums){
            maxVal = Math.max(val, maxVal);
        }

        if(maxVal < 0){
            return maxVal;
        }

        HashSet<Integer> set = new HashSet<>();
        int maxSum = nums[0];
        set.add(nums[0]);
        for(int i=0; i<nums.length; i++){
            if(!set.contains(nums[i]) && nums[i] >= 0){
                set.add(nums[i]);
                maxSum = Math.max(nums[i], maxSum + nums[i]);
            }
        }

        return maxSum;
    }
}
