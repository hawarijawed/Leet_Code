/*
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        String binary = Integer.toBinaryString(n);
        int count = 0;
        if(n==0) return false;
        if(n<0) return false;
        if(n==Integer.MAX_VALUE) return false;
        for(char ch: binary.toCharArray()){
            if(ch == '1'){
                count++;
            }

            if(count > 1){
                return false;
            }
        }
        return true;
    }
}
