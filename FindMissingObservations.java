/*
You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing, and you only have the observations of m rolls. Fortunately, you have also calculated the average value of the n + m rolls.

You are given an integer array rolls of length m where rolls[i] is the value of the ith observation. You are also given the two integers mean and n.

Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean. If there are multiple valid answers, return any of them. If no such array exists, return an empty array.

The average value of a set of k numbers is the sum of the numbers divided by k.

Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.
*/
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int size = rolls.length;
        int first_sum = 0;
        for(int a: rolls){
            first_sum += a;
        }
        //Get the sum of missing observations
        int missing_sum = mean*(size + n) - first_sum;
        //Criteria to be Invalid missing observations
        if(missing_sum > 6*n || missing_sum < n){
            return new int[0];
        }

        int avg = missing_sum / n;
        int rem = missing_sum % n;
        int [] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = avg;
            //Distribute the rem 1 by 1 to each elements
            if(rem > 0){
                arr[i]+=1;
                rem--;
            }
        }
        return arr;
    }
}
