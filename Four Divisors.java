/*
Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors. If there is no such integer in the array, return 0.
*/
class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        int count = 0;

        for(int val: nums){
            sum += findDivisors(val);
        }

        return sum;
    }

    public int findDivisors(int n){
        
        int count = 0;
        int sum = 0;
        int i=1;
        while(i*i <= n){
            if(n%i == 0){
                sum += i;
                count++;
                if(i != n/i){
                    sum += n/i;
                    count++;
                }
            }
            i++;
        }

        if(count == 4){
            return sum;
        }

        return 0;
    }
}

/*

*/
