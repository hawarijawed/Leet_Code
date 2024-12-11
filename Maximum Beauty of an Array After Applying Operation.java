/*
You are given a 0-indexed array nums and a non-negative integer k.

In one operation, you can do the following:

Choose an index i that hasn't been chosen before from the range [0, nums.length - 1].
Replace nums[i] with any integer from the range [nums[i] - k, nums[i] + k].
The beauty of the array is the length of the longest subsequence consisting of equal elements.

Return the maximum possible beauty of the array nums after applying the operation any number of times.

Note that you can apply the operation to each index only once.

A subsequence of an array is a new array generated from the original array by deleting some elements (possibly none) without changing the order of the remaining elements.

*/
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        if(nums.length==1) return 1;
        int max = 0;
        for(int val: nums){
            max = Math.max(max, val);
        }

        int[] arr = new int[max+1];
        for(int i=0; i<nums.length; i++){
            arr[Math.max(nums[i]-k,0)]++;
            arr[Math.min(nums[i]+k+1,max)]--;
        }

        //Find the max prefix sum
        int curr_sum = 0, max_sum = 0;
        for(int val: arr){
            curr_sum += val;
            max_sum = Math.max(curr_sum, max_sum);
        }

        return max_sum;
    }
}
