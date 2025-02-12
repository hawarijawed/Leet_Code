/*
You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

*/
class Solution {
    public int digitSum(int num){
        int sum = 0;
        
        while(num > 0){
            sum += num%10;
            num /= 10;
        }

        return sum;
    }
    public int maximumSum(int[] nums) {
        int sum = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            int digit_sum = digitSum(num);

            if(map.containsKey(digit_sum)){
                int prevNum = map.get(digit_sum); //Get the previous num value
                sum = Math.max(sum, prevNum + num);//calculate the max sum, 
                map.put(digit_sum, Math.max(prevNum, num));//put the maximum value in the mapping of digit_sum
            }
            else{
                map.put(digit_sum, num);
            }
        }
        return sum;
    }
}
