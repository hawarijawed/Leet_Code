/*
Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].
*/

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for(int arr[]: dominoes){
            int min = Math.min(arr[0], arr[1]);
            int max = Math.max(arr[0], arr[1]);
            arr[0] = min;
            arr[1] = max;
            int key = min*10 + max;
            int freq = map.getOrDefault(key, 0);
            map.put(key, freq+1);
            pairs += freq;
        }

        return pairs;
    }
}
