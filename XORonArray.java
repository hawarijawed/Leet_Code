/*
You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].
For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
Return an array answer where answer[i] is the answer to the ith query.
*/

//------------------------------------BruteForce Approach: O(M*Q)----------------------------------//
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int [] res = new int[queries.length];
        int ind = 0;
        for(int i=0; i<queries.length; i++){
            int first = queries[i][0];
            int second = queries[i][1];
            int xor = 0;
            if(first == second){
                res[ind] = arr[second];
                ind++;                
            }
            else {
                for(int j=first; j<=second; j++){
                    xor = xor ^ arr[j];
                }
                res[ind] = xor;
                ind++;
            }
        }

        return res;
    }
}
//------------------------------------BruteForce Approach: O(M*Q)----------------------------------//

