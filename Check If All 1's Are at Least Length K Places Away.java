/*
Given an binary array nums and an integer k, return true if all 1's are at least k places away from each other, otherwise return false.
*/
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                if (lastIndex != -1 && i - lastIndex - 1 < k) {
                    return false;
                }
                lastIndex = i;
            }
        }

        return true;
    }
}
