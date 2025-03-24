/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
*/
class Solution {
    public int[] countBits(int n) {
        int [] arr = new int[n+1];
        arr[0] = 0;
        for(int i=1; i<=n; i++){
            arr[i] = arr[i>>1] + (i&1);
        }
        return arr;
    }
}
