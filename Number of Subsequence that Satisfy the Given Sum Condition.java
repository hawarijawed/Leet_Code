/*
You are given an array of integers nums and an integer target.

Return the number of non-empty subsequences of nums such that the sum of the minimum and maximum element on it is less or equal to target. Since the answer may be too large, return it modulo 109 + 7.
*/
class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        long res = 0;
        int C = 1000000007;
        int []power = new int[n];
        power[0] = 1;
        for(int i=1; i<n; i++){
            power[i] = (power[i-1]*2)%C;
        }
        int i=0, j=n-1;
        while(i<=j){
            if(nums[i] + nums[j] <= target){
                res = (res + power[j-i])%C;
                i++;
            }
            else{
                j--;
            }
        }

        return (int)res%C;
    }
}
