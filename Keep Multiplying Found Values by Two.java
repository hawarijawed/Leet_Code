/*
You are given an array of integers nums. You are also given an integer original which is the first number that needs to be searched for in nums.

You then do the following steps:

If original is found in nums, multiply it by two (i.e., set original = 2 * original).
Otherwise, stop the process.
Repeat this process with the new number as long as you keep finding the number.
Return the final value of original.
*/
class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set = new HashSet<>();
        for(int val: nums){
            set.add(val);
        }
        
        while(true){
            if(set.contains(original)){
                original *= 2;
            }
            else{
                break;
            }
        }

        return original;
    }

    public int findFinalValue(int[] nums, int original){
        Arrays.sort(nums);
        while(true){
            if(BinarySearch(nums, original)){
                original *= 2;
            }
            else{
                break;
            }
        }

        return original;
    }

    public boolean BinarySearch(int[] nums, int original){
        int left = 0;
        int right = nums.length -1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == original) return true;
            if(nums[mid] > original){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        return false;
    }

    public int findFinalValue(int[] nums, int original){
        while(true){
            if(found(nums, original)){
                original *= 2;
            }
            else{
                break;
            }
        }

        return original;
    }

    public boolean found(int[] nums, int original){
        for(int val: nums){
            if(val == original) return true;
        }

        return false;
    }
}
