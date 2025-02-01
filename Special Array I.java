/*
An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.

*/
class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        if(n==1) return true;
        int left = 0, right=1;
        while(right < n){
            if(nums[left]%2==0 && nums[right]%2==0){
                return false;
            }
            else if(nums[left]%2!=0 && nums[right]%2!=0){
                return false;
            }else{
                left++;
                right++;
            }
        }
        return true;
    }
}
