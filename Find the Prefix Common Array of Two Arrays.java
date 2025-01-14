/*
You are given two 0-indexed integer permutations A and B of length n.

A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.

Return the prefix common array of A and B.

A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.
*/
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int freq[] = new int[n+1];
        int count = 0;
        int C[] = new int[n];
        
        for(int i=0; i<n; i++){
            freq[A[i]]++;
            if(freq[A[i]]==2) count++;

            freq[B[i]]++;
            if(freq[B[i]]==2) count++;

            C[i] = count;
        }
        return C;
    }
}
