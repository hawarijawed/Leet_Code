/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
*/
//------------------------- Approach 01 -------------------//
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0] != 0? 0: 1;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++){
            set.add(nums[i]);
        }
        for(int i=0; i<n; i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return n;
    }
}

//------------------------- Approach 02 -------------------//
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0] != 0? 0: 1;
        }
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(nums[i] != i){
                return i;
            }
        }
        return n;
    }
}
