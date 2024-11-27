/*
Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0] == 1?2:1;
        }

        for(int i=0; i<n; i++){
            if(nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] - 1]){
                while(nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i] - 1]){
                    int temp = nums[i];
                    nums[i] = nums[nums[i] -1];
                    nums[temp - 1] = temp;
                }
            }
        }
        
        int val = 1;
        for(int i = 0; i<n; i++){
            
            if(nums[i] != val){
                return val;
            }
            else{
                val++;
            }
        }

        return n+1;
    }
}
