/*
Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
*/
class Solution {
    
    public int maxSumArray(int [] arr){
        int maxSum = arr[0];
        int currSum = arr[0];
        for(int i=1; i<arr.length; i++){
            currSum = Math.max(currSum + arr[i], arr[i]);
            maxSum = Math.max(maxSum, currSum);
            if(currSum < 0){
                currSum = 0;
            }
        }
        return maxSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length; 
        if(n==1) return nums[0];
        int total_sum = 0;
        int maxSum = maxSumArray(nums);
        for(int i=0; i<n; i++){
            total_sum += nums[i];
            nums[i] = -nums[i];
        }
        int minSum = maxSumArray(nums);

        int circular_sum = total_sum + minSum;
        if(circular_sum == 0) return maxSum;
        return Math.max(maxSum, circular_sum);
    }
}
