/*
Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x
*/

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<=0) return false;
        //if(n<0) n = -n;
        while(n%3==0){
            n = n/3;
        }
        return n==1;
    }

    public boolean isPowerOfThree(int n){
        if (n <= 0) return false;
        double logResult = Math.log10(n) / Math.log10(3);
        return Math.abs(logResult - Math.round(logResult)) < 1e-10;
    }
}
