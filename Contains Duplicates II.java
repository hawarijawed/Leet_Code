/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int st = 0;
        for(int en=0; en<nums.length; en++){
            if(en - st > k){
                set.remove(nums[st]);
                st++;
            }

            if(set.contains(nums[en])){
                return true;
            }

            set.add(nums[en]);
        }

        return false;
    }
}
