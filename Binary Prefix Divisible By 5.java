/*
You are given a binary array nums (0-indexed).

We define xi as the number whose binary representation is the subarray nums[0..i] (from most-significant-bit to least-significant-bit).

For example, if nums = [1,0,1], then x0 = 1, x1 = 2, and x2 = 5.
Return an array of booleans answer where answer[i] is true if xi is divisible by 5.
*/
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int prefix = 0;
        int length = nums.length;
        for(int i=0; i<length; i++){
            prefix = ((prefix << 1) + nums[i])%5;
            ans.add(prefix == 0);
        }

        return ans;
    }
}
