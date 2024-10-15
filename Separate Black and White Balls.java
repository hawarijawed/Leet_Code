/*
There are n balls on a table, each ball has a color black or white.

You are given a 0-indexed binary string s of length n, where 1 and 0 represent black and white balls, respectively.

In each step, you can choose two adjacent balls and swap them.

Return the minimum number of steps to group all the black balls to the right and all the white balls to the left.
*/
class Solution {
    public long minimumSteps(String s) {
        int left = 0;
        int right = 0;
        long count = 0;
        while(right<s.length()){
            if(s.charAt(right) == '0'){
                count += right-left;
                left++;
            }
            right++;
        }

        return count;
    }
}
