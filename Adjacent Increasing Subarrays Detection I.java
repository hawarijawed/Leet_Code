/*
Given an array nums of n integers and an integer k, determine whether there exist two adjacent subarrays of length k such that both subarrays are strictly increasing. Specifically, check if there are two subarrays starting at indices a and b (a < b), where:

Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
The subarrays must be adjacent, meaning b = a + k.
Return true if it is possible to find two such subarrays, and false otherwise.
*/
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
       for(int start = 0; start <= nums.size() - 2*k; start++){
          if(isIncreasing(nums, start,k) && isIncreasing(nums, start+k, k)){
            return true;
          }
        }
        return false;
    }

    public boolean isIncreasing(List<Integer> nums, int start, int k){
        for(int i=start+1; i<= start + k -1; i++){
            if(nums.get(i-1) >= nums.get(i)){
                return false;
            }
        }

        return true;
    }
}

/*
2,5,7,8,9,2,3,4,3,1
k = 3
st = 0
en = k+st-1

st = 2;
en = k + st -1
*/
