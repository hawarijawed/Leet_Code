/*
You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].

We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.

Return the largest number of chunks we can make to sort the array.
*/
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        int chunk = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, arr[i]);
            if(max < i+1){
                chunk++;
            }
        }

        return chunk;
    }
}
