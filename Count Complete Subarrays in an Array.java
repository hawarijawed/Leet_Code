/*
You are given an array nums consisting of positive integers.

We call a subarray of an array complete if the following condition is satisfied:

The number of distinct elements in the subarray is equal to the number of distinct elements in the whole array.
Return the number of complete subarrays.

A subarray is a contiguous non-empty part of an array.
*/

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int val: nums){
            set.add(val);
        }
        int n = nums.length;
        int distinct = set.size();
        int left = 0;
        int Distinct_count = 0;
        int count = 0;
        for(int right = 0; right < n; right++){
            if(map.getOrDefault(nums[right], 0) == 0){
                Distinct_count++;
            }

            map.put(nums[right], map.getOrDefault(nums[right], 0)+1);

            while(Distinct_count == distinct){
                count += (n - right);
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    Distinct_count--;
                }
                left++;
            }
        }

        return count;
    }
}
