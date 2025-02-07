/*
You are given an integer limit and a 2D array queries of size n x 2.

There are limit + 1 balls with distinct labels in the range [0, limit]. Initially, all balls are uncolored. For every query in queries that is of the form [x, y], you mark ball x with the color y. After each query, you need to find the number of distinct colors among the balls.

Return an array result of length n, where result[i] denotes the number of distinct colors after ith query.

Note that when answering a query, lack of a color will not be considered as a color.
*/
class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> ball = new HashMap<>(), color = new HashMap<>();
        int n = queries.length, distinct = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            int pos = queries[i][0], c = queries[i][1];
            if(ball.containsKey(pos)){
                int cnt = color.get(ball.get(pos)) - 1;
                if(cnt == 0){ color.remove(ball.get(pos)); distinct--; }
                else color.put(ball.get(pos), cnt);
            }
            ball.put(pos, c);
            int cnt = color.getOrDefault(c, 0) + 1;
            color.put(c, cnt);
            if(cnt == 1) distinct++;
            ans[i] = distinct;
        }
        return ans;
    }
}
