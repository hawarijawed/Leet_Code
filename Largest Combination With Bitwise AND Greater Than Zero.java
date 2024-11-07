/*
The bitwise AND of an array nums is the bitwise AND of all integers in nums.

For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1.
Also, for nums = [7], the bitwise AND is 7.
You are given an array of positive integers candidates. Evaluate the bitwise AND of every combination of numbers of candidates. Each number in candidates may only be used once in each combination.

Return the size of the largest combination of candidates with a bitwise AND greater than 0.
*/
class Solution {
    public int largestCombination(int[] candidates) {
        int [] count = new int[32];
        for(int i=0; i<32; i++){
            count[i] = 0;
        }

        for(int a: candidates){
            int temp = 0;
            while(a > 0){
                count[temp] += 1 & a;
                temp++;
                a = a>>1;
            }
        }

        int max = 0;
        for(int val: count){
            if(val > max){
                max = val;
            }
        }

        return max;
    }
}
