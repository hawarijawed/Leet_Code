/*
Given an array nums of integers, return how many of them contain an even number of digits.
*/

class Solution {
    public int findNumbers(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int i=0; i<n; i++){
            int val = nums[i];
            int count = 0;
            while(val > 0){
                count++;
                val /= 10;
            }

            if(count != 0 && count%2 == 0){
                res++;
            }
        }

        return res;
    }
}
