/*
Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.

A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.

Return the number of good triplets.
*/
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        int n = arr.length;
        for(int i=0; i<n-2; i++){
            for(int j=1+i; j<n-1; j++){
                for(int k=j+1; k<n;k++){
                    int x = Math.abs(arr[i] - arr[j]);
                    int y = Math.abs(arr[j] - arr[k]);
                    int z = Math.abs(arr[i] - arr[k]);
                    if(x <= a && y <= b && z <= c){
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
