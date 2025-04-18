/*
You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.

A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.

Return the length longest chain which can be formed.

You do not need to use up all the given intervals. You can select pairs in any order.
*/
//DP approach, Time: O(n^2) + nlog(n)
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        int n = pairs.length;
        int []lis = new int[n];
        Arrays.fill(lis, 1);
        int count = 1;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    lis[i] = Math.max(1 + lis[j], lis[i]);
                }
            }

            count = Math.max(count, lis[i]);
        }
        return count;
    }
}

//Greedy Approach, Time: n + nlog(n)
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int n = pairs.length;
        int currEnd = Integer.MIN_VALUE;
        int chain = 0;
        for(int i=0; i<n; i++){
            if(pairs[i][0] > currEnd){
                chain++;
                currEnd = pairs[i][1];
            }
        }

        return chain;
    }
}
