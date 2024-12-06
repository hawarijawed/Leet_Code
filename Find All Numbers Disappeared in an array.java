/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
*/
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        boolean arr[] = new boolean[100001];
        List<Integer> lst = new ArrayList<>();
        int n = nums.length;
        for(int val: nums){
            arr[val] = true;
        }

        for(int i=1; i<=n; i++){
            if(!arr[i]){
                lst.add(i);
            }
        }

        return lst;
    }
}
