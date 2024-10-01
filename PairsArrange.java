/*
Given an array of integers arr of even length n and an integer k.
We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.
Return true If you can find a way to do that or false otherwise.
*/
class Solution {
    public boolean canArrange(int[] arr, int k) {
        int n = arr.length;
        int [] freq = new int[k];
        for(int i=0; i<n; i++){
            int rem = (arr[i]%k + k)%k;
            freq[rem]++;
        }
        boolean flag = true;
        for(int i=1; i<k; i++){
            if(freq[i] != freq[k-i]){
                return false;
            }
        }
        // Handle special case for remainder 0
        if (freq[0] % 2 != 0) {
            return false;
        }
        return flag;
    }
}
