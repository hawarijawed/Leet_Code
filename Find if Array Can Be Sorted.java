/*
You are given a 0-indexed array of positive integers nums.

In one operation, you can swap any two adjacent elements if they have the same number of 
set bits
. You are allowed to do this operation any number of times (including zero).

Return true if you can sort the array, else return false.
*/
class Solution {
    public int countBits(int num){
        String str = Integer.toBinaryString(num);
        int count = 0;
        for(char ch: str.toCharArray()){
            if(ch == '1'){
                count++;
            }
        }
        return count;
    }
    public boolean canSortArray(int[] nums) {
        int last_max = 0;
        int current = nums[0];
        int bits = countBits(nums[0]);
        for(int i=1; i<nums.length; i++){
            boolean bitChange = bits != countBits(nums[i]);
            if(bitChange) last_max = current;
            
            if(nums[i] > current){
                current = nums[i];
                bits = countBits(current);
            }
            

            if(nums[i] < last_max) return false;
        }

        return true;
    }
}
