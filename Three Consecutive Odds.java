/*
Given an integer array arr, return true if there are three consecutive odd numbers in the array. Otherwise, return false.
*/

class Solution {
    public boolean checkOdd(int [] arr, int left, int right){
        for(int i=left; i<=right; i++){
            if(arr[i]%2 == 0) return false;
        }

        return true;
    }
    public boolean threeConsecutiveOdds(int[] arr) {
        int left = 0, right = left + 2;
        int n = arr.length;
        while(right < n){
            if(checkOdd(arr, left, right)){
                return true;
            }
            left++;
            right++;
        }

        return false;
    }
}
