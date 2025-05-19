/*
You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.

A triangle is called equilateral if it has all sides of equal length.
A triangle is called isosceles if it has exactly two sides of equal length.
A triangle is called scalene if all its sides are of different lengths.
Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.
*/

class Solution {
    public String triangleType(int[] nums) {
        if(nums[0] + nums[1] <= nums[2] || nums[1] + nums[2] <= nums[0] || nums[0] + nums[2] <= nums[1]){
            return "none";
        }
        HashSet<Integer> set = new HashSet<>();
        for(int val: nums){
            set.add(val);
        }

        if(set.size() == 1){
            return "equilateral";
        }

        if(set.size() == 2){
            return "isosceles";
        }

        return "scalene";
    }
}
