/*
You are given a binary array nums.

You can do the following operation on the array any number of times (possibly zero):

Choose any 3 consecutive elements from the array and flip all of them.
Flipping an element means changing its value from 0 to 1, and from 1 to 0.

Return the minimum number of operations required to make all elements in nums equal to 1. If it is impossible, return -1.
*/
class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int st = 0; st<(n-2); st++){
            if(nums[st] == 0){
                nums[st] = 1 - nums[st];
                nums[st+1] = 1 - nums[st+1];
                nums[st+2] = 1 - nums[st+2];
                count++;
            }
        }

        if(nums[n-1] == 0 || nums[n-2] == 0){
            //Not possible to convert into all elements equal to 1
            return -1;
        }

        return count;
    }
}
