/*
You are given an array of integers nums. Return the length of the longest subarray of nums which is either strictly increasing or strictly decreasing

*/
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int curr = 1;
        int res = 1;
        int increasing = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1] < nums[i]){
                if(increasing > 0){
                    curr++;
                }else{
                    curr = 2;
                    increasing = 1;
                }
            }
            else if(nums[i-1] > nums[i]){
                if(increasing < 0){
                    curr++;
                }
                else{
                    curr = 2;
                    increasing = -1;
                }
            }
            else{
                curr = 1;
                increasing = 0;
            }

            res = Math.max(res, curr);
        }

        return res;
    }
}
